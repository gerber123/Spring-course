package com.gerberjava.kursspring.domain.repository;

import com.gerberjava.kursspring.domain.Quest;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
@Scope("singleton")
public class QuestRepository
{
    List<Quest> questList = new ArrayList<>();
    Random rand = new Random();
    public void createQuest(String description)
    {
        questList.add(new Quest(description));
    }

    public List<Quest> getAll()
    {
        return questList;
    }

    public void deleteQuest(Quest quest)
    {
        questList.remove(quest);
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
}
