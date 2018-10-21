package ant.ioc.xml;

import static org.junit.Assert.*;

import org.junit.Test;

import ant.ioc.BeanDefinition;
import ant.ioc.SimpleBean;
import ant.ioc.factory.AutoWireCapableBeanFactory;
import ant.ioc.factory.BeanFactory;
import ant.ioc.io.ReasourceLoader;

public class XMLBeanDefinitionReaderTest {

	@Test
	public void test() throws Exception {
		XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(new ReasourceLoader());
		reader.loadBeanDefinations("ioc.xml");
		BeanDefinition bean = reader.getBeanDefinations().get("simpleBean");
		assertNotNull(bean);
		BeanFactory factory = new AutoWireCapableBeanFactory();
		factory.registerBeanDefination("simpleBean", bean);
		SimpleBean tBean = (SimpleBean)factory.getBean("simpleBean");
		
		System.out.println(tBean.getContent());
		assertEquals("hello",tBean.getContent());
	}

}