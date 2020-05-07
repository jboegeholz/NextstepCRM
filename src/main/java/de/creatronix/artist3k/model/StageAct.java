package de.creatronix.artist3k.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class StageAct implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2612024055324299220L;
	private String name;
	private Set<Artist> artists = new HashSet<Artist>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
