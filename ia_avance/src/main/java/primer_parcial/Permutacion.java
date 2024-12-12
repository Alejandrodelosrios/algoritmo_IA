/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primer_parcial;

import java.util.LinkedList;

/**
 *
 * @author EQUIPO
 */
public class Permutacion {
    
 // SIN REPETICION:
    
   
    public static void permutacionSR(LinkedList<Integer> l, LinkedList<Integer> l2, int r, int i) {
        if (l2.size() == r) {
            System.out.println(l2);
            return;
        }
        int k = 0;
        while (k < l.size()) {
            if (!l2.contains(l.get(k))) {
                l2.add(l.get(k));
                permutacionCR(l, l2, r, k + 1);
                l2.removeLast();
            }
            k++;
        }
    }
 

    // CON REPETICION:
    
    public static void permutacionCR(LinkedList<Integer> l, LinkedList<Integer> l2, int r, int i) {
        if (l2.size() == r) {
            System.out.println(l2);
            return;
        }
        int k = 0;
        while (k < l.size()) {
            l2.add(l.get(k));
            permutacionCR(l, l2, r, k + 1);
            l2.removeLast();

            k++;
        }
    }

    public static void main(String arg[]){
        
    }
    
}
