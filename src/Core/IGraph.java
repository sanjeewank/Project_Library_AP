/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.List;

/**
 *
 * @author Muhammad Adil FAYYAZ
 */
interface IGraph<V> {
  public abstract int addVertex(V v);
  public abstract void removeVertex(V v);
  public abstract void addEdge(V v1, V v2);
  public abstract void addEdge(int i1, int i2);
  public abstract void removeEdge(V v1, V v2);
  public abstract void removeEdge(int i1, int i2);
  public abstract boolean isAdjacent(V v1, V v2);
  public abstract boolean isAdjacent(int i1, int i2);
  public abstract List<V> getVertices();
  public abstract List<V> neighborsOf(V v);

}
