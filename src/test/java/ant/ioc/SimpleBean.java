package ant.ioc;

public class SimpleBean {
	private String content;
	
	public void setContent(String content) {
		this.content = content;
	}

	public String test() {
		return "test bean";
	}
	
	public String getContent() {
		return this.content;
	}
}
