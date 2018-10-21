package ant.ioc.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLResource implements Resource{
	private URL urlLoction;
	
	public URLResource(URL loc) {
		this.urlLoction = loc;
	}

	public InputStream getInputStream() throws IOException {
		URLConnection connection = urlLoction.openConnection();
		connection.connect();
		return connection.getInputStream();
//		return urlLoction.openStream();
	}
	
}
