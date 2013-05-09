package svnUtil;

public class SVNproperty {
	private String Url;
	private String name;
	private String passwd;
	
	public SVNproperty(String Url,String name,String passwd){
		this.Url = Url;
		this.name = name;
		this.passwd = passwd;
	}
	
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		this.Url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
