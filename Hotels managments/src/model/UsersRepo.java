package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class UsersRepo {
	private String filename;
	private HashMap<String, Customer> members;
	
	public UsersRepo(String filename) {
		this.filename = filename;
		loadData();
		//setData();
	}
	
	public void loadData() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
			members = (HashMap<String, Customer>) in.readObject();
			for(Customer key : members.values()) {
				System.out.println(key.toString());
			}
			System.out.println(filename + "'s Data loaded!");
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Customer validUser(String mail, String pass) {
		if(members.containsKey(mail)) {
			String str = members.get(mail).toString(); 
			String[] a = str.split(" ");
			if(pass.equals(a[6])) {
				boolean b = false;
				if(("true").equals(a[5]))
					b = true;
				return new Customer(a[0], a[1], a[2], a[3], a[4], b, a[6], Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9]));
			}
		}
		return null;
	}
	
	public void addUser(Customer u) {
		members.put(u.getEmail(), u);
		System.out.println("added customer");
		setData();
	}
	
	public boolean emailUsed(String email) {
		if(members.containsKey(email))
			return true;
		return false;
	}
	
	public void setData() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
			members = new HashMap<String, Customer>();
			members.put("alpha", new Customer("alpha", "alpha", "alpha", "alpha", "alpha", true, "alpha", 10, 10, 10));
			out.writeObject(members);
			System.out.println(filename + "'s DATA SAVED!");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
