mport java.io.*;
import java.net.*;
public class Main {
	
	public void go() {
		try {
			Socket s = new Socket("127.0.0.1", 4242);
			InputStreamReader sr = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(sr);		
			String advice = reader.readLine();
			System.out.println("Today you shuld " + advice);
			
			reader.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.go();

	}

}
