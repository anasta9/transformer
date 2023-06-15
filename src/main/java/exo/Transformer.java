package exo;

import java.util.HashMap;

import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Transform a text by replacing a set of tokens by pre-defined values: Example:
 * I an {name} -> I am Robert A token should be a name between brackets :
 * {token}
 * 
 **/

public class Transformer {

	private HashMap<String, String> tokens = new HashMap<String, String>();

	public void addToken(String token, String value) {
		tokens.put(token, value);
	}

	public String transform2(String message) {
		String changedmessage = message;
		for (Entry<String, String> entry : tokens.entrySet())
			changedmessage = changedmessage.replace(entry.getKey(), entry.getValue());
		return message;
	}

	public String transform(String message) {
		int capacity = (int) (message.length() * 1.2f);
		StringBuilder stringBuilder = new StringBuilder(capacity);
		Pattern pattern = Pattern.compile("\\{(.*?)\\}");
		Matcher matcher = pattern.matcher(message);
		while (matcher.find()) {
			String token = matcher.group(1);
			String value = tokens.get(token);
			if (value != null)
				matcher.appendReplacement(stringBuilder, value);
			else
				matcher.appendReplacement(stringBuilder, "{" + token + "}");

		}
		matcher.appendTail(stringBuilder);

		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Main.class);

		String message = "This is just a message to {name} who lives at {address} and works at {company}, you can call on {phone}";
		logger.info(message);
		Transformer transformer = new Transformer();

		transformer.addToken("name", "George");
		transformer.addToken("address", "78, rue Will Smith");
		transformer.addToken("phone", "03 54 87 69 88");
		transformer.addToken("company", "Amazon");
		System.out.println(transformer.toString());
		System.out.println(transformer.transform(message));

		logger.debug("Debug log message");
		logger.info("Info log message");
		logger.error("Error log message");
		logger.warn("Warn log message");

	}
}
