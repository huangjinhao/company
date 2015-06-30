package hjh.company.domain;

import java.util.HashSet;
import java.util.Set;

public class Authority {
	private int authorityId;
	private String authorityName;
	private String url;
    private Set<Role> roles = new HashSet<Role>();

    
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public int getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	
	public Authority(int authorityId, String authorityName, String url) {
		super();
		this.authorityId = authorityId;
		this.authorityName = authorityName;
		this.url = url;
	}

	public Authority() {

	}
	
	@Override
	public String toString() {
		return "Authority [authority=" + authorityId + ", authorityName="
				+ authorityName + ", url=" + url + "]";
	}
}
