package de.quarzerback.rickandmortycharrestclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RickAndMortyApiResponse {
    List<RickAndMortyChar> results;
}
