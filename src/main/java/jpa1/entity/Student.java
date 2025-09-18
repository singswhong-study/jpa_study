package jpa1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    private Long studentId;

    private String name;

    private String grade;

//    private Long majorId;             //이렇게 있는건 테이블의 관계

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "majorId")
    private Major major;                //이렇게 있어야 객체관계

    public Student(String name, String grade){
        this.name = name;
        this.grade = grade;
    }
}
