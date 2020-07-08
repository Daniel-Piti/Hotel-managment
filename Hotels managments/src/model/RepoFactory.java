package model;

public class RepoFactory {
	
	public Repos getRepo(String type) {
		if(type == null)
			return null;
		else if(type.equalsIgnoreCase("USERS"))
			return HotelRepo.getInstance();
		else if(type.equalsIgnoreCase("HOTELS"))
			return UsersRepo.getInstance();
		return null;
	}
}
