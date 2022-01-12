package com.mobdev.challenge.wrapper.service.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mobdev.challenge.wrapper.model.FindRequest;
import com.mobdev.challenge.wrapper.model.FindResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WrapperService {
	
	@Autowired
	private RickMortyWrapperService rickMortyWrapperService;
	
	public ResponseEntity<FindResponse> find(FindRequest findRequest) {
		switch(findRequest.getWrapperType()) {
			case RICKY_MORTY:
				return rickMortyWrapperService.find(findRequest);

			default:
				log.error("Wrapper Type Not Implemented: {}", findRequest); 
				return new ResponseEntity<FindResponse>(new FindResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
