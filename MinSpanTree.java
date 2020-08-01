import java.rmi.Remote; 
import java.rmi.RemoteException;  

// Creating Remote interface for our application 
public interface MinSpanTree extends Remote {
    public void add_graph(String s, Integer n) throws RemoteException;
    public void add_edge(String s, Integer source, Integer destination, Integer weight)throws RemoteException;
    public int get_mst(String s)throws RemoteException;
} 