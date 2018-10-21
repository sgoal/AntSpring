package ant.ioc;

import java.util.List;

public class BeanService {
	private SimpleBean bean;
	private String name;
	private List<String> listName;
	
	public List<String> getListName() {
		return listName;
	}
	
	public SimpleBean getBean() {
		return bean;
	}
	public String getName() {
		return name;
	}
}
