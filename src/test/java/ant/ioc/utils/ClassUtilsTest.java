package ant.ioc.utils;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ant.ioc.BeanService;
import ant.ioc.Service;
import ant.ioc.io.annotation.AntAutoWired;

public class ClassUtilsTest {

	@Test
	public void test() {
		List<?> classes = ClassUtils.getAllClassByInterface(null,Service.class);
		System.out.println(classes);
	}
	
	@Test
	public void test1() {
		List<?> classes = ClassUtils.getAllClassByInterface(
				AntAutoWired.class,Service.class);
		System.out.println(classes);
	}
	
	@Test
	public void test2() {
		boolean res = BeanService.class.isAnnotationPresent(AntAutoWired.class);
		System.out.println(res);
	}

}
