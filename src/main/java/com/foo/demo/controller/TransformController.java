package com.foo.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.foo.demo.service.TransformService;

public class TransformController {


    @RestController
    @RequestMapping("/foo/bar")
    public static class transformNumberController {

        @GetMapping("/{nombre}")
        public ResponseEntity<String> getNumberAndTransform(@PathVariable int nombre) {
            if (nombre < 0 || nombre > 100) {
                return ResponseEntity.badRequest().body("le nombre doit etre compris entre 0 et 100");
            }
            return ResponseEntity.ok(TransformService.getTransformNumber(nombre));
        }
    }

}
