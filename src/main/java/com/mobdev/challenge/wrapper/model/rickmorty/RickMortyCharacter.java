package com.mobdev.challenge.wrapper.model.rickmorty;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class RickMortyCharacter {
	private int id;
	private String name;
	private String status;
	private String species;
	private String type;
	private String gender;
	private RickMortyOrigin origin;
	private RickMortyLocation location;
	private String image;
	private List<String> episode;
	private String url;
	
}
