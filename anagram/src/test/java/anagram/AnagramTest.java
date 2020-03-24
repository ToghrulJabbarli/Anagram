package anagram;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {

	@Test
	public void AreAnagramesPassed() {
		StringEngine str =  new StringEngine();
		Assert.assertTrue(str.areAnagram("Apple", "ppleA"));
	}
	
	@Test
	public void CheckPermut_1()
	{
		StringEngine str = new StringEngine();
		ArrayList<String> perms = new ArrayList<String>();
		perms = str.printPermutationsIterative("ABC");
		Assert.assertEquals(perms.size(), 6);
	}
	
	@Test
	public void CheckPermut_2()
	{
		StringEngine str = new StringEngine();
		ArrayList<String> perms = new ArrayList<String>();
		perms = str.printPermutationsIterative("Toghrul");
		Assert.assertEquals(perms.size(), 5040);
	}
	
}
