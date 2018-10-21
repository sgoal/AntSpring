package ant.ioc;

public class PropertyValue {
	private String name;
	private Object value;
	
	public PropertyValue(String name, Object val) {
		this.name = name;
		this.value = val;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}
	
}
