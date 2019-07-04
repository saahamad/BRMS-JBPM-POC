package com.pojo;

import java.util.Scanner;

public class Vehicle {

	private String vName;
	private double vPrice;
	Scanner scanner = null;
	Vehicle employee = null;
	
	public Vehicle() {
				
	
	}
	
	public void setData() {
		
		scanner = new Scanner(System.in);
		System.out.println("Enter prize here..[Bike in <= 70,000 and Car in > 70000]");
		setvPrice(scanner.nextDouble());
	}

	public double getvPrice() {
		return vPrice;
	}

	public void setvPrice(double vPrice) {
		this.vPrice = vPrice;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}
	

}
