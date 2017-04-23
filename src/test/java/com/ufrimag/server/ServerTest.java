package com.ufrimag.server;

import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.Test;

import com.ufrimag.server.Exception.FormatIncrementDecException;
import com.ufrimag.server.Exception.KeyNotFoundException;

import jdk.nashorn.internal.ir.annotations.Ignore;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ServerTest {

	Hashtable<String, Object> hashtable = Server.getHashtable();

	@Test
	@Ignore
	public void testIsEmpty() {

		Assert.assertTrue(hashtable.isEmpty());
	}

	@SuppressWarnings({})
	@Test
	public void testIsKeyFound() {

		String keyTest = "testKey";
		hashtable.put(keyTest, 1);

		Assert.assertNotNull(hashtable.get(keyTest));

	}
	
	@Test
	public void testGet(){
		String key= "testkey";
		hashtable.put(key, 1);
		try {
			Assert.assertEquals(1, Server.getValue(key));
		} catch (KeyNotFoundException e) {
			Assert.fail(e.getMessage());
		}	
	}
	
	@Test
	public void testSet(){
		String key= "testkey";
		int value=1;
		Assert.assertTrue(Server.setKey(key, value));
	}
	

	@SuppressWarnings({})
	@Test
	public void testIsKeyNotFound() {

		String keyTest = "testKey";
		hashtable.put(keyTest, 1);

		Assert.assertNull(hashtable.get("keyNotFound"));

	}

	@Test
	public void testIncrementIntegerBy1() {

		String key = "integer";
		hashtable.put(key, 1);

		try {
			Assert.assertTrue(Server.incrementer(key));
			Assert.assertEquals(2, hashtable.get(key));
		} catch (KeyNotFoundException e) {
			Assert.fail(e.getMessage());
		} catch (FormatIncrementDecException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testIncrementNotFoundIntegerNotValid() {

		String key = "integer";
		hashtable.put(key, 1);

		try {
			Server.incrementer("integerNotFound");
		} catch (KeyNotFoundException e) {
			Assert.assertTrue(true);
		} catch (FormatIncrementDecException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testIncrementStringNotValid() {

		String key = "string";
		hashtable.put(key, "fail");

		try {
			Server.incrementer(key);
		} catch (KeyNotFoundException e) {
			Assert.fail(e.getMessage());
		} catch (FormatIncrementDecException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testIncrementIntegerList() {

		String key = "testlist";
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		hashtable.put(key, list);
		try {
			Assert.assertTrue(Server.incrementer(key));
			list = (ArrayList<Integer>) hashtable.get(key);
			Assert.assertEquals(new Integer(2), list.get(0));
			Assert.assertEquals(new Integer(3), list.get(1));
		} catch (KeyNotFoundException e) {
			Assert.fail(e.getMessage());
		} catch (FormatIncrementDecException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testDecrementInteger() {
		String key = "testint";
		hashtable.put(key, 2);
		try {
			Assert.assertTrue(Server.decrementer(key));
			Assert.assertEquals(1, hashtable.get(key));
		} catch (KeyNotFoundException e) {
			Assert.fail(e.getMessage());
		} catch (FormatIncrementDecException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testDecrementNotFoundIntegerNotValid() {

		String key = "integer";
		hashtable.put(key, 1);

		try {
			Server.decrementer("integerNotFound");
		} catch (KeyNotFoundException e) {
			Assert.assertTrue(true);
		} catch (FormatIncrementDecException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testDecrementStringNotValid() {

		String key = "string";
		hashtable.put(key, "fail");

		try {
			Server.decrementer(key);
		} catch (KeyNotFoundException e) {
			Assert.fail(e.getMessage());
		} catch (FormatIncrementDecException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testDecrementIntegerList() {

		String key = "testlist";
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		hashtable.put(key, list);
		try {
			Assert.assertTrue(Server.decrementer(key));
			list = (ArrayList<Integer>) hashtable.get(key);
			Assert.assertEquals(new Integer(0), list.get(0));
			Assert.assertEquals(new Integer(1), list.get(1));
		} catch (KeyNotFoundException e) {
			Assert.fail(e.getMessage());
		} catch (FormatIncrementDecException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testAdditionInteger() {
		String key = "test";
		hashtable.put(key, 1);
		int x = 3;
		try {
			Assert.assertTrue(Server.additionValue(key, x));
			Assert.assertEquals(4, hashtable.get(key));
		} catch (FormatIncrementDecException e) {
			Assert.fail(e.getMessage());
		} catch (KeyNotFoundException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testAdditionNotFoundIntegerNotValid() {

		String key = "integer";
		hashtable.put(key, 1);

		try {
			Server.additionValue("integerNotFound", 2);
		} catch (KeyNotFoundException e) {
			Assert.assertTrue(true);
		} catch (FormatIncrementDecException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testAdditionStringNotValid() {

		String key = "string";
		hashtable.put(key, "fail");

		try {
			Server.additionValue(key, 3);
		} catch (KeyNotFoundException e) {
			Assert.fail(e.getMessage());
		} catch (FormatIncrementDecException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testAdditionIntegerList() {

		String key = "testlist";
		ArrayList<Integer> list = new ArrayList<Integer>();
		int x = 2;
		list.add(1);
		list.add(2);
		hashtable.put(key, list);
		try {
			Assert.assertTrue(Server.additionValue(key, x));
			list = (ArrayList<Integer>) hashtable.get(key);
			Assert.assertEquals(new Integer(3), list.get(0));
			Assert.assertEquals(new Integer(4), list.get(1));
		} catch (KeyNotFoundException e) {
			Assert.fail(e.getMessage());
		} catch (FormatIncrementDecException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testAdditionIntegerListIndex() {
		String key = "list";
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0, 1);
		list.add(1, 2);
		hashtable.put(key, list);
		try {
			Assert.assertTrue(Server.additionValueToListElement(key, 0, 7));
			list = (ArrayList<Integer>) hashtable.get(key);
			Assert.assertEquals(new Integer(8), list.get(0));
		} catch (KeyNotFoundException e) {
			Assert.fail(e.getMessage());
		} catch (FormatIncrementDecException e) {
			Assert.fail(e.getMessage());
		}

	}
	
	@Test
	public void testAddElementList(){
		String key = "list";
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0, 1);
		list.add(1, 2);
		hashtable.put(key, list);
		int value=1;
		Assert.assertTrue(Server.addElementList(key,value));	
	}
	
	@Test
	public void testRemoveElementListIndex(){
		String key="list";
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0, 1);
		list.add(1, 2);
		hashtable.put(key, list);
		try {
			Assert.assertTrue(Server.RemoveElementListIndex(key, 0));
		} catch (KeyNotFoundException e) {
			Assert.fail(e.getMessage());
		} catch (FormatIncrementDecException e) {
			Assert.fail(e.getMessage());
		}

	}	
}
