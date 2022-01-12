package com.mobdev.challenge.wrapper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mobdev.challenge.wrapper.enums.WrapperType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString
public class FindResponse {
	@JsonIgnore
	private WrapperType wrapperType;

}
