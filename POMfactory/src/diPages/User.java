package diPages;

public class User {
	
	private String name;
	private String email;
	private String pass;
	private String passConfirm;

	public User() {

	}

	public User(String name, String email, String pass, String passConfirm) {
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.passConfirm = passConfirm;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPassConfirm() {
		return passConfirm;
	}

	public void setPassConfirm(String passConfirm) {
		this.passConfirm = passConfirm;
	}

}