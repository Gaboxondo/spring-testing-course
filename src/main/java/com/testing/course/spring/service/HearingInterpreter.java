package com.testing.course.spring.service;

import org.springframework.stereotype.Service;

@Service
public class HearingInterpreter {
    private final WordProducer wordProducer;

    public HearingInterpreter(WordProducer wordProducer) {
        this.wordProducer = wordProducer;
    }

    public String whatDidIHear() {
        return "Escuché: " + wordProducer.getWord();
    }
}
