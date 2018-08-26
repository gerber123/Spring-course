package com.gerberjava.kursspring.controllers;

import com.gerberjava.kursspring.domain.Knight;
import com.gerberjava.kursspring.domain.PlayerInformation;
import com.gerberjava.kursspring.domain.Quest;
import com.gerberjava.kursspring.services.KnightService;
import com.gerberjava.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestController
{
    @Autowired
    KnightService knightService;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformation playerInformation;

    @RequestMapping("/assignQuests")
    public String assignQuests(@RequestParam("knightId") Integer id, Model model)
    {

        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuest=questService.getAllNotStartedQuests();
        model.addAttribute("knight",knight);
        model.addAttribute("notStartedQuests",notStartedQuest);

        return "assignQuests";
    }
    @RequestMapping(value = "/assignQuests", method = RequestMethod.POST)
    public String assignQuests(Knight knight)
    {

        knightService.updateKnight(knight);
        Quest quest = knight.getQuest();
        questService.update(quest);
        return "redirect:/knights";
    }
    @RequestMapping(value = "/checkQuests")
    public String checkQuests()
    {

        knightService.getMyGold();
        return "redirect:/knights";
    }
}
