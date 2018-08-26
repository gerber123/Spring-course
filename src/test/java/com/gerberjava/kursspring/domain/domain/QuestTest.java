package com.gerberjava.kursspring.domain.domain;

import com.gerberjava.kursspring.domain.Quest;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class QuestTest
{
    @Test
    public void settingStartedFlagToFalseShoulldSetStartDate()
    {
        Quest quest = new Quest(1,"Testowe zadanie");
        quest.setStarted(true);

        assertNotNull(quest.startDate);
    }
    @Test
    public void questShouldBeCompleted() {
        Quest q = new Quest(1, "Testowe zadanie");
        q.setStarted(true);
        q.lenghtInSeconds = -60;
        assertTrue(q.isCompleted());
        assertTrue(q.isCompleted());
    }
    @Test
    public void questShouldNotBeCompleted()
    {
        Quest q = new Quest(1, "Testowe zadanie");
        q.setStarted(true);
        q.lenghtInSeconds = 200;
        assertFalse(q.isCompleted());
        assertFalse(q.isCompleted());
    }
}
