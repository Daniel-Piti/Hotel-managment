package model;

public class DarkFlag {
	private static int single_instance = -1;
	
	private DarkFlag(String filename) {
		single_instance = 0;
	}
	
	public static int getInstance() {
		if(single_instance == -1)
			single_instance = 0;
		return single_instance;
	}
	
	public static void setValue(int flag) {
		single_instance = flag;
	}
}
