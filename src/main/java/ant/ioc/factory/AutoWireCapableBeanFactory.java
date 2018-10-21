package ant.ioc.factory;

import java.lang.reflect.Field;

import ant.ioc.BeanDefinition;
import ant.ioc.PropertyValue;

public class AutoWireCapableBeanFactory extends AbstractBeanFatory{

	@Override
	protected Object doCreateBean(BeanDefinition def) throws Exception {
		Object bean = def.getBeanClass().newInstance();
		applyPropertyValues(bean, def);
		return bean;
	}
	
	protected void applyPropertyValues(Object bean, BeanDefinition definition) throws Exception {
		for(PropertyValue value:definition.getPropertyValues().getPropertyValues()) {
			Field field = bean.getClass().getDeclaredField(value.getName());
			field.setAccessible(true);
			field.set(bean,value.getValue());
			
		}
	}
	
}
