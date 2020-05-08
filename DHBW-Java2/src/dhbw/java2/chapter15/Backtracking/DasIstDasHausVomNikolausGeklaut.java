package dhbw.java2.chapter15.Backtracking;
/**
 * @author ElPapito
 * @date 07.05.2015
 */
 
import java.util.ArrayList;
 
public class DasIstDasHausVomNikolausGeklaut {
 
    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(1, 2));
        edges.add(new Edge(1, 3));
        edges.add(new Edge(1, 4));
        edges.add(new Edge(2, 3));
        edges.add(new Edge(2, 4));
        edges.add(new Edge(3, 4));
        edges.add(new Edge(3, 5));
        edges.add(new Edge(4, 5));
 
        for (int i = 1; i <= 5; i++) {
            printSolutions(edges, i, "");
        }
    }
 
    private static void printSolutions(ArrayList<Edge> edges, int node,
            String path) {
        if (edges.isEmpty()) {
            System.out.println(path + node);
            return;
        }
 
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if (edge.contains(node)) {
                int newNode = edge.getOther(node);
                edges.remove(edge);
                printSolutions(edges, newNode, path + node + "-");
                edges.add(i, edge);
            }
        }
    }
 
}
 
class Edge {
    private int point1;
    private int point2;
 
    public Edge(int p1, int p2) {
        point1 = p1;
        point2 = p2;
    }
 
    public boolean contains(int node) {
        return point1 == node || point2 == node;
    }
 
    public int getOther(int node) {
        if (point1 == node) {
            return point2;
        } else if (point2 == node) {
            return point1;
        } else {
            return -1;
        }
    }
 
}