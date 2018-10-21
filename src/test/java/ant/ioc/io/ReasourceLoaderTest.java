package ant.ioc.io;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class ReasourceLoaderTest {

	@Test
	public void test() {
		ReasourceLoader loader = new ReasourceLoader();
		InputStream stream;
		try {
			stream = loader.getResource("ioc.xml").getInputStream();
			assertNotNull(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

}
