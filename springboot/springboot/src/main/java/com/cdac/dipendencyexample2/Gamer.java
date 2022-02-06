package com.cdac.dipendencyexample2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Gamer implements User{
	
	@Autowired
	@Qualifier("mygame")
	MyGamingService mygamingservice;
	
	
	@Override
	public void doWork() {
		// TODO Auto-generated method stub
		String gameName =mygamingservice.gameInfo();
		System.out.println("game is "+ gameName);
	}

	

	
}
