package com.foo.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.foo.demo.service.TransformService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testDivisibleRules() {
		assertEquals("BARBAR", TransformService.getTransformNumber(5));
		assertEquals("FOOFOO", TransformService.getTransformNumber(3));
		assertEquals("FOOBARBAR", TransformService.getTransformNumber(15));
	}

	@Test
	void testContainsRules() {
		assertEquals("FOOBAR", TransformService.getTransformNumber(51));
	}

	@Test
	void testNoMatch() {
		assertEquals("1", TransformService.getTransformNumber(1));
	}

}
