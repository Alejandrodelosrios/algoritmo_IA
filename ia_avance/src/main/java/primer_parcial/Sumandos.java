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
public class Sumandos {

public static int suma(LinkedList<Integer> l) {
        int res = 0;
        for (int i = 0; i < l.size(); i++) {
            res += l.get(i);
        }
        return res;
    }
    
    public static void sumandos(LinkedList<Integer> l, int n, int i) {
        int s = suma(l);
        if (s > n) {
            return;
        }
        if (s == n) {
            System.out.println(l);
            return;
        }
        int k = i;
        while (k <= n) {
            l.add(k);
            sumandos(l, n, k);
            l.removeLast();
            k++;
        }
    }        
    
  //---------------- INICIO PROBLEMA DE LOS FACTORES -----------------------
    
    public static int producto(LinkedList<Integer> l) {
        int res = 1;
        for (int i = 0; i < l.size(); i++) {
            res *= l.get(i);
        }
        return res;
    }

    public static void factores(LinkedList<Integer> l, int n, int i) {
        int s = producto(l);
        if (s > n || l.size() > n) {
            return;
        }
        if (s == n) {
            System.out.println(l);
            return;
        }
        int k = i;
        while (k <= n) {
            l.add(k);
            factores(l, n, k);
            l.removeLast();
            k++;
        }
    }
  
 
 public static void main(String[] arg ){
  LinkedList<Integer> lista=new LinkedList<>();
  sumandos(lista,5,1);
  factores(lista,5,1);
 }   
    
}
