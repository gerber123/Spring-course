package com.gerberjava.kursspring.domain.domain;

import com.gerberjava.kursspring.domain.Knight;
import com.gerberjava.kursspring.domain.Quest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KnightTest
{

    @Test
    public void testIfQuestMarkedAsStarted()
    {
        Knight knight = new Knight("Percival",25);
        Quest quest = new Quest(1,"Testowe zadanie");

        knight.setQuest(quest);
        assertTrue(knight.getQuest().isStarted());
    }
}
