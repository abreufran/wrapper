package com.mobdev.challenge.wrapper.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Setter
@Getter
@SuperBuilder
public class NotFoundFindResponse extends FindResponse {
	private String message;

}
