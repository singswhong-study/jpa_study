package jpa5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "doc")
public class Doc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ElementCollection
    @CollectionTable(
        name = "doc_prop",
        joinColumns = @JoinColumn(name = "docId")
    )
    @MapKeyColumn(name = "k")
    @Column(name = "v")
    private Map<String, String> props = new HashMap<>();

    //Map<String, PropTable> props = new hashMap<>();
    // 이런식으로 위의 Column 을 떼고 작성.
    // 대상 @Embeddable PropTable 객체에는 @Acess(AcessType.FIELD) 설정해주면 된다.

    public Doc(String text, String content, Map<String, String> props){
        this.title = text;
        this.content = content;
        this.props = props;
    }
}
