package users;

public abstract class AbstractUser {
	String name;
	String email;
	int id;
	int permission;
	
	public int getPermission() {
		return permission;
	}



	public void setPermission(int permission) {
		this.permission = permission;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public AbstractUser(String name, String email, int id, int permission) {
		this.name = name;
		this.email = email;
		this.id = id;
		this.permission = permission;
	}
}
