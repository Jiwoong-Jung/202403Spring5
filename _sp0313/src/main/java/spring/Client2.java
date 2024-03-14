package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client2 {

	private String host;
	
	public void send() {
		System.out.println("Client.send() to " + host);
	}
	
	public void setHost(String host) {
		System.out.println("setHost() 실행");
		this.host = host;
	}


	public void close() {
		System.out.println("Client2.close() 실행");
		
	}


	public void connect() {
		System.out.println("Client2.connect() 실행");
		
	}

}
