package com.mobdev.challenge.wrapper.service.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mobdev.challenge.wrapper.model.FindRequest;
import com.mobdev.challenge.wrapper.model.FindResponse;
import com.mobdev.challenge.wrapper.model.NotFoundFindResponse;
import com.mobdev.challenge.wrapper.model.rickmorty.RickMortyCharacter;
import com.mobdev.challenge.wrapper.model.rickmorty.RickMortyFindCharacterResponse;
import com.mobdev.challenge.wrapper.model.rickmorty.RickMortyLocation;
import com.mobdev.challenge.wrapper.model.rickmorty.RickMortyOriginResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RickMortyWrapperService extends AbstractWrapperService {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
    private Environment env;
	

	@Override
	public ResponseEntity<FindResponse> find(FindRequest findRequest) {
		RickMortyCharacter character = findCharacter(findRequest.getId());
		
		if(character == null) {
			return new ResponseEntity<FindResponse>(NotFoundFindResponse.builder()
														.message("The character does not exist " + findRequest.getId())
														.build(), HttpStatus.NOT_FOUND);
		}
		
		RickMortyLocation location = null;
		RickMortyOriginResponse locationResponse = null;
				
		if(character.getOrigin().getUrl().lastIndexOf("/") != -1) {		
			location = findLocation(getLocationId(character.getOrigin().getUrl()));
			locationResponse = RickMortyOriginResponse.builder()
					.name(location.getName())
					.url(location.getUrl())
					.dimension(location.getDimension())
					.residents(location.getResidents())
					.build();
		}
		
		RickMortyFindCharacterResponse rickMortyFindCharacterResponse = RickMortyFindCharacterResponse.builder()
												.id(character.getId())
												.name(character.getName())
												.status(character.getStatus())
												.species(character.getSpecies())
												.type(character.getType())
												.episode_count(character.getEpisode().size())
												.origin(locationResponse)
												.build();
		
		log.debug("rickMortyFindCharacterResponse: {}", rickMortyFindCharacterResponse.toString());
		
		return new ResponseEntity<>(rickMortyFindCharacterResponse, HttpStatus.OK);
		
	}
	
	public RickMortyCharacter findCharacter(int id) {
		try {
		
			HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	
	        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
	        String url = env.getProperty("rick.marty.find.character");
	        ResponseEntity<RickMortyCharacter> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, RickMortyCharacter.class,id);
	        
	        return responseEntity.getBody();
        
		}
		catch (Exception e) {
			log.error("The character does not exist {}", id);
			return null;
		}
	}
	
	private int getLocationId(String locationUrl) {
		return Integer.parseInt(locationUrl.substring(locationUrl.lastIndexOf("/") + 1));
	}
	
	public RickMortyLocation findLocation(int id) {
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        String url = env.getProperty("rick.marty.find.location");
        ResponseEntity<RickMortyLocation> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, RickMortyLocation.class,id);
        
        return responseEntity.getBody();
	}
		
}

