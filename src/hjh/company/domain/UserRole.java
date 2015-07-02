package hjh.company.domain;

public class UserRole {
	private String userId;
	private String password;
	private String name;
	private String sex;
	private int age;
	private String address;
	private String tel;
	private String email;
	
	private int roleId;
	private String roleName;
	
	public UserRole(User user){
		this.userId = user.getUserId();
		this.password = user.getPassword();
		this.name = user.getName();
		this.sex = user.getSex();
		this.age = user.getAge();
		this.address = user.getAddress();
		this.tel = user.getTel();
		this.email = user.getEmail();
		
		Role role = user.getRoles().iterator().next();
		this.roleId = role.getRoleId();
		this.roleName = role.getRoleName();
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
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
