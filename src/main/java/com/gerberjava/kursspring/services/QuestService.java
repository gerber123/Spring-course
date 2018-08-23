package com.gerberjava.kursspring.services;

import com.gerberjava.kursspring.domain.Quest;
import com.gerberjava.kursspring.domain.repository.InMemoryRepository;
import com.gerberjava.kursspring.domain.repository.KnightRepository;
import com.gerberjava.kursspring.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestService
{
    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    final static Random rand = new Random();

    public void assignRandomQuest(String knightName)
    {
        List<Quest> allQuest = questRepository.getAll();
        Quest randomQuest= allQuest.get(rand.nextInt(allQuest.size()));
        knightRepository.getKnight(knightName).setQuest(randomQuest);
        questRepository.deleteQuest(randomQuest);
    }
}
