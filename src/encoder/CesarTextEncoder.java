package encoder;

public class CesarTextEncoder implements TextEncoder{

	private int key;
	public CesarTextEncoder(int key) {
		this.key = key;
	}
	
	@Override
	public String encode(String text) {
		int i = 0;
		String result = "";
		for(i = 0; i<text.length(); i++)	
		{
			int j = (int)text.charAt(i);
			int ucode=(j-97+key)%26+97;
			result = result.concat(String.valueOf((char)ucode));
		}
		return result;
	}

	@Override
	public String decode(String text) {
		int i = 0;
		String result = "";
		for(i = 0; i<text.length(); i++)	
		{
			int j = (int)text.charAt(i);
			int ucode=(j-97-key+26)%26+97;
			result = result.concat(String.valueOf((char)ucode));
		}
		return result;
	}
	public static void main(String[] args) {
		CesarTextEncoder encoder = new CesarTextEncoder(3);
		String name = "abcdez";
		System.out.println(encoder.decode(name));
	}
		/// Zrobiæ alfabet Encoder.
}
