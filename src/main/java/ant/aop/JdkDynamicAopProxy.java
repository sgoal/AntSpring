package ant.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.aopalliance.intercept.MethodInterceptor;

public class JdkDynamicAopProxy implements AopProxy,InvocationHandler{
	
	private AdvisedSupport advisedSupport;
	
	public JdkDynamicAopProxy(AdvisedSupport advisedSupport) {
		this.advisedSupport = advisedSupport;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MethodInterceptor methodInterceptor = advisedSupport.getMethodInterceptor();
		return methodInterceptor.invoke(new ReflectiveMethodInvocation(
				advisedSupport.getTargetSource().getTarget(),
				method,args));
	}

	@Override
	public Object getProxy() {
		return Proxy.newProxyInstance(getClass().getClassLoader(),
				new Class[]{advisedSupport.getTargetSource().getTargetClass()}, this);
	}

}
