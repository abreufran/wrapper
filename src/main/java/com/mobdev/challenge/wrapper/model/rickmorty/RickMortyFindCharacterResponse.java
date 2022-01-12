package com.mobdev.challenge.wrapper.model.rickmorty;

import com.mobdev.challenge.wrapper.model.FindResponse;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Getter
@SuperBuilder
@ToString
public class RickMortyFindCharacterResponse extends FindResponse {
	private int id;
	private String name;
	private String status;
	private String species;
	private String type;
	private int episode_count;
	private RickMortyOriginResponse origin;
}
