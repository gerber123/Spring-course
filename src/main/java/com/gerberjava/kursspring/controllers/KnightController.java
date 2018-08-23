package com.gerberjava.kursspring.controllers;

import com.gerberjava.kursspring.domain.Knight;
import com.gerberjava.kursspring.domain.repository.KnightRepository;
import com.gerberjava.kursspring.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class KnightController
{

    @Autowired
    KnightService service;

    @RequestMapping("/knights")
    public String getKnights(Model model)
    {
        List<Knight> knights = new ArrayList<>(service.getAllKnights());
        model.addAttribute("knights",knights);
        return "knights";
    }
}
