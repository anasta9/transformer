package exo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Main.class);
		
		String message = "This is just a message to {name} who lives at {address} and works at {company}, you can call on {phone}";

		Transformer transformer = new Transformer();
		// Transformer georgeTransformer = new Transformer("name", "address", "phone",
		// "company");

		transformer.addToken("{name}", "George");
		transformer.addToken("{address}", "78, rue Will Smith");
		transformer.addToken("{phone}", "03 54 87 69 88");
		transformer.addToken("{company}", "Amazon");
		System.out.println(transformer.toString());

		logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");
        logger.warn("Warn log message");
	}
}