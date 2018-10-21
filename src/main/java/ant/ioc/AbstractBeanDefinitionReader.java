package ant.ioc;

import java.util.HashMap;
import java.util.Map;

import ant.ioc.io.ReasourceLoader;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
	
	private Map<String, BeanDefinition> beanDefinations = new HashMap<String, BeanDefinition>();
	private ReasourceLoader reasourceLoader;
	
	public AbstractBeanDefinitionReader(ReasourceLoader loader) {
		this.reasourceLoader = loader;
	}
	
	public Map<String, BeanDefinition> getBeanDefinations() {
		return beanDefinations;
	}
	public ReasourceLoader getReasourceLoader() {
		return reasourceLoader;
	}

}
