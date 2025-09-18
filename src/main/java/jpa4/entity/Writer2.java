package jpa4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Writer2 {

    private String userName;

    private int point;

    public Writer2(String userName, int point){
        this.userName = userName;
        this.point = point;
    }
}
