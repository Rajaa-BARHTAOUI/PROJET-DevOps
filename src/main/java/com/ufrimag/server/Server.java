package com.ufrimag.server;

import java.util.ArrayList;
import java.util.Hashtable;

import com.ufrimag.server.Exception.FormatIncrementDecException;
import com.ufrimag.server.Exception.KeyNotFoundException;

public class Server {

	private static Hashtable<String, Object> hashtable = new Hashtable<String, Object>();

	public static Hashtable<String, Object> getHashtable() {
		// TODO Auto-generated method stub
		return hashtable;
	}
	
	public static Object getValue(String key) throws KeyNotFoundException {
		if (hashtable.get(key)!=null)
		   return hashtable.get(key);
		else {
			throw new KeyNotFoundException("la cle " + key + " n' a pas ete trouve dans le hashtable");
		}	
	}

	public static boolean setKey(String key, int value) {
			hashtable.put(key, value);
			return true;
	}

	@SuppressWarnings("unchecked")
	public static boolean incrementer(String key) throws KeyNotFoundException, FormatIncrementDecException {

		boolean result = false;
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		int index = 0;
		Object element = hashtable.get(key);

		if (element != null) {
			if (element instanceof Integer) {
				Integer res = (Integer) element;
				res++;
				hashtable.put(key, res);
				result = true;
			} else {
				if (element instanceof ArrayList) {
					for (Integer e : (ArrayList<Integer>) element) {
						if (e instanceof Integer) {
							e++;
							resultList.add(index, e);
							index++;
						} else {
							throw new FormatIncrementDecException(
									"le type de l' element dont la cle est" + key + "ne peux pas etre incremente ");
						}
					}
					hashtable.put(key, resultList);
					result = true;
				} else {
					throw new FormatIncrementDecException(
							"le type de l' element dont la cle est" + key + "ne peux pas etre incremente ");
				}
			}

		} else {
			throw new KeyNotFoundException("la cle " + key + " n' a pas ete trouve dans le hashtable");
		}

		return result;

	}

	@SuppressWarnings("unchecked")
	public static boolean decrementer(String key) throws KeyNotFoundException, FormatIncrementDecException {

		boolean result = false;
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		int index = 0;
		Object element = hashtable.get(key);

		if (element != null) {
			if (element instanceof Integer) {
				Integer res = (Integer) element;
				res--;
				hashtable.put(key, res);
				result = true;
			} else {
				if (element instanceof ArrayList) {
					for (Integer e : (ArrayList<Integer>) element) {
						if (e instanceof Integer) {
							e--;
							resultList.add(index, e);
							index++;
						} else {
							throw new FormatIncrementDecException(
									"le type de l' element dont la cle est" + key + "ne peux pas etre decremente ");
						}
					}
					hashtable.put(key, resultList);
					result = true;
				} else {
					throw new FormatIncrementDecException(
							"le type de l' element dont la cle est" + key + "ne peux pas etre decremente ");
				}
			}

		} else {
			throw new KeyNotFoundException("la cle " + key + " n' a pas ete trouve dans le hashtable");
		}

		return result;

	}

	@SuppressWarnings("unchecked")
	public static boolean additionValue(String key, int value)
			throws FormatIncrementDecException, KeyNotFoundException {
		boolean result = false;
		Object element = hashtable.get(key);
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		int index = 0;
		if (element != null) {
			if (element instanceof Integer) {
				Integer res = (Integer) element;
				res = res + value;
				hashtable.put(key, res);
				result = true;
			} else {
				if (element instanceof ArrayList) {
					for (Integer e : (ArrayList<Integer>) element) {
						if (e instanceof Integer) {
							e = e + value;
							resultList.add(index, e);
							index++;
						} else {
							throw new FormatIncrementDecException(
									"le type de l' element dont la cle est" + key + "ne peux pas etre additionne ");
						}
					}
					hashtable.put(key, resultList);
					result = true;
				} else {
					throw new FormatIncrementDecException(
							"le type de l' element dont la cle est" + key + "ne peux pas etre additionne ");
				}
			}

		} else {
			throw new KeyNotFoundException("la cle " + key + " n' a pas ete trouve dans le hashtable");
		}

		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean additionValueToListElement(String key, int index, int value)
			throws FormatIncrementDecException, KeyNotFoundException {
		boolean result = false;
		Object element = hashtable.get(key);
		if (element != null) {
			if (element instanceof ArrayList) {
				if (((ArrayList) element).get(index) != null) {
					Integer addValue = ((ArrayList<Integer>) element).get(index) + value;
					((ArrayList) element).add(index, addValue);
					hashtable.put(key, element);
					result = true;
				}
			} else {
				throw new FormatIncrementDecException(
						"le type de l' element dont la cle est" + key + "ne peux pas etre additionne ");
			}
		}

		else {
			throw new KeyNotFoundException("la cle " + key + " n' a pas ete trouve dans le hashtable");
		}
		return result;
	}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public static boolean addElementList(String key,int value) {
			boolean result=false;
			boolean typeperformed=false;
			Object element = hashtable.get(key);
			if (element != null) {
				if (element instanceof ArrayList) {
					for (Integer e : (ArrayList<Integer>) element) {
						if (e instanceof Integer) {
							typeperformed=true;
						}
					 }
					if (typeperformed==true){
						((ArrayList) element).add(value);
						hashtable.put(key, element);
						result=true;
					}	
				}
				}
			return result;
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public static boolean RemoveElementListIndex(String key, int index)throws FormatIncrementDecException, KeyNotFoundException {
			boolean result = false;
			Object element = hashtable.get(key);
			if (element != null) {
				if (element instanceof ArrayList) {
					if (((ArrayList) element).get(index) != null) {
						((ArrayList<Integer>) element).remove(index);
						hashtable.put(key, element);
						result = true;
					}
				} else {
					throw new FormatIncrementDecException(
							"le type de l' element dont la cle est" + key + "ne peux pas etre supprime ");
				}
			}

			else {
				throw new KeyNotFoundException("la cle " + key + " n' a pas ete trouve dans le hashtable");
			}
			return result;
		}
}

