package com.mobdev.challenge.wrapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mobdev.challenge.wrapper.enums.WrapperType;
import com.mobdev.challenge.wrapper.model.FindRequest;
import com.mobdev.challenge.wrapper.model.FindResponse;
import com.mobdev.challenge.wrapper.service.processor.WrapperService;


@RestController
public class RickMortyWrapperController {

	@Autowired
	private WrapperService wrapperService;
	
	@GetMapping(value = "/rick-morty-api/character/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<? extends FindResponse> findCharacter(@PathVariable int id) {
		return wrapperService.find(FindRequest.builder()
									.wrapperType(WrapperType.RICKY_MORTY)
									.id(id)
									.build());
	}
}
