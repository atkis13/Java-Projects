import java.io.*;
import java.net.*;
public class Main {
	
	String[] adviceList = {"go home", "work", " eat", "workout", "run"};
	
	public void go() {
		try {
			
		
			ServerSocket serverSock = new ServerSocket(4242);
			while(true) {
				Socket sock = serverSock.accept();
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
		}catch (IOException e) {
			// TODO: handle exception
		}
				
	}
	
	private String getAdvice() {
		int random = (int) (Math.random() * adviceList.length);
		return adviceList[random];
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.go();
	}

}
