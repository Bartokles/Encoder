package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import encoder.CesarTextEncoder;

public class CesarEncoderTest {

	
	private static CesarTextEncoder cesarEncoder;
	
	@BeforeClass
	public static void invokeBeforeAnyTest() {
		cesarEncoder = new CesarTextEncoder(4);
		System.out.println("beforeclass");
	}

	@AfterClass
	public static void invokeAfterAllTestsAreDone() {
		System.out.println("afterclass");
	}

	@Before
	public void invokeBeforeEachTest() {
		System.out.println("before");
	}

	@After
	public void invokeAfterEachTest() {
		System.out.println("after");
	}

	@Test
	public void shouldEncodeText() {
		// given
		String textToEncode = "abcdefghijklmnopqrstuvwxyz";

		// when
		String actualEncodedText = cesarEncoder.encode(textToEncode);
		String expectedEncodedText = "efghijklmnopqrstuvwxyzabcd";

		// then
		Assert.assertEquals(expectedEncodedText, actualEncodedText);

	}
	@Test
	public void shouldDecodeText() {
		// given 
		String textToDecode = "efghijklmnopqrstuvwxyzabcd";
		
		// when
		String actualDecodedText = cesarEncoder.decode(textToDecode);
		String expectedDecodedText = "abcdefghijklmnopqrstuvwxyz";
		
		//then
		Assert.assertEquals(expectedDecodedText, actualDecodedText);
		
	}

}
