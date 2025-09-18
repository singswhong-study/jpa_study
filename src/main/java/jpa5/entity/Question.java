package jpa5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ElementCollection(fetch =  FetchType.EAGER)        //Eager로 지정하게 되면 left join 으로 바로 조회, lazy는 해당 permission에 접근할때 조회.
    @CollectionTable(
        name = "question_choice",                       //사용될 테이브
        joinColumns = @JoinColumn(name = "questionId") //조인될 컬럼
    )
    @OrderColumn(name = "idx") //index 값을 저장할 컬럼
    @Column(name = "text")
    private List<String> choices;

    // 여기서 Embeddable 인 choice table 을 넣고싶다면 @column은 삭제.
//      private List<Choice> choices; 하고 리스트 객체는 @Embeddable 설정.

    public Question(String text, List<String> choices){
        this.text = text;
        this.choices = choices;
    }
}
