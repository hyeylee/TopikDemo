package org.zerock.topik.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.topik.domain.ReadingQuestion;
import org.zerock.topik.dto.ReadingQuestionDto;
import org.zerock.topik.repository.ReadingQuestionRepository;

import java.util.List;

@Service
public class TopikService {
    private final ReadingQuestionRepository readingQuestionRepository;

    @Autowired
    public TopikService(ReadingQuestionRepository readingQuestionRepository){
        this.readingQuestionRepository = readingQuestionRepository;
    }

    public ReadingQuestionDto getRandomQuestion() {
        List<ReadingQuestion> entity = readingQuestionRepository.getRandomQuestion(1);
        return new ReadingQuestionDto(entity.get(0));
    }

    private void ttt(ReadingQuestion qq){
        System.out.println(qq);
    }
}