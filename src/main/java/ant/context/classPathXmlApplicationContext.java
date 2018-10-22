package ant.context;



import java.util.Map;

import ant.ioc.BeanDefinition;
import ant.ioc.factory.AbstractBeanFatory;
import ant.ioc.factory.AutoWireCapableBeanFactory;
import ant.ioc.io.ReasourceLoader;
import ant.ioc.xml.XMLBeanDefinitionReader;

public class classPathXmlApplicationContext extends AbstractApplicationContext{
	private String configLoc;
	
	public classPathXmlApplicationContext(String configLoc) {
		this(configLoc, new AutoWireCapableBeanFactory());
	}
	
	public classPathXmlApplicationContext(String configLoc,AbstractBeanFatory beanFatory) {
		super(beanFatory);
		this.configLoc = configLoc;
	}
	

	@Override
	public void registerBeanDefination(String name, BeanDefinition bean) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh() throws Exception {
		XMLBeanDefinitionReader xmlBeanDefinitionReader = new XMLBeanDefinitionReader(new ReasourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinations(configLoc);
		for(Map.Entry<String, BeanDefinition> entry: xmlBeanDefinitionReader.getBeanDefinations().entrySet()) {
			beanFactory.registerBeanDefination(entry.getKey(), entry.getValue());
		}
		
	}

}
