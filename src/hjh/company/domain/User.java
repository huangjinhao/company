package hjh.company.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
	private String userId;
	private String password;
	private String name;
	private String sex;
	private int age;
	private String address;
	private String tel;
	private String email;
	
	private Set<Role> roles = new HashSet<Role>();
	

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String userId, String password, String name, String sex,
			int age, String address, String tel, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.tel = tel;
		this.email = email;
	}

	public User() {

	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name="
				+ name + ", sex=" + sex + ", age=" + age + ", address="
				+ address + ", tel=" + tel + ", email=" + email + ", roles="
				+ roles + "]";
	}


}
