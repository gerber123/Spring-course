package com.gerberjava.kursspring.domain.repository;

import com.gerberjava.kursspring.domain.Quest;
import com.gerberjava.kursspring.utils.Ids;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
@Scope("singleton")
public class QuestRepository
{
    List<Quest> questList = new ArrayList<>();
    Random rand = new Random();
    Map<Integer,Quest> quests = new HashMap<>();

    public void createQuest(String description)
    {
        int newId = Ids.generateNewId(quests.keySet());
        Quest quest = new Quest(newId,description);
        quests.put(newId,quest);

    }

    public List<Quest> getAll()
    {
        return new ArrayList<>(quests.values()) ;
    }

    public void deleteQuest(Quest quest)
    {
        quests.remove(quest.getId());
    }

    @PostConstruct
    public void init()
    {

    }
    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + questList +
                '}';
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest()
    {
        List<String> descriptions = new ArrayList<>();
        descriptions.add("Uratuj ksiezniczke");
        descriptions.add("Zabij bande goblinów");
        descriptions.add("Zabij smoka");
        descriptions.add("Weź udział w turnieju");
        String description = descriptions.get(rand.nextInt(descriptions.size()));
//        System.out.println("Utworzyłem zadanie o opisie: "+description);
        createQuest(description);
    }

    public void update(Quest quest) {
        quests.put(quest.getId(),quest);
    }

    public Quest getQuest(Integer id)
    {
        return quests.get(id);
    }
}
