import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;  
import java.rmi.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;
 

public class Client {  
   private Client() {}  
   public static void main(String[] args) {  
      try {  
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry(null);

    
         // Looking up the registry for the remote object 
         MinSpanTree stub = (MinSpanTree) Naming.lookup("rmi://" + args[0] + ":" + args[1] + "/min_span_tree"); 
         
         String input = null;

         BufferedReader readCommand = new BufferedReader(new InputStreamReader(System.in));

         while(true){
            input = readCommand.readLine();
            if(input == null) break;
            StringTokenizer spaceSep = new StringTokenizer(input);

            String function = spaceSep.nextToken();

            if(function.equals("add_graph")){
               
               String graphName = spaceSep.nextToken();
               Integer nodeNum = Integer.parseInt(spaceSep.nextToken());

               stub.add_graph(graphName, nodeNum);

            }
            else if(function.equals("add_edge")){
               
               String graphName = spaceSep.nextToken();
               Integer src = Integer.parseInt(spaceSep.nextToken());
               Integer dest = Integer.parseInt(spaceSep.nextToken());
               Integer wt = Integer.parseInt(spaceSep.nextToken());

               stub.add_edge(graphName, src, dest, wt);
            }
            else if(function.equals("get_mst")){
               
               String graphName = spaceSep.nextToken();
               System.out.println(stub.get_mst(graphName));
            }
            else{
               System.out.println("Invalid function");
               continue;
            }

         }

         // System.out.println("Remote method invoked"); 
      } catch (Exception e) {
         e.printStackTrace(); 
      } 
   } 
}