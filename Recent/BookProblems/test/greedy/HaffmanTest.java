package greedy;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import greedy.Haffman;

public class HaffmanTest {

	private Haffman haffman;
	
	@Before
	public void beforeMethod() {
		this.haffman = new Haffman();
	}
	
	@After
	public void afterMethod() {
		this.haffman = null;
	}
	
	/** HaffMan code exist.*/
	@Test
	public void getHaffmanCodeTest() {
		List<List<Object>> charList = new ArrayList<List<Object>>();
		List<Object> list1 = new ArrayList<Object>();
		list1.add('a'); list1.add(12); charList.add(list1);
		
		List<Object> list2 = new ArrayList<Object>();
		list2.add('b'); list2.add(2); charList.add(list2);
		
		List<Object> list3 = new ArrayList<Object>();
		list3.add('c'); list3.add(7); charList.add(list3);
		
		List<Object> list4 = new ArrayList<Object>();
		list4.add('d'); list4.add(13); charList.add(list4);
		
		List<Object> list5 = new ArrayList<Object>();
		list5.add('e'); list5.add(14); charList.add(list5);
		
		List<Object> list6 = new ArrayList<Object>();
		list6.add('f'); list6.add(85); charList.add(list6);
		Map<Character,String> actualMap = this.haffman.getHaffmanCode(charList);
		
		Map<Character,String> expectedMap = new HashMap<Character,String>();
		expectedMap.put('a', "001");
		expectedMap.put('b', "0000");
		expectedMap.put('c', "0001");
		expectedMap.put('d', "010");
		expectedMap.put('e',"011");
		expectedMap.put('f', "1");
		
		assertEquals(expectedMap, actualMap);
	}
	
	
	/** If input is null. */
	@Test
	public void getHaffmanCodeTest2() {
		List<List<Object>> charList = null;
		assertEquals(null, this.haffman.getHaffmanCode(charList));
	}
	
	/** If input is empty. */
	@Test
	public void getHaffmanCodeTest3() {
		List<List<Object>> charList = new ArrayList<List<Object>>();
		assertEquals(null, this.haffman.getHaffmanCode(charList));
	}
	
	/** HaffMan code exist. One of the input in input list is null.*/
	@Test
	public void getHaffmanCodeTest4() {
		List<List<Object>> charList = new ArrayList<List<Object>>();
		List<Object> list1 = new ArrayList<Object>();
		list1.add('a'); list1.add(12); charList.add(list1);
		
		List<Object> list2 = new ArrayList<Object>();
		list2.add('b'); list2.add(2); charList.add(list2);
		
		List<Object> list3 = new ArrayList<Object>();
		list3.add('c'); list3.add(7); charList.add(list3);
		
		List<Object> list4 = new ArrayList<Object>();
		list4.add('d'); list4.add(13); charList.add(list4);
		
		List<Object> list5 = new ArrayList<Object>();
		list5.add('e'); list5.add(14); charList.add(list5);
		
		List<Object> list6 = new ArrayList<Object>();
		list6.add('f'); list6.add(85); charList.add(list6);
		
		List<Object> list7 = null;
		charList.add(list7);
		
		Map<Character,String> actualMap = this.haffman.getHaffmanCode(charList);
		
		Map<Character,String> expectedMap = new HashMap<Character,String>();
		expectedMap.put('a', "001");
		expectedMap.put('b', "0000");
		expectedMap.put('c', "0001");
		expectedMap.put('d', "010");
		expectedMap.put('e',"011");
		expectedMap.put('f', "1");
		
		assertEquals(expectedMap, actualMap);
	}
}
