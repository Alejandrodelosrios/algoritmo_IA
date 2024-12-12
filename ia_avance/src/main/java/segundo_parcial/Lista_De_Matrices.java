/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundo_parcial;

import java.util.LinkedList;

/**
 *
 * @author EQUIPO
 */
public class Lista_De_Matrices {

    
public static class Regla {

    public int fil;
    public int col;

    public Regla(int fil, int col) {
        this.fil = fil;
        this.col = col;
    }
    
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


      private static boolean posValida(int[][] m, int i, int j) {
        return (i >= 0 && i < m.length) && (j >= 0 && j < m[i].length) && (m[i][j] == 0);
    }
    
    
    
   //---------------- IDEA DE LISTA DE MATRICES (no exactamente solucion) --------------------///
    
    static LinkedList<int[][]> c = new LinkedList<int[][]>();
    
    private static int[][] copiarMatriz(int[][] m) {
        int x[][] = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
               x[i][j] = m[i][j];
            }
        }
        return x;
    }
    
    public static void LaberintoReyMatrices(int m[][], int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin) {
            c.add(copiarMatriz(m)); 
        }
        LinkedList<Regla> L1 = reglasAplicablesRey(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = L1.removeFirst();   // Elige la 1ra Regla y elimina
            LaberintoReyMatrices(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }
    
    public static void main(String[] args) {
        int x[][] = new int[3][3];
        
        //probar con atajos (trabas)
        x[1][2] = 9;
        LaberintoReyMatrices(x, 0, 0, 2, 2, 1);
    }
    
}
