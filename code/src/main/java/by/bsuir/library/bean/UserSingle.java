package by.bsuir.library.bean;

public class UserSingle {
	
	private static UserSingle user;
	public int id;
	
	private UserSingle() {
			
	}
	
	public UserSingle(int id) {
		this.id = id;	
	}
	
	public static UserSingle getUser() {
		if(user == null) {
			user = new UserSingle();
		}
		return user;
	}
}
