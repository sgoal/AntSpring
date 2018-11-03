package ant.ioc;

import java.util.List;

import ant.ioc.io.annotation.AntAutoWired;

@AntAutoWired
public class BeanService implements Service{
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

	@Override
	public void service() {
		System.out.println("service....");
	}
}
