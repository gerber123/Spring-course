package com.gerberjava.kursspring.config;


import com.gerberjava.kursspring.domain.Knight;
import com.gerberjava.kursspring.domain.repository.DBKnightRepository;
import com.gerberjava.kursspring.domain.repository.InMemoryRepository;
import com.gerberjava.kursspring.domain.repository.KnightRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Configuration
//@ImportResource("classpath:config/castle-config.xml")
@Configuration
public class MainConfig
{
    @Bean(name="inMemoryKnightRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepo()
    {
        KnightRepository repo = new InMemoryRepository();
        return repo;
    }
    @Bean(name="DBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBRepo()
    {
        KnightRepository repo = new DBKnightRepository();
        return repo;
    }

}
