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
	public void setData() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
			out.writeObject(members);
			System.out.println(filename + "'s DATA SAVED!");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
