package de.quarzerback.rickandmortycharrestclient.controller;

import de.quarzerback.rickandmortycharrestclient.model.RickAndMortyApiResponse;
import de.quarzerback.rickandmortycharrestclient.service.RickAndMortyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rickandmorty")
@RequiredArgsConstructor
public class RickAndMortyController {

    private final RickAndMortyService service;

    @GetMapping
    public RickAndMortyApiResponse getAllRickAndMortyChars(){
        return service.getAllRickAndMortyChars();
    }

}
