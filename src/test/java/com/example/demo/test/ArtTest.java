package com.example.demo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.service.ArtService;


@SpringBootTest
class ArtTest {

	@Autowired
	ArtService artService;
	
	@Test
	void testGetArts() {
		assertNotNull(artService.getArts());
	}

}
