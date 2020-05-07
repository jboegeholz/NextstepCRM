package de.creatronix.artist3k.model;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.Test;

public class ObjectDecomposerTest {
	
	@Test
	public void testGetMembersFromObject() {
		Location loc = new Location();
		loc.setName("Venue1");
		loc.setUrl("blub");
		
		Address address = new Address();
		address.setCountry("Germany");
		address.setStreet("Hauptstrasse");
		address.setId(new Long(1));
		loc.setAddress(address);
		
		List<String> list = ObjectDecomposer.getMembers(loc);
		assertTrue(list.contains("Venue1"));
		assertTrue(list.contains("blub"));
		assertTrue(list.contains("Germany"));
		assertTrue(list.contains("Hauptstrasse"));
		assertTrue(list.contains("1"));
	}
	@Test
	public void testGetMemberNamesFromObject() {
		Location loc = new Location();
		loc.setName("Venue1");
		loc.setUrl("blub");
		
		Address address = new Address();
		address.setCountry("Germany");
		address.setStreet("Hauptstrasse");
		loc.setAddress(address);
		
		List<String> list = ObjectDecomposer.getMemberNames(loc);
		assertTrue(list.contains("Name"));
		assertTrue(list.contains("Country"));
		assertTrue(list.contains("Url"));
		assertTrue(list.contains("Street"));
		assertTrue(list.contains("Id"));
	}
}
