package ant.ioc;

import java.io.IOException;

public interface BeanDefinitionReader {
	void loadBeanDefinations(String loc)throws IOException;
}
