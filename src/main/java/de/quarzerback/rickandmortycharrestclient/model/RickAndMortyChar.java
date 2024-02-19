package de.quarzerback.rickandmortycharrestclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RickAndMortyChar {
    private String name;
    private int id;
    private String species;
    private String gender;
    private String status;
}
