package de.creatronix.artist3k.model;

import java.util.Comparator;

public class EventSortByDate implements Comparator<Event> {
	public int compare(Event o1, Event o2) {
		if (o1.getDate() == null)
			return -1;
		else if (o2.getDate() == null)
			return -1;
		else {
			return o1.getDate().compareTo(o2.getDate());
		}
	}
}
