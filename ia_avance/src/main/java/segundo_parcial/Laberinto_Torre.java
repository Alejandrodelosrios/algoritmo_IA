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
public class Laberinto_Torre {
public static class Regla {

    public int fil;
    public int col;

    public Regla(int fil, int col) {
        this.fil = fil;
        this.col = col;
    }
    
}

    public static LinkedList<Regla> reglasAplicablesTorre(int m[][], int i, int j) {
        LinkedList<Regla> L1 = new LinkedList();
        int x = j - 1;
        while (posValida(m, i, x)) {
            L1.add(new Regla(i, x));
            x--;
        }
        x = i - 1;
        while (posValida(m, x, j)) {
            L1.add(new Regla(x, j));
            x--;
        }
        x = j + 1;
        while (posValida(m, i, x)) {
            L1.add(new Regla(i, x));
            x++;
        }
        x = i + 1;
        while (posValida(m, x, j)) {
            L1.add(new Regla(x, j));
            x++;
        }     
        return L1;
    }
    
public static void LaberintoTorre(int m[][], int i, int j, int ifin, int jfin, int paso) {
        if (!posValida(m, i, j)) {
            return;
        }
        m[i][j] = paso;
        if (i == ifin && j == jfin) {
            mostrar(m);
        }
        LinkedList<Regla> L1 = reglasAplicablesTorre(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = L1.removeFirst();   // Elige la 1ra Regla y elimina
            LaberintoTorre(m, R.fil, R.col, ifin, jfin, paso + 1);
            m[R.fil][R.col] = 0;
        }
    }   
      private static boolean posValida(int[][] m, int i, int j) {
        return (i >= 0 && i < m.length) && (j >= 0 && j < m[i].length) && (m[i][j] == 0);
    }
    
    private static void mostrar(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + ", ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
 
}    