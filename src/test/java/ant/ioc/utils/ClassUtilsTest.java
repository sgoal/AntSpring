package ant.ioc.utils;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ant.ioc.BeanService;
import ant.ioc.Service;

public class ClassUtilsTest {

	@Test
	public void test() {
		List<?> classes = ClassUtils.getAllClassByInterface(null,Service.class);
		System.out.println(classes);
	}

}
