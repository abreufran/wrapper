package com.mobdev.challenge.wrapper.model.rickmorty;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Setter
@Getter
@SuperBuilder
@ToString
public class RickMortyOriginResponse {
	private String name;
	private String url;
	private String dimension;
	private List<String> residents;
}
