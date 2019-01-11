package encoder;



public class NewEncoder implements TextEncoder {
	
	public String encode(String text) {
		int i = 0;
		String result = "";
		for (i = 0; i < text.length(); i++) {
			char j = text.charAt(i);
			if (text.charAt(i) == 'a') {
				j = '@';
			}
			if (text.charAt(i) == 'b') {
				j = '&';
			}
			if (text.charAt(i) == 'c') {
				j = '(';
			}
			if (text.charAt(i) == 'd') {
				j = '<';
			}
			if (text.charAt(i) == 'e') {
				j = '$';
			}
			if (text.charAt(i) == 'f') {
				j = '*';
			}
			if (text.charAt(i) == 'g') {
				j = '!';
			}
			if (text.charAt(i) == 'h') {
				j = 'L';
			}
			if (text.charAt(i) == 'i') {
				j = 'I';
			}
			if (text.charAt(i) == 'j') {
				j = 'B';
			}
			if (text.charAt(i) == 'k') {
				j = '0';
			}
			if (text.charAt(i) == 'l') {
				j = '#';
			}
			if (text.charAt(i) == 'm') {
				j = 'M';
			}
			if (text.charAt(i) == 'n') {
				j = '9';
			}
			if (text.charAt(i) == 'o') {
				j = 'O';
			}
			if (text.charAt(i) == 'p') {
				j = '%';
			}
			if (text.charAt(i) == 'r') {
				j = 'A';
			}
			if (text.charAt(i) == 's') {
				j = '^';
			}
			if (text.charAt(i) == 't') {
				j = ')';
			}
			if (text.charAt(i) == 'u') {
				j = '~';
			}
			if (text.charAt(i) == 'w') {
				j = 'Y';
			}
			if (text.charAt(i) == 'x') {
				j = 'Z';
			}
			if (text.charAt(i) == 'y') {
				j = '+';
			}
			if (text.charAt(i) == 'z') {
				j = '-';
			}
			result = result + j;
		}
		return result;
	}

	public String decode(String text) {
		int i = 0;
		String result = "";
		for (i = 0; i < text.length(); i++) {
			char j = text.charAt(i);
			if (text.charAt(i) == '@') {
				j = 'a';
			}
			if (text.charAt(i) == '&') {
				j = 'b';
			}
			if (text.charAt(i) == '(') {
				j = 'c';
			}
			if (text.charAt(i) == '<') {
				j = 'd';
			}
			if (text.charAt(i) == '$') {
				j = 'e';
			}
			if (text.charAt(i) == '*') {
				j = 'f';
			}
			if (text.charAt(i) == '!') {
				j = 'g';
			}
			if (text.charAt(i) == 'L') {
				j = 'h';
			}
			if (text.charAt(i) == 'I') {
				j = 'i';
			}
			if (text.charAt(i) == 'B') {
				j = 'j';
			}
			if (text.charAt(i) == '0') {
				j = 'k';
			}
			if (text.charAt(i) == '#') {
				j = 'l';
			}
			if (text.charAt(i) == 'M') {
				j = 'm';
			}
			if (text.charAt(i) == '9') {
				j = 'n';
			}
			if (text.charAt(i) == 'O') {
				j = 'o';
			}
			if (text.charAt(i) == '%') {
				j = 'p';
			}
			if (text.charAt(i) == 'A') {
				j = 'r';
			}
			if (text.charAt(i) == '^') {
				j = 's';
			}
			if (text.charAt(i) == ')') {
				j = 't';
			}
			if (text.charAt(i) == '~') {
				j = 'u';
			}
			if (text.charAt(i) == 'Y') {
				j = 'w';
			}
			if (text.charAt(i) == 'Z') {
				j = 'x';
			}
			if (text.charAt(i) == '+') {
				j = 'y';
			}
			if (text.charAt(i) == '-') {
				j = 'z';
			}
			result = result + j;
		}
		return result;
	}

	public static void main(String[] args) {
		NewEncoder encoder = new NewEncoder();
		String name = "abcdez";
		String encodedText = encoder.encode(name);
		System.out.println(encodedText);
		System.out.println(encoder.decode(encodedText));
	}

}
