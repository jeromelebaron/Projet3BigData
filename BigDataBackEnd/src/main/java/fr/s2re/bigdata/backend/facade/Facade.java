package fr.s2re.bigdata.backend.facade;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.s2re.bigdata.backend.service.ChartService;

public class Facade {

    private static Facade uniqueInstance;

    private ApplicationContext springContext;

    private ChartService chartService;

    private Facade() {
        springContext = new ClassPathXmlApplicationContext("mongo-context.xml");
        // chargement des services
        chartService = springContext.getBean(ChartService.class);
    }

    public static synchronized Facade getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Facade();
        return uniqueInstance;
    }

    public ChartService getChartService() {
        return chartService;
    }

}
