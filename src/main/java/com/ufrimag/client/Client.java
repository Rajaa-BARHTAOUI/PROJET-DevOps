package com.ufrimag.client;

import com.ufrimag.server.HashtableS;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class Client {
	public static void main(String[] args) {

		try {
			if (args.length < 1) {
				System.out.println("Usage: java Client <rmiregistry host>");
				return;
			}

			String host = args[0];

			// Get remote object reference
			Registry registry = LocateRegistry.getRegistry(host);
			HashtableS hS = (HashtableS) registry.lookup("HashtableWithListOfString");
			HashtableS hI = (HashtableS) registry.lookup("HashtableWithListOfInteger");
			HashtableS hF = (HashtableS) registry.lookup("HashtableWithListOfFloat");
			HashtableS hD = (HashtableS) registry.lookup("HashtableWithListOfDouble");

			// Remote method invocation
			String res = hS.sayHello();
			System.out.println(res);

			ArrayList<String> listS1 = new ArrayList<String>();
			listS1.add("Rajaa");
			listS1.add("BARHTAOUI");

			ArrayList<String> listS2 = new ArrayList<String>();
			listS2.add("Chiraz");
			listS2.add("LIMAYEM");

			hS.addElement("key1", listS1);
			hS.addElement("key2", listS2);
			
			System.out.println("*** Hashtable With List Of String ***\n");
			ArrayList<String> lS = (ArrayList<String>) hS.getValue("key1");
			System.out.print("key1: ");
			for (int i = 0; i < lS.size(); i++) {
				System.out.print(lS.get(i)+" ");
			}
			System.out.print("/");
			lS = (ArrayList<String>) hS.getValue("key2");
			System.out.print("key2: ");
			for (int i = 0; i < lS.size(); i++) {
				System.out.print(lS.get(i)+" ");
			}
            System.out.println();
			System.out.println("key1 0: " + hS.getValueListIndex("key1", 0));
			System.out.println("key2 Chiraz: " + hS.indexValueInList("key2", "Chiraz"));
			hS.setValueListIndex("key1", 0, "BARHTAOUI");
			System.out.println("Après modification key1 0: " + hS.getValueListIndex("key1", 0));
			hS.addElementInList("key2", "DevOps");
			System.out.println("Après Ajout du -DevOps-  à la liste 2 \n key2 2: " + hS.getValueListIndex("key2", 2));

			ArrayList<Integer> listI1 = new ArrayList<Integer>();
			listI1.add(20);
			listI1.add(12);
			listI1.add(1990);

			ArrayList<Integer> listI2 = new ArrayList<Integer>();
			listI2.add(10);
			listI2.add(2006);

			hI.addElement("key1", listI1);
			hI.addElement("key2", listI2);

			System.out.println("\n*** Hashtable With List Of Integer ***\n");
			ArrayList<Integer> lI = (ArrayList<Integer>) hI.getValue("key1");
			System.out.print("key1: ");
			for (int i = 0; i < lI.size(); i++) {
				System.out.print(lI.get(i)+" ");
			}
			System.out.print("/");
			lI = (ArrayList<Integer>) hI.getValue("key2");
			System.out.print("key2: ");
			for (int i = 0; i < lI.size(); i++) {
				System.out.print(lI.get(i)+" ");
			}
            System.out.println();
			System.out.println("key1 0: " + hI.getValueListIndex("key1", 0));
			hI.incrementer("key1", 0);
			System.out.println("Incrementer key1 0: " + hI.getValueListIndex("key1", 0));
			hI.decrementer("key1", 0);
			System.out.println("Decrementer key1 0: " + hI.getValueListIndex("key1", 0));

			ArrayList<Double> listD1 = new ArrayList<Double>();
			listD1.add(2.0);
			listD1.add(1.2);
			listD1.add(19.90);

			ArrayList<Double> listD2 = new ArrayList<Double>();
			listD2.add(1.0);
			listD2.add(20.06);

			hD.addElement("key1", listD1);
			hD.addElement("key2", listD2);

			System.out.println("\n*** Hashtable With List Of Double ***\n");
			ArrayList<Double> lD = (ArrayList<Double>) hD.getValue("key1");
			System.out.print("key1: ");
			for (int i = 0; i < lD.size(); i++) {
				System.out.print(lD.get(i)+" ");
			}
			System.out.print("/");
			lD = (ArrayList<Double>) hD.getValue("key2");
			System.out.print("key2: ");
			for (int i = 0; i < lD.size(); i++) {
				System.out.print(lD.get(i)+" ");
			}
            System.out.println();
			System.out.println("key2 1: " + hD.getValueListIndex("key2", 1));
			hD.addValue("key2", 1, 4.4);
			System.out.println("Ajout 4.4 à key2 1: " + hD.getValueListIndex("key2", 1));
			hD.addValue("key2", 1, -3.2);
			System.out.println("Ajout -3.2 à key2 1: " + hD.getValueListIndex("key2", 1));
			System.out.println("size key2: " + ((ArrayList<Double>) hD.getValue("key2")).size());
			
			hD.removeElementListIndex("key2", 1);
			System.out.println("Supprimer element de key2 "+((ArrayList<Double>) hD.getValue("key2")).size());
			
			lD = (ArrayList<Double>) hD.getValue("key2");
			System.out.print("key2: ");
			for (int i = 0; i < lD.size(); i++) {
				System.out.print(lD.get(i)+" ");
			}
            System.out.println();
			ArrayList<Float> listF1 = new ArrayList<Float>();
			listF1.add(2.043f);
			listF1.add(1.432f);
			listF1.add(19.950f);

			ArrayList<Float> listF2 = new ArrayList<Float>();
			listF2.add(154.0f);
			listF2.add(240.0654f);

			hF.addElement("key1", listF1);
			hF.addElement("key2", listF2);

			System.out.println("\n*** Hashtable With List Of Float ***\n");
			ArrayList<Float> lF = (ArrayList<Float>) hF.getValue("key1");
			System.out.print("key1: ");
			for (int i = 0; i < lF.size(); i++) {
				System.out.print(lF.get(i)+" ");
			}
			System.out.print("/");
			lF = (ArrayList<Float>) hF.getValue("key2");
			System.out.print("key2: ");
			for (int i = 0; i < lF.size(); i++) {
				System.out.print(lF.get(i)+" ");
			}
			System.out.println();
			System.out.println("key1 0: " + hF.getValueListIndex("key1", 0));
			System.out.println("hashtable contains key1? " + hF.containsKey("key1"));
			System.out.println("hashtable contains key3? " + hF.containsKey("key3"));
			System.out.println("key1 contains 2.043? " + hF.containsValueInList("key1",2.043f));
			System.out.println("key2 contains 3.2? " + hF.containsValueInList("key2", 3.2f));

		} catch (Exception e) {
			System.err.println("Error on client: " + e);
		}
	}
}