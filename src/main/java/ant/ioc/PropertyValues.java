package ant.ioc;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
	private List<PropertyValue> values = new ArrayList<PropertyValue>();
	
	public void addPropertyValue(PropertyValue v) {
		values.add(v);
	}
	
	public List<PropertyValue> getPropertyValues(){
		return values;
	}
}
