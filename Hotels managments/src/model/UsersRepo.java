package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class UsersRepo {
	
	private static UsersRepo single_instance=null;
	
	private String filename;
	private HashMap<String, Customer> members;
	
	private UsersRepo(String filename) {
		this.filename = filename;
		loadData();
		//setData();
	}
	
	public static UsersRepo getInstance() {
		if(single_instance==null)
			single_instance=new UsersRepo("Members/Customers.txt");
		return single_instance;
	}
	
	@SuppressWarnings("unchecked")
	public void loadData() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
			members = (HashMap<String, Customer>) in.readObject();
			for(Customer key : members.values()) {
				System.out.println(key.toString());
			}
			System.out.println("USER DATA LOADED");
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Customer find(String mail) {
		if(members.containsKey(mail))
			return members.get(mail);
		return null;
	}
	
	public void addUser(Customer u) {
		members.put(u.getEmail(), u);
		System.out.println("added customer");
	}
	
	public boolean emailUsed(String email) {
		if(members.containsKey(email))
			return true;
		return false;
	}
	
	public void setData() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
			//FOR RESETS
//			members = new HashMap<String, Customer>();
//			members.put("alpha", new Customer("alpha", "alpha", "alpha", "alpha", "alpha", true, "alpha", 10, 10, 10));
			out.writeObject(members);
			System.out.println("USERS DATA SAVED!");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}