package de.creatronix.artist3k.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ObjectDecomposer {
	public static List<String> getMembers(Object obj) {
		List<String> membersAsStrings = new ArrayList<String>();
		if(obj == null) {
			membersAsStrings.add("");
			return membersAsStrings;
		}
		Class<? extends Object> a = obj.getClass();
		Method[] aMethods = a.getDeclaredMethods();
		for (Method m : aMethods) {
			String nameA = m.getName();
			if (nameA.startsWith("get")) {
				try {
					Object returnValueA = obj.getClass().getDeclaredMethod(
							nameA).invoke(obj, new Object[0]);
					//either an object is "primitive"
					if (returnValueA instanceof String || returnValueA instanceof Number) {
						membersAsStrings.add(returnValueA.toString());
					} else { //or we decompose recursively
						membersAsStrings.addAll(getMembers(returnValueA));
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}

			}
		}
		return membersAsStrings;
	}
	public static List<String> getMemberNames(Object obj) {
		List<String> memberNamesAsStrings = new ArrayList<String>();
		if(obj == null) {
			return memberNamesAsStrings;
		}
		Class<? extends Object> a = obj.getClass();

		Method[] aMethods = a.getDeclaredMethods();
		for (Method m : aMethods) {
			String nameA = m.getName();
			if (nameA.startsWith("get")) {
				try {
					Object returnValueA = obj.getClass().getDeclaredMethod(
							nameA).invoke(obj, new Object[0]);
					if (returnValueA instanceof String || returnValueA instanceof Number || returnValueA == null) {
						memberNamesAsStrings.add(nameA.substring(3));
					} else {
						memberNamesAsStrings.addAll(getMemberNames(returnValueA));
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return memberNamesAsStrings;
	}
	private ObjectDecomposer()
	{}
}
