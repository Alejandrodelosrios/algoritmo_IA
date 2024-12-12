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
public class BackTrack_Caballo {

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
 
     public static LinkedList<Regla> reglasAplicablesCaballo(int m[][], int i, int j) {
        LinkedList<Regla> L1 = new LinkedList();
        if (posValida(m, i - 2, j - 1)) {
            L1.add(new Regla(i - 2, j - 1));
        }
        if (posValida(m, i - 2, j + 1)) {
            L1.add(new Regla(i - 2, j + 1));
        }
        if (posValida(m, i - 1, j - 2)) {
            L1.add(new Regla(i - 1, j - 2));
        }
        if (posValida(m, i + 1, j - 2)) {
            L1.add(new Regla(i + 1, j - 2));
        }
        if (posValida(m, i + 2, j - 1)) {
            L1.add(new Regla(i + 2, j - 1));
        }
        if (posValida(m, i + 2, j + 1)) {
            L1.add(new Regla(i + 2, j + 1));
        }
        if (posValida(m, i - 1, j + 2)) {
            L1.add(new Regla(i - 1, j + 2));
        }
        if (posValida(m, i + 1, j + 2)) {
            L1.add(new Regla(i + 1, j + 2));
        }
        return L1;
    }

 
    public static boolean saltoDelCaballo(int m[][], int i, int j, int paso) {
        m[i][j] = paso;
        if (TodoVisitado(m)) {
            return true;
        }
        LinkedList<Regla> L1 =reglasAplicablesCaballo(m, i, j);
        while (!L1.isEmpty()) {
            Regla R = L1.removeFirst(); //SELECCIONAR HEURISTICA
            if (saltoDelCaballo(m, R.fil, R.col, paso + 1)) {
                return true;
            }
            vueltas++;
            m[R.fil][R.col] = 0;
        }
        return false;
    }
    
    private static boolean TodoVisitado(int[][] m) {
        for (int[] ints : m) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    // -------------ESCRIBIR LAS 2 HEURISTICAS (Reemplazar a L1.removeFirst();)
    
    //heuristica 1: elegir la posiciones que tengan menos posibilidades
    public static Regla elegirHeuristica1(int m[][], LinkedList<Regla> l) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < l.size(); k++) {
            int x = (reglasAplicablesCaballo(m, l.get(k).fil, l.get(k).col)).size();
            if (x < min) {
                min = x;
                index = k;
            }
        }
        return l.remove(index);
    }
    
    
    //heuristica 2: matriz de costos 
    public static void ponerPrecio(int m[][]) {
        int[][] a = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (reglasAplicablesCaballo(a, i, j)).size();
            }
        }
    }

    public static Regla elegirHeuristica2(int m[][], LinkedList<Regla> l) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < l.size(); k++) {
            int x = m[l.get(k).fil][l.get(k).col];
            if (x < min) {
                min = x;
                index = k;
            }
        }
        return l.remove(index);
    }
    
    
    ///---------- FIN HEURISTICAS ----------- ///
    
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
        int m = 10;
        int n = 10;
        int x[][] = new int[m][n];
        
        vueltas = 0;
        
        if (saltoDelCaballo(x, 0, 0, 1)) {
            mostrar(x);
            System.out.println("vueltas: " + vueltas);
        } else {
            System.out.println("no hay solucion");
        }
    }    
}
