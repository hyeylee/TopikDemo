package org.zerock.topik.dto;

import lombok.*;
import org.zerock.topik.domain.ReadingQuestion;

@Builder
@Data
@AllArgsConstructor
public class ReadingQuestionDto {
    private String context;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private int answer;


    //repository 를 통해 조회한 entity 를 dto 로 변환 용도
    public ReadingQuestionDto(){

    }
    public ReadingQuestionDto(ReadingQuestion entity) {
        System.out.println(entity);
        this.context = entity.getContext();
        this.choice1 = entity.getChoice1();
        this.choice2 = entity.getChoice2();
        this.choice3 = entity.getChoice3();
        this.choice4 = entity.getChoice4();
        this.answer = entity.getAnswer();
    }

    @Override
    public String toString(){
        String result = "";
        result += "(dto)====================================" + "\n";
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