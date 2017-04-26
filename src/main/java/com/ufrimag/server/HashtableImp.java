package com.ufrimag.server;

import java.rmi.*;
import java.util.ArrayList;
import java.util.Hashtable;

import com.ufrimag.server.Exception.FormatIncrementDecException;
import com.ufrimag.server.Exception.KeyNotFoundException;

public class HashtableImp<K, V> implements HashtableS<K, V> {

	private ArrayList<K> keyList;
	private ArrayList<V> valueList;
	private Hashtable<K, V> hashtable;

	public HashtableImp() {

		this.keyList = new ArrayList<K>();
		this.valueList = new ArrayList<V>();

	}

	@Override
	public String sayHello() throws RemoteException {
		// TODO Auto-generated method stub
		return "HELLO EVERY BODY .. \n";
	}

	@Override
	public boolean addElement(K key, V value) throws RemoteException {
		// TODO Auto-generated method stub
		return this.keyList.add(key) && this.valueList.add(value);

	}
	
	@Override
	public<E> boolean addElementInList(K key, E value)throws RemoteException,KeyNotFoundException{
		
		int id = this.keyList.indexOf(key);
		if (id == -1)
			throw new KeyNotFoundException("Not found key "+key);
		V list = this.valueList.get(id);
		if (list != null && list instanceof ArrayList<?>){
			((ArrayList<E>) list).add(value);
				return true;
		}
		return false;
		
		
	}

	@Override
	public K removeElement(K key) throws RemoteException {
		// TODO Auto-generated method stub
		int index = this.keyList.indexOf(key);
		
		if (index == -1)
			return null;
		if (this.keyList.remove(index) != null && this.valueList.remove(index) != null)
			return key;
	    return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public int removeElementListIndex(K key, int index) throws RemoteException, KeyNotFoundException {
		// TODO Auto-generated method stub

		int id = this.keyList.indexOf(key);
		if (id == -1)
			return id;
		V list = this.valueList.get(id);
		if (list != null && list instanceof ArrayList<?>) {
			if (((ArrayList<?>) list).size() <= index) {
				return -1;
			} else if (((ArrayList<?>) list).remove(index) != null) {
				return index;
			}

		}
		return -1;

	}

	@Override
	public V getValue(K key) throws RemoteException, KeyNotFoundException {
		// TODO Auto-generated method stub

		int id = this.keyList.indexOf(key);
		if (id == -1)
			throw new KeyNotFoundException("Not found key " + key);
		V value = this.valueList.get(id);
		return value;
		

	}

	@Override
	public V setValue(K key, V value) throws RemoteException, KeyNotFoundException {
		// TODO Auto-generated method stub
		int id = this.keyList.indexOf(key);
		if (id == -1)
			throw new KeyNotFoundException("Not found key " + key);
	    
		if(this.valueList.set(id, value) != null);
	        return value;
	
	}

	@Override
	public Object getValueListIndex(K key, int index) throws RemoteException, KeyNotFoundException {
		// TODO Auto-generated method stub

		int id = this.keyList.indexOf(key);
		if (id == -1)
			throw new KeyNotFoundException("Not found key " + key);

		V list = this.valueList.get(id);
		if (list != null && list instanceof ArrayList<?>) {
			Object element;
			if (((ArrayList<?>) list).size() <= index) {
				throw new KeyNotFoundException("Not found index " + index);
			} else if ((element = ((ArrayList<?>) list).get(index)) != null) {
				return element;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> V setValueListIndex(K key, int index, E value) throws RemoteException, KeyNotFoundException {
		// TODO Auto-generated method stub

		int id = this.keyList.indexOf(key);
		if (id == -1)
			throw new KeyNotFoundException("Not found key " + key);

		V list = this.valueList.get(id);
		if (list != null && list instanceof ArrayList<?>) {
			if (((ArrayList<E>) list).size() <= index) {
				throw new KeyNotFoundException("Not found index " + index);
			} else if (((ArrayList<E>) list).set(index, value) != null) {
				return this.valueList.set(id, (V) list);

			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addValue(K key, Object val) throws RemoteException, KeyNotFoundException, FormatIncrementDecException {
		// TODO Auto-generated method stub

		int id = this.keyList.indexOf(key);
		if (id == -1)
			throw new KeyNotFoundException("Not found key " + key);
		V value = this.valueList.get(id);
		if (value != null) {
			if (value instanceof Integer) {
				// a completer
				int v = Integer.parseInt(val.toString());
				v += Integer.parseInt(value.toString());
				ArrayList<Integer> tmpList = new ArrayList<Integer>();
				tmpList = (ArrayList<Integer>) this.valueList;
				tmpList.set(id, v);
				this.valueList = (ArrayList<V>) tmpList;

			} else if (value instanceof Double) {
				double v = Double.parseDouble(val.toString());
				v += Double.parseDouble(value.toString());
				ArrayList<Double> tmpList = new ArrayList<Double>();
				tmpList = (ArrayList<Double>) this.valueList;
				tmpList.set(id, v);
				this.valueList = (ArrayList<V>) tmpList;

			} else if (value instanceof Float) {
				float v = Float.parseFloat(val.toString());
				v += Float.parseFloat(value.toString());
				ArrayList<Float> tmpList = new ArrayList<Float>();
				tmpList = (ArrayList<Float>) this.valueList;
				tmpList.set(id, v);
				this.valueList = (ArrayList<V>) tmpList;

			} else {
				throw new FormatIncrementDecException(key + " Element non incrementable ");
			}
		} 

	}

	@Override
	public void incrementer(K key) throws RemoteException, KeyNotFoundException, FormatIncrementDecException {
		// TODO Auto-generated method stub
		addValue(key, 1);

	}

	@Override
	public void decrementer(K key) throws RemoteException, KeyNotFoundException, FormatIncrementDecException {
		// TODO Auto-generated method stub
		addValue(key, -1);
	}

	@SuppressWarnings("unchecked")
	public <E> void addValue(K key, int index, E val)
			throws RemoteException, KeyNotFoundException, FormatIncrementDecException {

		int id = this.keyList.indexOf(key);
		if (id == -1)
			throw new KeyNotFoundException("Not found key " + key);
		V list = this.valueList.get(id);

		if (list != null && list instanceof ArrayList<?>) {
			if (((ArrayList<E>) list).size() <= index)
				throw new KeyNotFoundException("Not found index " + index);
			E value = ((ArrayList<E>) list).get(index);
			if (value instanceof Integer) {
				int v = Integer.parseInt(val.toString());
				v += Integer.parseInt(value.toString());
				ArrayList<Integer> tmpList = new ArrayList<Integer>();
				tmpList = (ArrayList<Integer>) list;
				tmpList.set(index, v);
				this.valueList.set(id, (V) tmpList);

			} else if (value instanceof Double) {
				double v = Double.parseDouble(val.toString());
				v += Double.parseDouble(value.toString());
				ArrayList<Double> tmpList = new ArrayList<Double>();
				tmpList = (ArrayList<Double>) list;
				tmpList.set(index, v);
				this.valueList.set(id, (V) tmpList);

			} else if (value instanceof Float) {
				float v = Float.parseFloat(val.toString());
				v += Double.parseDouble(value.toString());
				ArrayList<Float> tmpList = new ArrayList<Float>();
				tmpList = (ArrayList<Float>) list;
				tmpList.set(index, v);
				this.valueList.set(id, (V) tmpList);

			} else {
				throw new FormatIncrementDecException(key + " Element non incrementable ");
			}
		} else {
			throw new KeyNotFoundException("Key " + key + " not found");
		}

	}
	
	@Override
	public void incrementer(K key, int index)
			throws RemoteException, KeyNotFoundException, FormatIncrementDecException {

		addValue(key, index, 1);

	}

	@Override
	public void decrementer(K key, int index)
			throws RemoteException, KeyNotFoundException, FormatIncrementDecException {
		// TODO Auto-generated method stub
		addValue(key, index, -1);
	}

	@Override
	public boolean containsKey(K key) throws RemoteException {
		// TODO Auto-generated method stub
		return this.keyList.contains(key);

	}

	@Override
	public boolean containsValue(V value) throws RemoteException {
		// TODO Auto-generated method stub
		return this.valueList.contains(value);

	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> boolean containsValueInList(K key, E value) throws RemoteException {
		// TODO Auto-generated method stub
		if (containsKey(key)) {
			int id = this.keyList.indexOf(key);
			V list = this.valueList.get(id);
			if (list instanceof ArrayList<?>) {
				return ((ArrayList<E>) list).contains(value);
			}
		}
		return false;

	}

	@SuppressWarnings("unchecked")
	@Override
	public<E> int indexValueInList(K key,E value) throws RemoteException{
		// TODO Auto-generated method stub
		if(containsKey(key)){
		 int id=this.keyList.indexOf(key);
		 V list=this.valueList.get(id);
	    	if(list instanceof ArrayList<?>){
		      return ((ArrayList<E>) list).indexOf(value);
		   }
		}	
		return -1;
		
	}
	

}
