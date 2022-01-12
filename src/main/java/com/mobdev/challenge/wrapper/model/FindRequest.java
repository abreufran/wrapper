package com.mobdev.challenge.wrapper.model;

import com.mobdev.challenge.wrapper.enums.WrapperType;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Setter
@Getter
@SuperBuilder
public class FindRequest {
	private WrapperType wrapperType;
	private int id;
}
