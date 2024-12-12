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
public class Mochila {
 
public static int suma(LinkedList<Integer> l) {
        int res = 0;
        for (int i = 0; i < l.size(); i++) {
            res += l.get(i);
        }
        return res;
}    
    
public static void mochila(LinkedList<Integer> l, LinkedList<Integer> l2, int CapMax, int i) {
        int s = suma(l2);
        if (s > CapMax) {
            return;
        }
        System.out.println(l2);
        int k = i;
        while (k < l.size()) {
            l2.add(l.get(k));
            mochila(l, l2, CapMax, k + 1);
            l2.removeLast();
            k++;
        }
    }

public static void main(String arg[]){
 LinkedList<Integer> lista1=new LinkedList<>();
 lista1.add(5);
 lista1.add(7);
 lista1.add(4);
 LinkedList<Integer> lista2=new LinkedList<>();
 
 mochila(lista1,lista2,10,0);
}
}
