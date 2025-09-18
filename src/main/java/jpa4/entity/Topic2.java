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
    @SecondaryTable(name = "writer2", pkJoinColumns = @PrimaryKeyJoinColumn(name="writerId", referencedColumnName = "id")),
    @SecondaryTable(name = "assist2", pkJoinColumns = @PrimaryKeyJoinColumn(name="writerId", referencedColumnName = "id"))
})
@Table( name = "topic2")
public class Topic2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "userName", column = @Column(table = "writer2", name = "userName")),
            @AttributeOverride(name = "point", column = @Column(table = "writer2",name = "point")),
    })
    private Writer2 writer;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(table = "assist2", name = "name")),
            @AttributeOverride(name = "type", column = @Column(table = "assist2",name = "type")),
    })
    private Assist2 assist;

    public Topic2(String title, Writer2 writer, Assist2 assist){
        this.title = title;
        this.writer = writer;
        this.assist = assist;

    }

}
