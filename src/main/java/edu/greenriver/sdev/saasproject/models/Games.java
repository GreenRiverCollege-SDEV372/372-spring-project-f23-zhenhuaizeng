package edu.greenriver.sdev.saasproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Games {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    String name;
    String Genres;
    String Platforms;
    String Developers;

    public Games(String name, String genres, String platforms, String developers) {
        this.name = name;
        Genres = genres;
        Platforms = platforms;
        Developers = developers;
    }


}
