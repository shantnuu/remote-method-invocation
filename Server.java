import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.*;

public class Server extends QueryMinSpanTree { 
   public Server() {} 
   public static void main(String args[]) { 
      try { 
         // Instantiating the implementation class 
         QueryMinSpanTree obj = new QueryMinSpanTree(); 
    
         // Exporting the object of implementation class  
         // (here we are exporting the remote object to the stub) 
         MinSpanTree stub = (MinSpanTree) UnicastRemoteObject.exportObject(obj, 0);  
         
         // Binding the remote object (stub) in the registry 
         Registry registry = LocateRegistry.createRegistry(Integer.parseInt(args[0])); 
         
         Naming.rebind("rmi://0.0.0.0:" + args[0] + "/min_span_tree", stub);  
         System.err.println("Server ready"); 
      } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
} 