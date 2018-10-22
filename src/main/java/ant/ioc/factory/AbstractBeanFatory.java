package ant.ioc.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ant.ioc.BeanDefinition;

public abstract class AbstractBeanFatory implements BeanFactory{
	private Map<String, BeanDefinition> beanMap = new ConcurrentHashMap<String, BeanDefinition>();
	
	private List<String> beanNames = new ArrayList<>();
	
	public Object getBean(String beanName) throws Exception {
		Object bean =  beanMap.get(beanName).getBean();
		if(bean == null) {
			BeanDefinition definition = beanMap.get(beanName);
			bean = doCreateBean(definition);
			definition.setBean(bean);
		}
		return bean;
	}
	
	public void registerBeanDefination(String name, BeanDefinition beanDef) throws Exception {
		beanNames.add(name);
		beanMap.put(name, beanDef);
	}
	
	public void preInstantiateSingletons() throws Exception {
		for(String name :beanNames) {
			getBean(name);
		}
	}
	
	protected abstract Object doCreateBean(BeanDefinition def) throws Exception;
}
