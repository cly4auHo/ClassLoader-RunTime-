package app;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MyClassLoader extends ClassLoader {

	@Override
	public Class loadClass(String className) throws ClassNotFoundException {
        if(!"app.Cat".equals(className))
            return super.loadClass(className);

		String catUrl = "file:C:\\Users\\Den\\Downloads\\lesson14\\lesson14\\target\\classes\\app\\Cat.class";
		URL url = null;
		try {
			url = new URL(catUrl);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		InputStream is = null;
		try {
			is = url.openConnection().getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int c = 0;
		try {
			while ((c = is.read()) != -1) {
				baos.write(c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		byte[] byteArray = baos.toByteArray();

		return defineClass(className, byteArray, 0, byteArray.length);
	}

}
