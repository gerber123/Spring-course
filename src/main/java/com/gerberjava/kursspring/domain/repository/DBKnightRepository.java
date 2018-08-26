package com.gerberjava.kursspring.domain.repository;

import com.gerberjava.kursspring.domain.Knight;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Optional;


public class DBKnightRepository implements KnightRepository
{
    @Override
    public void createKnight(String name, int age)
    {
        System.out.println("Używam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public Collection<Knight> getAllKnights()
    {
        System.out.println("Używam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public Optional<Knight> getKnight(String name)
    {
        System.out.println("Używam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public void deleteKnight(Integer id)
    {
        System.out.println("Używam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    @PostConstruct
    public void build()
    {

    }

    @Override
    public void createKnight(Knight knight) {

    }

    @Override
    public Knight getKnightById(Integer id) {
        return null;
    }


}
