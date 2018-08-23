package com.gerberjava.kursspring;



import com.gerberjava.kursspring.domain.repository.InMemoryRepository;
import com.gerberjava.kursspring.domain.repository.KnightRepository;
import com.gerberjava.kursspring.domain.repository.QuestRepository;
import com.gerberjava.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class Starter implements CommandLineRunner
{
   @Autowired
   KnightRepository knightRepository;

   @Autowired
    QuestRepository questRepository;

   @Autowired
    QuestService questService;
    @Override
    public void run(String... args) throws Exception
    {
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();


    }
}
