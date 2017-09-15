package Trie;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class KMaxOccWordsTest {

	private KMaxOccWords kMaxOccWords;
	@Before
	public void setUp() throws Exception {
		this.kMaxOccWords = new KMaxOccWords();
	}

	@Test
	public void testGetKMostOccuringWords() {
		String[] words = {"code", "coder", "coding", "codable", "codec", "codecs", 
				"coded", "codeless", "codec", "codecs", "codependence", "codex",
				"codify", "codependents", "codes", "code", "coder", "codesign", 
				"codec", "codeveloper", "codrive", "codec", "codecs", "codiscovered"};
		List<String> actual = this.kMaxOccWords.getKMostOccuringWords(words, 4);
		List<String> expected = new ArrayList<String>(Arrays.asList("codec","codecs","code","coder"));
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetKMostOccuringWords_KOutOfRange() {
		String[] words = {"abc","abc","abc"};
		List<String> actual = this.kMaxOccWords.getKMostOccuringWords(words, 2);
		List<String> expected = new ArrayList<String>(Arrays.asList("abc"));
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetKMostOccuringWords_MissingBucket() {
		String[] words = {"abc","abc","abc","ad"}; // bucket at 1 is missing.
		List<String> actual = this.kMaxOccWords.getKMostOccuringWords(words, 2);
		List<String> expected = new ArrayList<String>(Arrays.asList("abc","ad"));
		assertEquals(expected,actual);
	}

}
