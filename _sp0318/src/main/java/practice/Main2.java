package practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main2 {

	private static Logger LOGGER 
	              = LoggerFactory.getLogger(Main2.class);
	public static void main(String[] args) {
		LOGGER.error("나온다");
		LOGGER.info("나온다");
		System.out.println("나온다");

	}

}
