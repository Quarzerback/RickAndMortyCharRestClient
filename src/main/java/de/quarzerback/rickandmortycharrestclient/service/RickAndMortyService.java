package de.quarzerback.rickandmortycharrestclient.service;

import de.quarzerback.rickandmortycharrestclient.model.RickAndMortyApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RickAndMortyService {

    private RestClient restClient = RestClient.builder()
            .baseUrl("https://rickandmortyapi.com/api")
            .build();

    public RickAndMortyApiResponse getAllRickAndMortyChars() {

        RickAndMortyApiResponse response = restClient.get()
                .uri("/character")
                .retrieve()
                .body(RickAndMortyApiResponse.class);
        return response;
    }
}
