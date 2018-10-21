package ant.ioc.factory;

import static org.junit.Assert.*;

import org.junit.Test;

import ant.ioc.BeanDefinition;
import ant.ioc.SimpleBean;

public class AutoWireCapableBeanFactoryTest {

	@Test
	public void test() {
		BeanFactory factory = new AutoWireCapableBeanFactory();
		BeanDefinition definition = new BeanDefinition();
		definition.setBeanClass(SimpleBean.class);
		definition.setBeanClassName("ant.ioc.SimpleBean");
		
		factory.registerBeanDefination("simpleBean", definition);
		
		SimpleBean bean = (SimpleBean) factory.getBean("simpleBean");
		assertEquals("test bean", bean.test());
		
	}

}
