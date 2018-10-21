package ant.ioc.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ant.ioc.BeanDefinition;

public abstract class AbstractBeanFatory implements BeanFactory{
private Map<String, BeanDefinition> beanMap = new ConcurrentHashMap<String, BeanDefinition>();
	
	public Object getBean(String beanName) {
		return beanMap.get(beanName).getBean();
	}
	
	public void registerBeanDefination(String name, BeanDefinition beanDef) {
		Object bean = doCreateBean(beanDef);
		beanDef.setBean(bean);
		beanMap.put(name, beanDef);
	}
	
	protected abstract Object doCreateBean(BeanDefinition def);
}
