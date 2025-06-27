package aud.graph;
import java.util.*;

public class AdjMatrix {

    // Bestimme den Eingangsgrad eines Knotens k
    public static int inDegree(int k, int[][] m) {
        // TODO: Implementieren
        int count = 0;
        for(int i = 0; i < m.length; i++){
            if(m[i][k] == 1) count++;
        }
        return count;
    }

    // Bestimme den Ausgangsgrad eines Knotens k
    public static int outDegree(int k, int[][] m) {
        // TODO: Implementieren
        int count =0;
        for(int i=0; i<m[k].length; i++){
            if(m[k][i] == 1) count++;
        }
        return 0;
    }

    // Gib alle direkt erreichbaren Nachbarn des Knotens k zurück
    public static List<Integer> adjacent(int k, int[][] m) {
        // TODO: Implementieren
        List<Integer> result = new ArrayList<>();
        for(int i =0; i < m[k].length; i++){
            if(m[k][i] == 1) result.add(i);
        }
        return result;
    }

    //i → j → k → i
    //also: if (m[i][j] == 1 && m[j][k] == 1 && m[k][i] == 1)
    //lol O(n**3)
    public static boolean hasTriangle(int[][] m){
        int n = m.length;
        for(int i =0; i< n; i++){
            for(int j = 0; j < n; j++){
                if(m[i][j]==0)continue;
                for(int k = 0; k < n; k++){
                    if(m[j][k]==0)continue;
                    if(m[k][i]==1) return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] A = {
                {0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0}
        };

        System.out.println("inDegree(3): " + inDegree(3, A)); // 2
        System.out.println("outDegree(0): " + outDegree(0, A)); // 2
        System.out.println("adjacent(0): " + adjacent(0, A)); // [1, 4]

        System.out.println("Has triangle? " + hasTriangle(A)); // true
    }
}