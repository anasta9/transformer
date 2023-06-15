package exo;

public class Main {
	public static void main(String[] args) {

		String message = "This is just a message to {name} who lives at {address} and works at {company}, you can call on {phone}";

		Transformer transformer = new Transformer();

		transformer.addToken("{name}", "George");
		transformer.addToken("{address}", "78, rue Will Smith");
		transformer.addToken("{phone}", "03 54 87 69 88");
		transformer.addToken("{company}", "Amazon");

	}
}