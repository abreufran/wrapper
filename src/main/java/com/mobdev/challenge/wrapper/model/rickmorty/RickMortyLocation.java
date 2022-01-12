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
public class RickMortyLocation {
	private int id;
	private String name;
	private String type;
	private String dimension;
	private List<String> residents;
	private String url;
}
