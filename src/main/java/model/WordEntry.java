package model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class WordEntry implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String word;
    private String sortedChars;
    private Integer points;

    public WordEntry(String word, String sortedChars, Integer points) {
        this.word = word;
        this.sortedChars = sortedChars;
        this.points = points;
    }

    @Override
    public String toString() {
        return word + " " + points;
    }

}
