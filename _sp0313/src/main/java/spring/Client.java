package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean {

	private String host;
	
	public void send() {
		System.out.println("Client.send() to " + host);
	}
	
	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Client.destroy() 실행");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client.afterPropertiesSet() 실행");
		
	}

}
