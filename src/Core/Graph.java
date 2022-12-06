/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Muhammad Adil FAYYAZ
 */
public class Graph<V> implements IGraph<V> {
    private List<V> vertices;
    private Map<V, List<V>> adjacencies;
    private boolean isDirected;
    
    public Graph()
    {
        this.vertices = new ArrayList();
        this.adjacencies = new HashMap();
        this.isDirected = false;        
    }
    
    public Graph(boolean _isDirected)
    {
        this.vertices = new ArrayList();
        this.adjacencies = new HashMap();
        this.isDirected = _isDirected;
    }

    @Override
    public int addVertex(V v) {
        this.vertices.add(v);
        this.adjacencies.put(v, new ArrayList());
        return this.vertices.size()-1;
    }

    @Override
    public void removeVertex(V v) {  
        if (!this.isDirected)
        {
            for(V v2: this.vertices)
            {
                if (isAdjacent(v2,v))
                    this.adjacencies.get(v2).remove(v);
            }
        }
        this.vertices.remove(v);
        this.adjacencies.remove(v);
    }

    @Override
    public boolean isAdjacent(V v1, V v2) {
        return this.adjacencies.get(v2).contains(v1);
    }

    @Override
     public void addEdge(V v1, V v2){
        if(!this.adjacencies.get(v1).contains(v2)){
             this.adjacencies.get(v1).add(v2);
        }
        if (this.isDirected==false){
            if(!this.adjacencies.get(v2).contains(v1)){
            this.adjacencies.get(v2).add(v1);
            }
        }
    }

    @Override
    public void addEdge(int i1, int i2) {
        this.adjacencies.get(this.vertices.get(i1)).add(this.vertices.get(i2));
        if (this.isDirected==false)
            this.adjacencies.get(this.vertices.get(i2)).add(this.vertices.get(i1));
          
        
    }

    @Override
    public boolean isAdjacent(int i1, int i2) {
        return this.adjacencies.get(this.vertices.get(i2)).contains(this.vertices.get(i1));
    }

    @Override
    public void removeEdge(V v1, V v2) {
        this.adjacencies.get(v1).remove(v2);
        if (!this.isDirected)
            this.adjacencies.get(v2).remove(v1);
    }

    @Override
    public void removeEdge(int i1, int i2) {
        this.adjacencies.get(this.vertices.get(i1)).remove(this.vertices.get(i2));
        if (!this.isDirected)
            this.adjacencies.get(this.vertices.get(i2)).remove(this.vertices.get(i1));
    }

    @Override
    public List<V> getVertices() {
        return this.vertices;
    }

    @Override
    public List<V> neighborsOf(V v) {
        return this.adjacencies.get(v);
    }

    @Override
    public String toString()
    {
        String msg="";
        for(V v: this.vertices)
        {
            msg+="Vertex: "+v+"\n";
            msg+="Edges:";
            for(V v2: this.adjacencies.get(v))
            {
                msg+=" "+v2;
            }
            msg+="\n";
        }
        return msg;
    }
   
    
    public int degree(V v)
    {
        return this.neighborsOf(v).size();
    }
    
    public List<Integer> degreeDistribution()
    {
        ArrayList<Integer> d_dist = new ArrayList();
        for(int i=0; i<this.vertices.size(); i++)
        {
            d_dist.add(0);
        }
        
        for(V v: this.vertices)
        {
            int deg = this.degree(v);
            d_dist.set(deg, d_dist.get(deg)+1);
        }
                
        return d_dist;
    }
    
    
   
    
    public int pathLength(V a, V b)
    {
        HashMap<V, Integer> distances = new HashMap();
        ArrayList<V> non_visited = new ArrayList();
        for(V v: this.vertices)
        {
            if (v==a)
                distances.put(v, 0);
            else
                distances.put(v, Integer.MAX_VALUE);
            non_visited.add(v);
        }
        
        V current = null;
        
        while(current != b)
        {
            int min_dist = Integer.MAX_VALUE;
            for (V v: non_visited)
            {
                if (distances.get(v)<min_dist)
                {
                    current = v;
                    min_dist = distances.get(v);
                }
            }
            ArrayList<V> neighbors = new ArrayList(this.neighborsOf(current));
            for (V v: neighbors)
            {
                if (distances.get(v)> distances.get(current)+1)
                    distances.put(v, distances.get(current)+1);
            }
            non_visited.remove(current);
        }
        
        return distances.get(b);
        
    }
    
    public int averagePathLength()
    {
        int path_length = 0;
        for(int i = 0; i<this.vertices.size()-1; i++)
        {
            for(int j = i+1; j<this.vertices.size(); j++)
            {
                path_length+=this.pathLength(this.vertices.get(i), this.vertices.get(j));
            }
        }
        
        int nbpath = (this.vertices.size()*(this.vertices.size()-1))/2;
        return path_length/nbpath;
    }
    
}
