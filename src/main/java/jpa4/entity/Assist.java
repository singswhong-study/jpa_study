package jpa4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class Assist {

    @Column(table = "assist", name="name")
    private String name;

    @Column(table = "assist", name="type")
    private String type;

    public Assist(String name, String type){
        this.name = name;
        this.type = type;
    }

}
