package com.mobdev.challenge.wrapper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mobdev.challenge.wrapper.enums.WrapperType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class FindResponse {
	@JsonIgnore
	private WrapperType wrapperType;

}
