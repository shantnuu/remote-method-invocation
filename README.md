# Architecture
The java application uses RMI to invoke methods on an object running in another JVM.
The whole project comprises of 4 files:-
- Server
- Client
- MST Implementation and 
- An MST interface file.

# MST Algorithm
Here, we are using krushkal algorithm(using Disjoint Set Union) to find the MST of a given graph.
We calculate MST on the fly whenever a client sends a request for MST
# Results and Observations
The server can handle request from multiple client. Any client can work with any graph.

# How To Run
- javac *.java (on server side)
- java Server 9999 (on server side)
- java Client localhost 9999 (on client side)
