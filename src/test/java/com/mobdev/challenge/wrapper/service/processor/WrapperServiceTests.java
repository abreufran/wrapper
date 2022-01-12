package com.mobdev.challenge.wrapper.service.processor;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mobdev.challenge.wrapper.enums.WrapperType;
import com.mobdev.challenge.wrapper.model.FindRequest;
import com.mobdev.challenge.wrapper.model.FindResponse;
import com.mobdev.challenge.wrapper.model.rickmorty.RickMortyFindCharacterResponse;

@SpringBootTest
public class WrapperServiceTests {
	
	@Autowired
	private WrapperService wrapperService;

	@Test
	void findTest() {
		ResponseEntity<FindResponse> response = wrapperService.find(FindRequest.builder()
								.wrapperType(WrapperType.RICKY_MORTY)
								.id(3)
								.build());
		
		RickMortyFindCharacterResponse rickMortyFindCharacterResponse = (RickMortyFindCharacterResponse) response.getBody();
		
		assertTrue(response.getStatusCode() == HttpStatus.OK && rickMortyFindCharacterResponse.getName() != null);
		
		response = wrapperService.find(FindRequest.builder()
				.wrapperType(WrapperType.RICKY_MORTY)
				.id(33435345)
				.build());
		
		assertTrue(response.getStatusCode() == HttpStatus.NOT_FOUND);
		
	}
}
