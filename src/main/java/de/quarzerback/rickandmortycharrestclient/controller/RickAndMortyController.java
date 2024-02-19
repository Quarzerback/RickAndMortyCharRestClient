package de.quarzerback.rickandmortycharrestclient.controller;

import de.quarzerback.rickandmortycharrestclient.model.RickAndMortyApiResponse;
import de.quarzerback.rickandmortycharrestclient.model.RickAndMortyChar;
import de.quarzerback.rickandmortycharrestclient.service.RickAndMortyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RickAndMortyController {

    private final RickAndMortyService service;

    @GetMapping
    public RickAndMortyApiResponse getAllRickAndMortyChars(){
        return service.getAllRickAndMortyChars();
    }

    @GetMapping("/characters/{id}")
    public RickAndMortyChar getCharacterById(@PathVariable int id){
        return service.getCharacterById(id);
    }

    @GetMapping("/characters/search")
    public List<RickAndMortyChar> getFilteredCharacters(
            @RequestParam(required = false) String status
    ){
        return service.getFilteredCharacters(status);

    }

    @GetMapping("/species-statistic")
    public long getAliveCharacters(
            @RequestParam(required = false) String species
    ){
        return service.getAliveCharacters(species);

    }

}
