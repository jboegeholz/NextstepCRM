package de.creatronix.artist3k.controller.action;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SimpleCalendarTest {
	@Test
	public void testMonthStart() {
		System.out.println(SimpleCalendar.monthStart(1, 2008));
		assertEquals(SimpleCalendar.monthStart(1, 2008), 2);
		
		System.out.println(SimpleCalendar.monthStart(2, 2008));
		assertEquals(SimpleCalendar.monthStart(2, 2008), 5);
		
		System.out.println(SimpleCalendar.monthStart(3, 2008));
		assertEquals(SimpleCalendar.monthStart(3, 2008), 6);
		
		System.out.println(SimpleCalendar.monthStart(4, 2008));
		assertEquals(SimpleCalendar.monthStart(4, 2008), 2);
		
		System.out.println(SimpleCalendar.monthStart(5, 2008));
		assertEquals(SimpleCalendar.monthStart(5, 2008), 4);
		
		System.out.println(SimpleCalendar.monthStart(6, 2008));
		assertEquals(SimpleCalendar.monthStart(6, 2008), 7);
		
		System.out.println(SimpleCalendar.monthStart(7, 2008));		
		assertEquals(SimpleCalendar.monthStart(7, 2008), 2);
		
		System.out.println(SimpleCalendar.monthStart(8, 2008));		
		assertEquals(SimpleCalendar.monthStart(8, 2008), 5);
		
		System.out.println(SimpleCalendar.monthStart(9, 2008));		
		assertEquals(SimpleCalendar.monthStart(9, 2008), 1);
		
		System.out.println(SimpleCalendar.monthStart(10, 2008));		
		assertEquals(SimpleCalendar.monthStart(10, 2008), 3);
		
		System.out.println(SimpleCalendar.monthStart(11, 2008));		
		assertEquals(SimpleCalendar.monthStart(11, 2008), 6);
		
		System.out.println(SimpleCalendar.monthStart(12, 2008));
		assertEquals(SimpleCalendar.monthStart(12, 2008), 1);
	}
}
