package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import encoder.NewEncoder;


public class NewEncoderTest {

	@Test
	public void EncodeTest() {
		//given
		NewEncoder encoder = new NewEncoder();
		String givenText = "abc";
		
		//when
		String actualEncodedText = encoder.encode(givenText);
		String expectedText = "@&(";
		
		//then
		Assert.assertEquals(expectedText, actualEncodedText);
	}
	
	@Test
	public void DecodeTest() {
		//given
		NewEncoder decoder = new NewEncoder();
		String givenText = "@&(";
		
		//when
		String ActualDecodedText = decoder.decode(givenText);
		String expectedText = "abc";
				
		//then
		Assert.assertEquals(expectedText, ActualDecodedText);
		
	}
}

/// zrobiæ test na decodowanie i usprawniæ NewEncoder

