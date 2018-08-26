package com.gerberjava.kursspring.services;

import com.gerberjava.kursspring.domain.Knight;
import com.gerberjava.kursspring.domain.PlayerInformation;
import com.gerberjava.kursspring.domain.Quest;
import com.gerberjava.kursspring.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class KnightService
{
   @Autowired
    KnightRepository knightRepository;

   @Autowired
   PlayerInformation playerInformation;

   public List<Knight> getAllKnights()
   {
       return new ArrayList<>(knightRepository.getAllKnights());
   }

    public void saveKnight(Knight knight)
    {
        knightRepository.createKnight(knight);
    }

    public Knight getKnight(Integer id)
    {
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
       knightRepository.deleteKnight(id);
    }
    public void updateKnight(Knight knight)
    {
        knightRepository.updateKnight(knight.getId(),knight);
    }

    public int collectRewards()
    {
        Predicate<Knight> knightPredicate = knight -> {
            if(knight.getQuest()!=null)
            {
                return knight.getQuest().isCompleted();
            } else {
                return false;
            }};

        int sum =knightRepository.getAllKnights().stream().filter(knightPredicate).mapToInt(knight -> knight.getQuest().getReward()).sum();

        knightRepository.getAllKnights().stream().filter(knightPredicate).forEach(knight ->
        {
            knight.setQuest(null);
        });
        return sum;
    }
    public void getMyGold()
    {
        List<Knight> allKnights = getAllKnights();
        allKnights.forEach(knight ->{
            if(knight.getQuest()!=null) {
                knight.getQuest().isCompleted();
            }
            else
            {
//                for(int i=0;i<100;i++)
//                {
//                    Quest q = new Quest(i,"Zgwałć księżniczkę ");
//                    knight.setQuest(q);
//                }
            }
        });


        int currentGold = playerInformation.getGold();

        playerInformation.setGold(currentGold+collectRewards());
    }
}
