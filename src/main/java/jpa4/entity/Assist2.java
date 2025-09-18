package jpa4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class Assist2 {

    private String name;

    private String type;

    public Assist2(String name, String type){
        this.name = name;
        this.type = type;
    }

}
