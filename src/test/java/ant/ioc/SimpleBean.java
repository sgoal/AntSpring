package ant.ioc;

public class SimpleBean {
	private String Content;
	
	public void setContent(String content) {
		Content = content;
	}

	public String test() {
		return "test bean";
	}
}
