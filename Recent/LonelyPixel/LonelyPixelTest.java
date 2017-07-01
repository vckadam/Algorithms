package Leetcode.LonelyPixel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LonelyPixelTest {
	@Test
	public void getLonelyPixelTest() {
		LonelyPixel obj = new LonelyPixel();
		char[][] array1 = {{'W','W','B'},{'W','B','W'},{'B','W','W'}};
		assertEquals(3, obj.getLonelyPixel(array1));
		char[][] array2 = {{'B','B','B'},{'B','B','B'},{'B','B','B'}};
		assertEquals(0, obj.getLonelyPixel(array2));
		char[][] array3 = {{'W','W','W'},{'B','B','B'},{'W','W','W'}};
		assertEquals(0, obj.getLonelyPixel(array3));
		char[][] array4 = null;
		assertEquals(0, obj.getLonelyPixel(array4));
		char[][] array5 = {{}};
		assertEquals(0, obj.getLonelyPixel(array5));
		char[][] array6 = {{'W','B','W'},{'W','B','W'},{'W','B','W'}};
		assertEquals(0, obj.getLonelyPixel(array6));
		char[][] array7 = {{'W','W'},{'W','B'},{'B','W'}};
		assertEquals(2, obj.getLonelyPixel(array7));
	}
}
