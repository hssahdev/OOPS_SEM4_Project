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
public class DFS extends android.app.Fragment{

    String result="";
    String edge="";

    public DFS() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_df, container, false);

        Button dfssizebtn = rootview.findViewById(R.id.dfssizebtn);
        Button dfsedgebtn = rootview.findViewById(R.id.dfsedgebtn);
        Button dfsshowbtn = rootview.findViewById(R.id.dfshowbtn);

        final EditText dfssize = rootview.findViewById(R.id.dfssize);
        final EditText dfsedgev1 = rootview.findViewById(R.id.dfsedgev1);
        final EditText dfsedgev2 = rootview.findViewById(R.id.dfsedgev2);
        final EditText dfstartingvertex = rootview.findViewById(R.id.dfsstartingvertex);

        final TextView dfsshow = rootview.findViewById(R.id.dfshowtext);
        final TextView dfsedgeshow = rootview.findViewById(R.id.dfshowtext);

        final Graph[] g = new Graph[1];

        dfssizebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String size = dfssize.getText().toString();
                g[0] = new Graph(Integer.valueOf(size));
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
                g[0].DFS(Integer.valueOf(dfstartingvertex.getText().toString()));
                dfsshow.setText(result);
            }
        });


        return rootview;
    }


    public class Graph {
        int V;   // No. of vertices

        // Array  of lists for Adjacency List Representation
        LinkedList<Integer> adj[];

        // Constructor
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        //Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);  // Add w to v's list.
        }

        // A function used by DFS
        void DFSUtil(int v, boolean visited[]) {
            // Mark the current node as visited and print it
            visited[v] = true;
            result+=v+"-->";



            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited);
            }
        }

        // The function to do DFS traversal. It uses recursive DFSUtil()
        void DFS(int v) {
            // Mark all the vertices as not visited(set as
            // false by default in java)
            boolean visited[] = new boolean[V];

            // Call the recursive helper function to print DFS traversal
            DFSUtil(v, visited);
        }

    }
}
