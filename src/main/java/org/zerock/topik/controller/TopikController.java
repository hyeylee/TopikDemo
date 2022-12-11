package org.zerock.topik.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zerock.topik.dto.ReadingQuestionDto;
import org.zerock.topik.service.TopikService;


@RestController
@Log4j2
public class TopikController {

    private final TopikService topikService;


    @Autowired
    public TopikController(TopikService topikService) {
        this.topikService = topikService;
    }

    @RequestMapping(value = "topik/getRandom", method = RequestMethod.GET)
    public ReadingQuestionDto getRandomQuestion() {
        ReadingQuestionDto tt = topikService.getRandomQuestion();
        System.out.println(tt);
        log.info(tt);
        return topikService.getRandomQuestion();
    }





}