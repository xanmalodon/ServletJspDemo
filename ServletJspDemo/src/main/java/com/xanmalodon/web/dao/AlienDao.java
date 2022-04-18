package com.xanmalodon.web.dao;

import com.xanmalodon.web.model.Alien;

public class AlienDao {

	public Alien getAlien(int aid) {
		Alien a = new Alien();
		
		a.setAid(101);
		a.setAname("Louis");
		a.setTech("Java");
		
		return a;
	}
}
