package com.foo.demo.batch;

import com.foo.demo.service.TransformService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
    public class BatchProcessor implements CommandLineRunner {
        private static final String INPUT_FILE = "input.txt";
        private static final String OUTPUT_FILE = "output.txt";


        private final TransformService transformService;

    public BatchProcessor(TransformService transformService) {
        this.transformService = transformService;
    }

    @Override
        public void run(String... args) throws Exception {
        Path path = Paths.get(INPUT_FILE);
        Path pathOut = Paths.get(OUTPUT_FILE);

        if (!Files.exists(path)) {
                System.out.println("Aucun fichier trouve");
            return;
            }

            try (BufferedReader reader = Files.newBufferedReader(path);
                 BufferedWriter writer = Files.newBufferedWriter(pathOut)) {

                reader.lines()// lecture du fichier de donnees
                        .map(String::trim)
                        .filter(line -> !line.isEmpty())
                        .map(Integer::parseInt)
                        .map(transformService::transformBatchProcessing) // mapping des donnnes du fichier avec le service de transformation
                        .forEach(result -> {
                            try {
                                System.out.println("fin du ");
                                writer.write( result); // Ecriture du resultat sur le fichier de sortie
                                System.out.println(result);
                                writer.newLine();
                            } catch (IOException e) {
                                throw new UncheckedIOException(e);
                            }
                        });
            }

            System.out.println("fin du processus.");
        }
}
