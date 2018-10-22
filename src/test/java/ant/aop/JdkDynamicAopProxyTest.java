package ant.aop;

import static org.junit.Assert.*;

import org.junit.Test;

import ant.context.ApplicationContext;
import ant.context.ClassPathXmlApplicationContext;
import ant.ioc.BeanService;
import ant.ioc.Service;

public class JdkDynamicAopProxyTest {

	@Test
	public void test() throws Exception {
	
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
		BeanService service = (BeanService) applicationContext.getBean("beanService");
		service.service();
		// 1. 设置被代理对象(Joinpoint)
		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource(Service.class, service);
		advisedSupport.setTargetSource(targetSource);

		// 2. 设置拦截器(Advice)
		TraceInterceptor interceptor = new TraceInterceptor();
		advisedSupport.setMethodInterceptor(interceptor);

		// 3. 创建代理(Proxy)
		JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
		Service serviceProxy = (Service) jdkDynamicAopProxy.getProxy();

        // 4. 基于AOP的调用
		serviceProxy.service();
	}

}
