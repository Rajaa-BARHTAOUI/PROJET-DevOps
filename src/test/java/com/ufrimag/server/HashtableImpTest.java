package com.ufrimag.server;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.Assert;
import org.junit.Test;

import com.ufrimag.server.HashtableImp;
import com.ufrimag.server.HashtableS;
import com.ufrimag.server.Exception.FormatIncrementDecException;
import com.ufrimag.server.Exception.KeyNotFoundException;

public class HashtableImpTest {

	@Test
	public void addElementTest() throws RemoteException {
		String key = "list";
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		HashtableImp<String, ArrayList<Integer>> hash = new HashtableImp<String, ArrayList<Integer>>();
		Assert.assertTrue(hash.addElement(key, list));

	}

	@Test
	public void addElementInListTest() throws RemoteException {

		String key = "list";
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		HashtableImp<String, ArrayList<Integer>> hash = new HashtableImp<String, ArrayList<Integer>>();
		hash.addElement(key, list);
		try {

			Assert.assertEquals(2, hash.getValue(key).size());
			Assert.assertTrue(hash.addElementInList(key, 5));
			Assert.assertEquals(3, hash.getValue(key).size());
		} catch (KeyNotFoundException e) {
			Assert.fail("Failed test addElementInList() ");

		}
		try {
			hash.addElementInList("none", 5);
		} catch (KeyNotFoundException e) {

		}
	}

	@Test
	public void removeElementTest() throws RemoteException {
		String key = "list";
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		HashtableImp<String, ArrayList<Integer>> hash = new HashtableImp<String, ArrayList<Integer>>();
		hash.addElement(key, list);
		Assert.assertEquals("list", hash.removeElement(key));
		Assert.assertNull(hash.removeElement(key));

	}

	@Test
	public void removeElementListIndexTest() throws RemoteException, KeyNotFoundException {
		String key = "list";
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		HashtableImp<String, ArrayList<Integer>> hash = new HashtableImp<String, ArrayList<Integer>>();
		hash.addElement(key, list);
		Assert.assertEquals(-1, hash.removeElementListIndex("none", 1));
		Assert.assertEquals(-1, hash.removeElementListIndex("list", 3));
		Assert.assertEquals(1, hash.removeElementListIndex("list", 1));
	}

	@Test
	public void getValueTest() throws RemoteException {
		int key = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(11);
		list2.add(23);
		HashtableImp<Integer, ArrayList<Integer>> hash = new HashtableImp<Integer, ArrayList<Integer>>();
		hash.addElement(key, list);
		hash.addElement(2, list2);

		try {

			Assert.assertEquals(list.indexOf(1), hash.getValue(key).indexOf(1));
			Assert.assertEquals(2, hash.getValue(key).size());
			Assert.assertEquals(list.get(0), hash.getValue(key).get(0));

		} catch (KeyNotFoundException e) {
			Assert.fail(" failed test getValueTest() ");
		}

		try {
			hash.removeElement(key);
			hash.getValue(key);
		} catch (KeyNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(true);
		}

	}

	@Test
	public void setValueTest() throws RemoteException {
		String key1 = "k1";
		String key2 = "k2";
		HashtableImp<String, Integer> hash = new HashtableImp<String, Integer>();
		hash.addElement(key1, 3);
		hash.addElement(key2, 6);
		try {
			// a faire de set

			Assert.assertEquals((Object) 7, hash.setValue(key1, 7));
			Assert.assertEquals(hash.getValue(key1), hash.getValue(key1));

		} catch (KeyNotFoundException e) {
			Assert.fail(" failed test getValueTest() ");
		}

		try {
			hash.removeElement(key1);
			hash.setValue(key1, 6);

		} catch (KeyNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(true);
		}

	}

	@Test
	public void getValueListIndexTest() throws RemoteException {

		int key = 1;
		int key2 = 2;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(11);
		list2.add(23);
		HashtableImp<Integer, ArrayList<Integer>> hash = new HashtableImp<Integer, ArrayList<Integer>>();
		hash.addElement(key, list);
		hash.addElement(key2, list2);

		try {

			Assert.assertEquals(1, hash.getValueListIndex(key, 0));
			Assert.assertEquals(23, hash.getValueListIndex(key2, 1));

		} catch (KeyNotFoundException e) {
			Assert.fail(" failed test getValueListIndex() ");
		}

		try {
			hash.removeElementListIndex(key, 1);
			hash.getValueListIndex(key, 1);
			hash.getValueListIndex(key2, 2);
		} catch (KeyNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(true);
		}

	}

	@Test
	public void setValueListIndexTest() throws RemoteException {

		String key1 = "k1";
		String key2 = "k2";
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(1.23);
		list.add(2.0);
		ArrayList<Double> list2 = new ArrayList<Double>();
		list2.add(11.12);
		list2.add(23.23);

		HashtableImp<String, ArrayList<Double>> hash = new HashtableImp<String, ArrayList<Double>>();
		hash.addElement(key1, list);
		hash.addElement(key2, list2);

		try {

			Assert.assertEquals(hash.getValue(key1), hash.setValueListIndex(key1, 0, 0.4));
			Assert.assertEquals(hash.getValue(key2), hash.setValueListIndex(key2, 1, 1.23));

		} catch (KeyNotFoundException e) {
			Assert.fail(" failed test setValueListIndex() ");
		}

		try {
			hash.removeElementListIndex(key1, 1);
			hash.setValueListIndex(key1, 1, 3.2);
			hash.setValueListIndex(key2, 2, 23);
		} catch (KeyNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(true);
		}

	}

	@Test
	public void addValueTest() throws RemoteException {
		// , KeyNotFoundException, FormatIncrementDecException

		String key1 = "k1";
		String key2 = "k2";

		HashtableImp<String, Integer> hashI = new HashtableImp<String, Integer>();
		hashI.addElement(key1, 1);
		hashI.addElement(key2, 3);

		HashtableImp<String, Double> hashD = new HashtableImp<String, Double>();
		hashD.addElement(key1, 4.321);
		hashD.addElement(key2, 3.21);

		HashtableImp<String, Float> hashF = new HashtableImp<String, Float>();
		hashF.addElement(key1, 3.21f);
		hashF.addElement(key2, 6.03f);

		try {

			hashI.addValue(key1, 3);
			Assert.assertEquals((Object) 4, hashI.getValue(key1));

			hashD.addValue(key1, 3);
			Assert.assertEquals((Object) 7.321, hashD.getValue(key1));

			hashF.addValue(key2, 3);
			Assert.assertEquals((Object) 9.030001f, hashF.getValue(key2));

		} catch (KeyNotFoundException e) {
			Assert.fail(" failed test addValue() ");
		} catch (FormatIncrementDecException e) {
			Assert.fail(" failed test addValue() ");
		}

		try {
			hashF.addValue("none", 5);
		} catch (KeyNotFoundException e) {
			Assert.assertTrue(true);
		} catch (FormatIncrementDecException e) {
			// TODO Auto-generated catch block
			Assert.fail("failed test addValue()");
		}

		try {
			HashtableImp<String, String> hashS = new HashtableImp<String, String>();
			hashS.addElement(key1, "value1");
			hashS.addElement(key2, "value2");
			hashS.addValue(key1, 1);
		} catch (KeyNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.fail("failed test addValue() ");
		} catch (FormatIncrementDecException e) {
			Assert.assertTrue(true);

		}

	}

	@Test
	public void incrementerTest() throws RemoteException, KeyNotFoundException, FormatIncrementDecException {

		// Dans la fct incrementer on utilise la fct addValue(K key, Object val)
		// qui est deja teste
		String key1 = "k1";
		String key2 = "k2";

		HashtableImp<String, Integer> hash = new HashtableImp<String, Integer>();
		hash.addElement(key1, 1);
		hash.addElement(key2, 3);
		hash.incrementer(key1);
		Assert.assertEquals((Object) 2, hash.getValue(key1));
		hash.incrementer(key2);
		Assert.assertEquals((Object) 4, hash.getValue(key2));

	}

	@Test
	public void decrementerTest() throws RemoteException, KeyNotFoundException, FormatIncrementDecException {

		// Dans la fct decrementer on utilise la fct addValue(K key, Object val)
		// qui est deja teste
		String key1 = "k1";
		String key2 = "k2";

		HashtableImp<String, Double> hash = new HashtableImp<String, Double>();
		hash.addElement(key1, 5.03);
		hash.addElement(key2, 7.21);
		hash.decrementer(key1);
		Assert.assertEquals((Object) 4.03, hash.getValue(key1));
		hash.decrementer(key2);
		Assert.assertEquals((Object) 6.21, hash.getValue(key2));

	}

	@Test
	public void addValueInListTest() throws RemoteException {
		// , KeyNotFoundException, FormatIncrementDecException
		String key1 = "k1";
		String key2 = "k2";

		HashtableImp<String, ArrayList<Integer>> hashI = new HashtableImp<String, ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(26);
		list.add(90);
		hashI.addElement(key1, list);

		HashtableImp<String, ArrayList<Double>> hashD = new HashtableImp<String, ArrayList<Double>>();
		ArrayList<Double> listD = new ArrayList<Double>();
		listD.add(1.23);
		listD.add(2.0);
		hashD.addElement(key1, listD);

		HashtableImp<String, ArrayList<Float>> hashF = new HashtableImp<String, ArrayList<Float>>();
		ArrayList<Float> listF = new ArrayList<Float>();
		listF.add(1.23f);
		listF.add(2.0f);
		ArrayList<Float> listF2 = new ArrayList<Float>();
		listF2.add(123.0f);
		listF2.add(2.12f);

		hashF.addElement(key1, listF);
		hashF.addElement(key2, listF2);

		try {

			hashI.addValue(key1, 1, 3);
			Assert.assertEquals((Object) 93, hashI.getValueListIndex(key1, 1));

			hashD.addValue(key1, 0, 10);
			Assert.assertEquals((Object) 11.23, hashD.getValueListIndex(key1, 0));

			hashF.addValue(key2, 0, 3);
			Assert.assertEquals((Object) 126.00000f, hashF.getValueListIndex(key2, 0));

		} catch (KeyNotFoundException e) {
			Assert.fail(" failed test addValue() ");
		} catch (FormatIncrementDecException e) {
			Assert.fail(" failed test addValue() ");
		}

		try {
			hashF.addValue("none", 0, 5);

		} catch (KeyNotFoundException e) {
			Assert.assertTrue(true);
		} catch (FormatIncrementDecException e) {
			// TODO Auto-generated catch block
			Assert.fail("failed test addValue()");
		}

		try {
			hashF.addValue(key1, 5, 5);

		} catch (KeyNotFoundException e) {
			Assert.assertTrue(true);
		} catch (FormatIncrementDecException e) {
			// TODO Auto-generated catch block
			Assert.fail("failed test addValue()");
		}

		try {
			HashtableImp<String, ArrayList<String>> hashS = new HashtableImp<String, ArrayList<String>>();
			ArrayList<String> listS = new ArrayList<String>();
			listS.add("valuer1");
			listS.add("valuer2");
			hashS.addElement(key1, listS);
			hashS.addValue(key1, 0, 1);
		} catch (KeyNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.fail("failed test addValue() ");
		} catch (FormatIncrementDecException e) {
			Assert.assertTrue(true);

		}

	}

	@Test
	public void incrementerInListTest() throws RemoteException, KeyNotFoundException, FormatIncrementDecException {

		// Dans la fct incrementer on utilise la fct addValue(K key, int
		// index,Object val)
		// qui est deja teste
		String key1 = "k1";

		HashtableImp<String, ArrayList<Integer>> hash = new HashtableImp<String, ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(30);
		list.add(40);
		hash.addElement(key1, list);
		hash.incrementer(key1, 0);
		Assert.assertEquals(-1, hash.getValue(key1).indexOf(30));
		Assert.assertEquals(2, hash.getValue(key1).size());
		list.set(0, 31);
		Assert.assertEquals(list.get(0), hash.getValue(key1).get(0));

	}

	@Test
	public void decrementerInListTest() throws RemoteException, KeyNotFoundException, FormatIncrementDecException {

		// Dans la fct incrementer on utilise la fct addValue(K key, int
		// index,Object val)
		// qui est deja teste
		String key1 = "k1";
		HashtableImp<String, ArrayList<Double>> hash = new HashtableImp<String, ArrayList<Double>>();
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(3.231);
		list.add(4.043);
		hash.addElement(key1, list);
		hash.incrementer(key1, 1);
		Assert.assertEquals(-1, hash.getValue(key1).indexOf(4.043));
		Assert.assertEquals(2, hash.getValue(key1).size());
		list.set(1, 5.043);
		Assert.assertEquals(list.get(1), hash.getValue(key1).get(1));

	}

	@Test
	public void containsKeyTest() throws RemoteException {
		String key1 = "k1";
		String key2 = "k2";
		HashtableImp<String, String> hash = new HashtableImp<String, String>();
		hash.addElement(key1, "Rajaa");
		hash.addElement(key2, "Chiraz");

		Assert.assertTrue(hash.containsKey(key1));
		Assert.assertFalse(hash.containsKey("none"));

	}

	@Test
	public void containsValueTest() throws RemoteException {

		String key1 = "k1";
		String key2 = "k2";
		HashtableImp<String, String> hash = new HashtableImp<String, String>();
		hash.addElement(key1, "BARHTAOUI");
		hash.addElement(key2, "LIMAYEM");

		Assert.assertTrue(hash.containsValue("BARHTAOUI"));
		Assert.assertFalse(hash.containsValue("none"));

	}

	@Test
	public void containsValueInListTest() throws RemoteException {
		String key1 = "k1";
		HashtableImp<String, ArrayList<Double>> hash = new HashtableImp<String, ArrayList<Double>>();
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(3.231);
		list.add(4.043);
		hash.addElement(key1, list);
		Assert.assertTrue(hash.containsValueInList(key1, 3.231));
		Assert.assertFalse(hash.containsValueInList("none", 3.231));
		Assert.assertFalse(hash.containsValueInList("none", 6.32));

	}

	@Test
	public void indexValueInListTest() throws RemoteException {
		String key1 = "k1";
		HashtableImp<String, ArrayList<Double>> hash = new HashtableImp<String, ArrayList<Double>>();
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(3.231);
		list.add(4.043);
		hash.addElement(key1, list);
		Assert.assertEquals(0, hash.indexValueInList(key1, 3.231));
		Assert.assertEquals(-1, hash.indexValueInList(key1, 3.31));
		Assert.assertEquals(-1, hash.indexValueInList("none", 3.31));

	}

}
