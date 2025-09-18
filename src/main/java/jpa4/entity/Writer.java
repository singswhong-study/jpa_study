package jpa4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Writer {

    @Column(table = "writer", name="userName")
    private String userName;

    @Column(table = "writer", name="point")
    private int point;

    public Writer(String userName, int point){
        this.userName = userName;
        this.point = point;
    }
}
