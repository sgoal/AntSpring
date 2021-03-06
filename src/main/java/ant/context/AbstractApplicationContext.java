package ant.context;


import ant.ioc.factory.AbstractBeanFatory;

public abstract class AbstractApplicationContext implements ApplicationContext{
	protected AbstractBeanFatory beanFactory;
	
	public AbstractApplicationContext(AbstractBeanFatory beanFatory) {
		this.beanFactory = beanFatory;
	}
	
	@Override
	public Object getBean(String beanName) throws Exception {
		return beanFactory.getBean(beanName);
	}
	
	public abstract void refresh() throws Exception;


}
