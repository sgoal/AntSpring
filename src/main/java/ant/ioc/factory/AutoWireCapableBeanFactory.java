package ant.ioc.factory;

import java.lang.reflect.Field;

import ant.ioc.BeanDefinition;
import ant.ioc.BeanReference;
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
			Object value0 = value.getValue();
			if(value0 instanceof BeanReference) {
				String beanRef = ((BeanReference) value0).getName();
				value0 = getBean(beanRef);
			}
			field.set(bean,value0);
			
		}
	}
	
}
