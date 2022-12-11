package org.zerock.topik.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TB_READING_QUESTION")
public class ReadingQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="CONTEXT", nullable = false, length=3000)
    private String context;

    @Column(name="CHOICE1", nullable = false)
    private String choice1;
    @Column(name="CHOICE2", nullable = false)
    private String choice2;
    @Column(name="CHOICE3", nullable = false)
    private String choice3;
    @Column(name="CHOICE4", nullable = false)
    private String choice4;

    @Column(name="ANSWER", nullable = false)
    private int answer;


    @Override
    public String toString(){
        String result = "";
        result += "====================================" + "\n";
        result += this.id + "번 문제" + "\n";
        result += "(domain)====================================" + "\n";
        result += this.context + "\n";
        result += "다음 중 사실이 아닌 내용을 고르세요.";
        result += "====================================" + "\n";
        result += this.choice1 + "\n";
        result += this.choice2 + "\n";
        result += this.choice3 + "\n";
        result += this.choice4 + "\n";
        result += "====================================" + "\n";

        return result;
    }


}