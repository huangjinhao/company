package ftt.company.domain;

public class Authority {
	private int id;
	private String authorityName;
	private String url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Authority [id=" + id + ", authorityName=" + authorityName
				+ ", url=" + url + "]";
	}
}
