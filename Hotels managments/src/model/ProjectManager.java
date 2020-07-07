package model;

import java.io.Serializable;

public class ProjectManager extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	public ProjectManager(String firstName, String lastName, String phoneNumber, String email, String ID,
			boolean gender, String password, int d, int m, int y) {
		super(firstName, lastName, phoneNumber, email, ID, gender, password, d, m, y);
	}
}
