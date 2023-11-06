/**
 * This is Games class. It has four fields, and a constructor.
 * @author zhenhuai zeng
 * @version Java 21
 * Date: 10/23/2023
 */



package edu.greenriver.sdev.saasproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    /**
     *  This constructor takes 4 parameters.
     * @param name name
     * @param genres genres
     * @param platforms playforms
     * @param developers developers
     */
    public Games(String name, String genres, String platforms, String developers) {
        this.name = name;
        this.Genres = genres;
        this.Platforms = platforms;
        this.Developers = developers;
    }


}
