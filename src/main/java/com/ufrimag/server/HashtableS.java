package com.ufrimag.server;

import java.rmi.*;
import java.util.Hashtable;

import com.ufrimag.server.Exception.FormatIncrementDecException;
import com.ufrimag.server.Exception.KeyNotFoundException;

public interface HashtableS<K,V> extends Remote {
	
	public String sayHello() throws RemoteException;
	
	public V getValue(K key) 
			throws RemoteException,KeyNotFoundException;
	
	public V setValue(K key, V value)
			throws RemoteException,KeyNotFoundException;
	
	public Object getValueListIndex(K key,int index) 
			throws RemoteException,KeyNotFoundException;
	
	public<E> V setValueListIndex(K key, int index,E value)throws RemoteException,KeyNotFoundException;
	
	public boolean containsValue(V value) throws RemoteException;
	
	public boolean containsKey(K key) throws RemoteException;
	
	public<E> boolean containsValueInList(K key,E value) throws RemoteException;
	
	public<E> int indexValueInList(K key,E value) throws RemoteException;
	
	public void addValue(K key,Object val) 
			throws RemoteException, KeyNotFoundException, FormatIncrementDecException;
	
	public void incrementer(K key) throws RemoteException,KeyNotFoundException, 
	  FormatIncrementDecException;
	
	public<E> void addValue(K key,int index,E val) throws RemoteException,KeyNotFoundException, 
	  FormatIncrementDecException;
	
	public void incrementer(K key,int index) throws RemoteException,KeyNotFoundException, 
	  FormatIncrementDecException;
	
	public void decrementer(K key) throws RemoteException,KeyNotFoundException,
	  FormatIncrementDecException;
	
	public void decrementer(K key,int index) throws RemoteException,KeyNotFoundException,
	  FormatIncrementDecException;
	
	public boolean addElement(K key, V value)throws RemoteException;
	
	public<E> boolean addElementInList(K key, E value)throws RemoteException,KeyNotFoundException;
	
	public K removeElement(K key)throws RemoteException;
	
	public int removeElementListIndex(K key, int index)
			throws RemoteException, KeyNotFoundException;
	
	
}