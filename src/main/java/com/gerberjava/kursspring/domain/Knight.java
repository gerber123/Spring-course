package com.gerberjava.kursspring.domain;

import com.gerberjava.kursspring.services.QuestService;
import org.hibernate.validator.constraints.Range;
import org.jboss.logging.Message;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Knight
{
    @NotNull
    @Size(min=2,max=40)

    private String name;
    @NotNull
    @Range(min=18,max=60)
    private int age;
    private Quest quest;
    private int id;
    private int level;


    public Knight()
    {

    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level=1;
    }

    public Quest getQuest() {
        return quest;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setQuest(Quest quest) {
        System.out.println("Ustawiam zadanie dla rycerza :"+this.name);
        if(quest!=null) {
            quest.setStarted(true);
        }
        this.quest = quest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu "+name+" ma już "+age+" wiosen, zadanie to: "+this.quest;
    }
}
