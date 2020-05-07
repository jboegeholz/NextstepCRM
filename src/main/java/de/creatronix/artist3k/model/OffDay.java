package de.creatronix.artist3k.model;

import java.util.Calendar;

public class OffDay {
	private Long id;
	private User user;
	private Calendar offDay;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Calendar getOffDay() {
		return offDay;
	}

	public void setOffDay(Calendar offDay) {
		this.offDay = offDay;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof OffDay
				&& ((OffDay)arg0).getOffDay().get(Calendar.YEAR) == (this.offDay.get(Calendar.YEAR))
				&& ((OffDay)arg0).getOffDay().get(Calendar.MONTH) == (this.offDay.get(Calendar.MONTH))
				&& ((OffDay)arg0).getOffDay().get(Calendar.DAY_OF_MONTH) == (this.offDay.get(Calendar.DAY_OF_MONTH))
				&& ((OffDay) arg0).getUser().equals(this.user))
			return true;
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
