package com.mobdev.challenge.wrapper.service.processor;

import org.springframework.http.ResponseEntity;

import com.mobdev.challenge.wrapper.model.FindRequest;
import com.mobdev.challenge.wrapper.model.FindResponse;

public abstract class AbstractWrapperService {
	
	public abstract ResponseEntity<FindResponse> find(FindRequest findRequest);

}
