package com.qsp.SpringToJdbc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class SpringToJdbcApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Bean.xml");
		Intermediate intermediate = applicationContext.getBean("jdbc", Intermediate.class);
		intermediate.retrieveAllData();
//		intermediate.deleteData(1);
	}

}
