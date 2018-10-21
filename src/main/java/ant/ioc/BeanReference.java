package ant.ioc;

public class BeanReference {
	private String name;
	private Object bean;
	
	public BeanReference(String name) {
		this.name = name;
	}
	
	public Object getBean() {
		return bean;
	}
	public String getName() {
		return name;
	}
	public void setBean(Object bean) {
		this.bean = bean;
	}
	
	public void setName(String beanName) {
		this.name = beanName;
	}
}
