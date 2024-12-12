/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tercer_parcial;

import java.util.LinkedList;

/**
 *
 * @author EQUIPO
 */
public class BackTrack_Rey {
public static int vueltas;

public static class Regla {

    public int fil;
    public int col;

    public Regla(int fil, int col) {
        this.fil = fil;
        this.col = col;
    }
 }

    public static boolean posValida(int m[][], int i, int j) {
        return (i >= 0 && i < m.length) && (j >= 0 && j < m[i].length) && m[i][j] == 0;
    }


    public static LinkedList<Regla> reglasAplicablesRey(int m[][], int i, int j) {
        LinkedList<Regla> L1 = new LinkedList();
        if (posValida(m, i, j - 1)) {
            L1.add(new Regla(i, j - 1));
        }
        if (posValida(m, i - 1, j)) {
            L1.add(new Regla(i - 1, j));
        }
        if (posValida(m, i, j + 1)) {
            L1.add(new Regla(i, j + 1));
        }
        if (posValida(m, i + 1, j)) {
            L1.add(new Regla(i + 1, j));
        }
        if (posValida(m, i - 1, j - 1)) {
            L1.add(new Regla(i - 1, j - 1));
        }
        if (posValida(m, i - 1, j + 1)) {
            L1.add(new Regla(i - 1, j + 1));
        }    
        if (posValida(m, i + 1, j + 1)) {
            L1.add(new Regla(i + 1, j + 1));
        } 
        if (posValida(m, i + 1, j - 1)) {
            L1.add(new Regla(i + 1, j - 1));
        }  
        return L1;
    }






    public static boolean backtrackLaberintoRey(int m[][], int i, int j, int ifin, int jfin, int paso) {
        m[i][j] = paso;
        if (i == ifin && j == jfin) {
            return true;
        }
        LinkedList<Regla> L1 =reglasAplicablesRey(m, i, j);
        while (!L1.isEmpty()) {
            Regla R =L1.removeFirst();//elegirRegla(L1,ifin,jfin); //L1.removeFirst(); //elegir siempre el primero
            if (backtrackLaberintoRey(m, R.fil, R.col, ifin, jfin, paso + 1)) {
                return true;
            };
            vueltas++;
            m[R.fil][R.col] = 0;
        }
        return false;
    }
   // ---- HEURISITCA DISTANCIA ENTRE 2 PUNTOS (Reemplazar  a Regla.reglasAplicablesRey(m, i, j)) --- ////
    public static Regla elegirRegla(LinkedList<Regla> l, int i, int j) {
        int index = 0;
        int aux = Integer.MAX_VALUE;
        for (int k = 0; k < l.size(); k++) {
            int a = (i - l.get(k).fil);
            a *= a;
            int b = (j - l.get(k).col);
            b *= b;
            if ((int)Math.sqrt(a + b) < aux) {
                aux = (int)Math.sqrt(a+b);
                index = k;
            }
        }
        return l.remove(index);     
    }
    
    public static void mostrar(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + ", ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        int x[][] = new int[m][n];
        
        vueltas = 0;
        
        if (backtrackLaberintoRey(x, 0, 0, 5, 5, 1)) {
            mostrar(x);
            System.out.println("vueltas: " + vueltas);
        } else {
            System.out.println("no hay solucion");
        }
    }   
}
