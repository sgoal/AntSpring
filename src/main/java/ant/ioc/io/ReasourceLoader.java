package ant.ioc.io;

import java.net.URL;

public class ReasourceLoader {
	public Resource getResource(String loc) {
		URL resource = this.getClass().getClassLoader().getResource(loc);
		return new URLResource(resource);
	}
}
