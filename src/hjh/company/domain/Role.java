package hjh.company.domain;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private int roleId;
	private String roleName;
	private Set<User> users = new HashSet<User>();
	private Set<Authority> authorities = new HashSet<Authority>();

	
	
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public Role(int roleId, String roleName, Set<User> users,
			Set<Authority> authorities) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.users = users;
		this.authorities = authorities;
	}

	public Role() {

	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName +  ", authorities=" + authorities + "]";
	}

}
