package com.ufrimag.server;
import java.rmi.server.*;
import java.util.ArrayList;
import java.rmi.registry.*;

public class ServerRMI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("SERVEUR");
		  try {
			  
				 
			// Create a hashtable remote object
			HashtableImp<String,ArrayList<String>> hashS = new HashtableImp<String,ArrayList<String>>();
			HashtableS hS_stub = (HashtableS) UnicastRemoteObject.exportObject(hashS, 0);  
		    
			HashtableImp<String,ArrayList<Integer>> hashI= new HashtableImp<String,ArrayList<Integer>>();
		    HashtableS hI_stub = (HashtableS) UnicastRemoteObject.exportObject(hashI, 0);
            
		    HashtableImp<String,ArrayList<Double>> hashD = new HashtableImp<String,ArrayList<Double>>();
		    HashtableS hD_stub = (HashtableS) UnicastRemoteObject.exportObject(hashD, 0);
		    
		    HashtableImp<String,ArrayList<Float>> hashF = new HashtableImp<String,ArrayList<Float>>();
		    HashtableS hF_stub = (HashtableS) UnicastRemoteObject.exportObject(hashF, 0);
		    
		    
		    // Register the remote object in RMI registry with a given identifier
		    Registry registryS= LocateRegistry.getRegistry(); 
		    registryS.rebind("HashtableWithListOfString", hS_stub);
		    
		    Registry registryI= LocateRegistry.getRegistry(); 
		    registryI.rebind("HashtableWithListOfInteger", hI_stub);
		    
		    Registry registryD= LocateRegistry.getRegistry(); 
		    registryD.rebind("HashtableWithListOfDouble", hD_stub);
		    
		    Registry registryF= LocateRegistry.getRegistry(); 
		    registryF.rebind("HashtableWithListOfFloat", hF_stub);
		    
		    System.out.println ("Server ready");

		  } catch (Exception e) {
			  System.err.println("Error on server :" + e) ;
			  e.printStackTrace();
		  }

	}

}
