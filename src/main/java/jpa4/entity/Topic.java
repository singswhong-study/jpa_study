package jpa4.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@SecondaryTables({
    @SecondaryTable(name = "writer", pkJoinColumns = @PrimaryKeyJoinColumn(name="writerId", referencedColumnName = "id")),
    @SecondaryTable(name = "assist", pkJoinColumns = @PrimaryKeyJoinColumn(name="writerId", referencedColumnName = "id"))
})
@Table( name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Embedded
    private Writer writer;

    @Embedded
    private Assist assist;

    public Topic(String title, Writer writer, Assist assist){
        this.title = title;
        this.writer = writer;
        this.assist = assist;

    }

}
