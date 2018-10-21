package ant.ioc.factory;

import ant.ioc.BeanDefinition;

public class AutoWireCapableBeanFactory extends AbstractBeanFatory{

	@Override
	protected Object doCreateBean(BeanDefinition def) {
		try {
			return def.getBeanClass().newInstance();
		} catch (InstantiationException e) {
			//没有默认构造函数，比如接口
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			//构造函数private
			e.printStackTrace();
		}
		return null;
	}
	
}
