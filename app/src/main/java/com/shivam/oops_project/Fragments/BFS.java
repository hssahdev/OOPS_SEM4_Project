package com.shivam.oops_project.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.shivam.oops_project.R;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFS extends android.app.Fragment {

    String result="";
    String edge="";

    public BFS() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_bf, container, false);

        Button dfssizebtn = rootview.findViewById(R.id.dfssizebtn);
        Button dfsedgebtn = rootview.findViewById(R.id.dfsedgebtn);
        Button dfsshowbtn = rootview.findViewById(R.id.dfshowbtn);

        final EditText dfssize = rootview.findViewById(R.id.dfssize);
        final EditText dfsedgev1 = rootview.findViewById(R.id.dfsedgev1);
        final EditText dfsedgev2 = rootview.findViewById(R.id.dfsedgev2);
        final EditText dfstartingvertex = rootview.findViewById(R.id.bfsstartingvertex);

        final TextView dfsshow = rootview.findViewById(R.id.dfshowtext);
        final TextView dfsedgeshow = rootview.findViewById(R.id.dfshowtext);

        final BFS.Graph[] g = new BFS.Graph[1];

        dfssizebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String size = dfssize.getText().toString();
                g[0] = new BFS.Graph(Integer.valueOf(size));
            }
        });


        dfsedgebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int v1=Integer.valueOf(dfsedgev1.getText().toString());
                int v2=Integer.valueOf(dfsedgev2.getText().toString());
                edge+="Edge exits between "+v1+"and"+v2+"/n";
                g[0].addEdge(v1,v2 );
                dfsedgeshow.setText(edge);

            }
        });


        dfsshowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g[0].BFS(Integer.valueOf(dfstartingvertex.getText().toString()));
                dfsshow.setText(result);
            }
        });


        return rootview;
    }







   public class Graph {
       private int V;   // No. of vertices
       private LinkedList<Integer> adj[]; //Adjacency Lists

       // Constructor
       Graph(int v) {
           V = v;
           adj = new LinkedList[v];
           for (int i = 0; i < v; ++i)
               adj[i] = new LinkedList();
       }

       // Function to add an edge into the graph
       void addEdge(int v, int w) {
           adj[v].add(w);
       }

       // prints BFS traversal from a given source s
       void BFS(int s) {
           // Mark all the vertices as not visited(By default
           // set as false)
           boolean visited[] = new boolean[V];

           // Create a queue for BFS
           LinkedList<Integer> queue = new LinkedList<Integer>();

           // Mark the current node as visited and enqueue it
           visited[s] = true;
           queue.add(s);

           while (queue.size() != 0) {
               // Dequeue a vertex from queue and print it
               s = queue.poll();
               result+=s+"-->";

               // Get all adjacent vertices of the dequeued vertex s
               // If a adjacent has not been visited, then mark it
               // visited and enqueue it
               Iterator<Integer> i = adj[s].listIterator();
               while (i.hasNext()) {
                   int n = i.next();
                   if (!visited[n]) {
                       visited[n] = true;
                       queue.add(n);
                   }
               }
           }
       }
   }

    }
