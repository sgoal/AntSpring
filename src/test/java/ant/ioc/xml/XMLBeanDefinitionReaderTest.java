package ant.ioc.xml;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import ant.ioc.BeanDefinition;
import ant.ioc.BeanService;
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
	
	@Test
	public void test1() throws Exception {
		XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(new ReasourceLoader());
		reader.loadBeanDefinations("ioc.xml");
		BeanFactory factory = new AutoWireCapableBeanFactory();
		for(Map.Entry<String,BeanDefinition> entry: reader.getBeanDefinations().entrySet()) {
			factory.registerBeanDefination(entry.getKey(), entry.getValue());
		}
		SimpleBean tBean = (SimpleBean)factory.getBean("simpleBean");
		BeanService service = (BeanService) factory.getBean("beanService");
		assertEquals("hello",tBean.getContent());
		assertEquals(service.getBean(),tBean);
		assertTrue(service.getListName().size()==2);
		System.out.println(service.getListName());
	}

}
