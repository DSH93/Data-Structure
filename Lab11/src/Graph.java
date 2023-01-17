import java.util.TreeMap;
import java.util.LinkedList;

public class Graph<V extends Comparable<V>, E> implements IGraph<V, E> {
    private final TreeMap<V, LinkedList<Edge<V>>> unDirectedGraph;


    public Graph() {
        this.unDirectedGraph = new TreeMap<>();
    }

    @Override
    public void add(V v) {
        if (unDirectedGraph.containsKey(v)) return;
        unDirectedGraph.put(v, new LinkedList<>());
    }


    @Override
    public E getEdge(V u, V v) {
        if (!unDirectedGraph.containsKey(u)) return null;
        if (!unDirectedGraph.get(u).contains(v)) return null;
        LinkedList<Edge<V>> edgeLinkedList = unDirectedGraph.get(u);
        int size = unDirectedGraph.get(u).size();
        int i = 0;

        for (; i < size; i++) {
            if (edgeLinkedList.get(i).isContain(v)) {
                return (E) unDirectedGraph.get(u).get(i);
            }
        }
        return null;
    }


    @Override
    public E putEdge(V u, V v, E edgeLabel) {
        add(v);
        add(u);
        removeEdge(u, v);
        removeEdge(v, u);
        var vEdge1 = new Edge<>(u, v, edgeLabel);
        var vEdge2 = new Edge<>(v, u, edgeLabel);
        unDirectedGraph.get(u).add(vEdge1);
        unDirectedGraph.get(v).add(vEdge2);
        return edgeLabel;

    }

    @Override
    public boolean containsVertex(V v) {
        return unDirectedGraph.containsKey(v);
    }

    @Override
    public void removeVertex(V v) {
        unDirectedGraph.remove(v, unDirectedGraph.get(v));
    }

    @Override
    public E removeEdge(V u, V v) {
        int size = unDirectedGraph.get(v).size();
        for (int i = 0; i < size; i++) {
            Edge<V> edge = unDirectedGraph.get(v).get(i);
            int sizeDest = unDirectedGraph.get(edge.dist).size();
            for (int j = 0 ; j < sizeDest ; j++){
                unDirectedGraph.get(edge.dist).get(j) ==
            }
        }
    }

    @Override
    public double getWeight(V u, V v) {
        return 0;
    }

    @Override
    public String toStringExtended() {
        return null;
    }

    @Override
    public boolean areAdjacent(V u, V v) {
        return false;
    }


    private class Edge<V> {
        public static final double DEF_WEIGHT = 1;
        private final double weight;
        private final V dist;
        private final V source;
        private final E lable;

        public Edge(V source, V dist, double weight, E lable) {
            this.weight = weight;
            this.dist = dist;
            this.source = source;
            this.lable = lable;
        }

        public Edge(V source, V dist, E lable) {
            this(source, dist, DEF_WEIGHT, lable);
        }

        public boolean isContain(V v) {
            return (v == dist);

        }
        public V getDestEdge(){
            return this.dist;
        }

        public V getSourceEdge(){
            return this.source;
        }


    }


}
