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
import java.util.stream.Collectors;

@Service
public class QuestService
{
    @Autowired
    KnightRepository knightRepository;

//    @Autowired
    QuestRepository questRepository;

    final static Random rand = new Random();

    public void assignRandomQuest(String knightName)
    {
        List<Quest> allQuest = questRepository.getAll();
        Quest randomQuest= allQuest.get(rand.nextInt(allQuest.size()));

        knightRepository.getKnight(knightName).ifPresent(knight -> knight.setQuest(randomQuest));
        questRepository.deleteQuest(randomQuest);
    }

    public List<Quest> getAllNotStartedQuests()
    {
       return questRepository.getAll().stream().filter(quest -> !quest.isStarted()).collect(Collectors.toList());
    }

    @Autowired
    public void setQuestRepository(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public void update(Quest quest) {
        questRepository.update(quest);
    }

    public boolean isQuestCompleted(Quest quest)
    {
        return quest.isCompleted();
    }
}
