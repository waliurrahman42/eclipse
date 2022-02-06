package com.cdac.dipendencyexample2;

import org.springframework.stereotype.Component;

@Component("mygame")
public class MyGamingService implements GammingService{

	@Override
	public String gameInfo() {
		// TODO Auto-generated method stub
		return "palaying call of duty";
	}

}
