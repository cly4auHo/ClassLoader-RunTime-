package app;

import java.util.Scanner;

/**
 * 
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		MyClassLoader classLoader = new MyClassLoader();
		
		try {
			Class catC = classLoader.loadClass("app.Cat");
			Object cat= catC.newInstance();
			System.out.println("FIRST CAT " + cat);
			Scanner scan = new Scanner(System.in);	
			scan.nextLine();
			classLoader = new MyClassLoader();
			Class catClass = classLoader.loadClass("app.Cat");
			Object obj= catClass.newInstance();
			System.out.println("CLASSLOADER CAT " +obj);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		C c = new C();
//		B b = new B();
//		A a = new A();
//		System.out.println("OKAY");
		catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
