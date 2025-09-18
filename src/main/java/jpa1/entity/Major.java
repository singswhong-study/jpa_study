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
@Table(name = "major")
public class Major {

    @Id
    @GeneratedValue
    private Long majorId;

    private String name;

    private String category;

//    @OneToMany(mappedBy = "major")
//    private List<Student> studentList;
//
//    public Major() {
//        this.studentList = new ArrayList<>();
//    }

    public Major(String name, String category){
        this.name = name;
        this.category = category;
    }
}
