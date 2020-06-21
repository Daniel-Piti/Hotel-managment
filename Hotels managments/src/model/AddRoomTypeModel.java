package model;

public class AddRoomTypeModel {
	Hotel hotel;
	
	public AddRoomTypeModel(Hotel hotel) {
		this.hotel = hotel;
	}

	public void loadRoom(String name, int capacity, double price, double size, int amount) {
		hotel.addRoomType(name, capacity, price, size, amount);
	}
	
	
}
