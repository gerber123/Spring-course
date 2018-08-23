package com.gerberjava.kursspring.domain;

public class Knight
{
    private String name;
    private int age;
    private Quest quest;


    public Knight()
    {
        this.name="Lancelot";
        this.age=29;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setQuest(Quest quest) {
        System.out.println("Ustawiam zadanie dla rycerza :"+this.name);
        this.quest = quest;
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
