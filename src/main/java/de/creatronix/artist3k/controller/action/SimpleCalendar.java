package de.creatronix.artist3k.controller.action;

import java.lang.Math;

public class SimpleCalendar {

	public static boolean isLeap(int year) {

		if (year <= 1752) {

			int r = year % 4;

			if (r == 0) {

				return true;

			}

			else {

				return false;

			}

		}

		// # after 1752, any year divisible by 4 except those divisible by 100
		// but

		// # not by 400 are leap years.

		else {

			if (year % 400 == 0) {

				return true;

			}

			else {

				if (year % 100 == 0) {

					return false;

				}

				else {

					return (year % 4 == 0) ? true : false;

				}

			}

		}

	}// end isLeap()

	public static int daysInMonth(int month, int year) {

		int days_in_month;

		if (month == 4 || month == 6 || month == 9 || month == 11) {

			days_in_month = 30;

		}

		else {

			if (month != 2) {

				days_in_month = 31;

			}

			else {

				if (SimpleCalendar.isLeap(year)) {

					days_in_month = 29;

				}

				else {

					days_in_month = 28;

				}

			}

		}

		return days_in_month;

	}// end daysInMonth()

	public static int yearStart(int y) {

		return SimpleCalendar.monthStart(1, y);

	}// end yearStart()

	// I have no idea how this function works. It returns an int between 0 and 6
	// representing the day

	// of the week on which a month starts (0=Sunday)

	public static int monthStart(int m, int y) {

		int d = 1;

		int[] dArray = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };

		if (m < 3) {
			y--;
		}
		int ret = (int) (y + Math.floor(y / 4) - Math.floor(y / 100)
				+ Math.floor(y / 400) + dArray[m - 1] + d) % 7;
		if (ret == 0) {
			return 7;
		} else {
			return ret;
		}

	}
}
