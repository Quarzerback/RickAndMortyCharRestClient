package de.quarzerback.rickandmortycharrestclient.service;

import de.quarzerback.rickandmortycharrestclient.model.RickAndMortyApiResponse;
import de.quarzerback.rickandmortycharrestclient.model.RickAndMortyChar;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

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

    public RickAndMortyChar getCharacterById(int id) {
        RickAndMortyChar response = restClient.get()
                .uri("/character/" + id)
                .retrieve()
                .body(RickAndMortyChar.class);
        return response;
    }

    public List<RickAndMortyChar> getFilteredCharacters(String status){
        RickAndMortyApiResponse response = restClient.get()
                .uri("/character")
                .retrieve()
                .body(RickAndMortyApiResponse.class);

            return response.getResults().stream()
                    .filter(character -> status.equalsIgnoreCase(character.getStatus()))
                    .collect(Collectors.toList());
        }

    public long getAliveCharacters(String species){
       return getFilteredCharacters("Alive").stream()
                .filter(character -> species.equalsIgnoreCase(character.getSpecies()))
                .count();
    }


}
