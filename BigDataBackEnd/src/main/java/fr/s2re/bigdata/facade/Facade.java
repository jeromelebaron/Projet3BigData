package fr.s2re.bigdata.facade;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import fr.s2re.bigdata.service.ChartService;



public class Facade {

private static Facade uniqueInstance;
	
	
	public static synchronized Facade getInstance(){
		if(uniqueInstance==null) uniqueInstance = new Facade();
		return uniqueInstance;
	}
	
	private ApplicationContext springContext;
	
	private ChartService chartService;
	
	private Facade() {
		springContext = new ClassPathXmlApplicationContext("mongo-context.xml");	
		//chargement des services
		chartService   = springContext.getBean(ChartService.class);
	}

	public ChartService getChartService() {
		return chartService;
	}

}
