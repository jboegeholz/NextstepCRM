package de.creatronix.artist3k.model;

import java.util.Comparator;

public class LocationSortByTown implements Comparator<Location> {

	public int compare(Location o1, Location o2) {
		return o1.getAddress().getTown().compareTo(o2.getAddress().getTown());
	}

}
