package com.example.intership31conly.Service;


import com.example.intership31conly.Model.dbone.Indicators;
import com.example.intership31conly.Reposiroty.dbone.IndicatorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndicatorsService {
    private final IndicatorsRepository firstRepository;
    private static final String BASE_PACKAGE = "com.example.intershipproject2database";
    @Autowired
    public IndicatorsService(IndicatorsRepository firstRepository) {
        this.firstRepository = firstRepository;
    }
    public IndicatorsService(){
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BASE_PACKAGE);
        firstRepository = context.getBean(IndicatorsRepository.class);
    }

    public List<Indicators> findAllIndicators(){
        return firstRepository.findAll();
    }
}
