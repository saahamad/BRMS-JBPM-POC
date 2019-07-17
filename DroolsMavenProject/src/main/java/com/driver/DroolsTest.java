package com.driver;

import java.util.Scanner;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.model.Product;

public class DroolsTest {

	public static void main(String[] args) {		
	 new DroolsTest().testRules();
	}

	public void testRules() {
		
		try {

			// Fact creation
			System.out.println("Enter type here....[diamond/gold]");
			Product product = new Product();
			product.setType(new Scanner(System.in).next());	
			
			// Creating the Kie container
			KieServices kieServices =  new KieServices.Factory().get();
			KieContainer container = kieServices.getKieClasspathContainer();
			
			// Creating a Kie session
			KieSession kieSession = container.newKieSession("ksession-rule");				
			kieSession.insert(product);
			
			// Firing all rules
			kieSession.fireAllRules();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
}
