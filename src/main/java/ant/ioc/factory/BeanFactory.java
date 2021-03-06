package ant.ioc.factory;

import ant.ioc.BeanDefinition;

/**
 * 
 * @author liuhdsgoal
 */
public interface BeanFactory {
	
	public Object getBean(String beanName) throws Exception;
	
	public void registerBeanDefination(String name, BeanDefinition bean) throws Exception ;
}
