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
public class BackTrack_Sudoku {
        public static boolean sudoku(int m[][], int i, int j) {
        if (i >= m.length) {
            return true;
        }
        if (j >= m[i].length) {
            return sudoku(m, i + 1, 0);
        }
        if (m[i][j] != 0) {
            return sudoku(m, i, j + 1);
        }

        LinkedList<Integer> l1 = reglasAplicables(m, i, j);
        while (!l1.isEmpty()) {
            m[i][j] = reglaSodokuA(l1);
            if (sudoku(m, i, j + 1)) {
                return true;
            }
            vueltas++;
            m[i][j] = 0;
        }
        return false;
    }

    private static LinkedList<Integer> reglasAplicables(int[][] m, int i, int j) {
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        for (int valor = 1; valor <= m.length; valor++) {
            if (!enFila(m, i, valor) && !enColumna(m, j, valor) && !enRegion(m, i, j, valor)) {
                l1.add(valor);
            }
        }
        return l1;
    }

    private static boolean enFila(int[][] m, int i, int valor) {
        for (int j = 0; j < m[i].length; j++) {
            if (m[i][j] == valor) {
                return true;
            }
        }
        return false;
    }

    private static boolean enColumna(int[][] m, int j, int valor) {
        for (int i = 0; i < m.length; i++) {
            if (m[i][j] == valor) {
                return true;
            }
        }
        return false;
    }

    private static boolean enRegion(int[][] m, int i, int j, int valor) {
        int nFil = (int) Math.sqrt(m.length);
        int nCol = (int) Math.sqrt(m[i].length);

        int iRegion = (i / nFil) * nFil;
        int jRegion = (j / nCol) * nCol;
        for (int a = iRegion; a < iRegion + nFil; a++) {
            for (int b = jRegion; b < jRegion + nCol; b++) {
                if (m[a][b] == valor) {
                    return true;
                }
            }
        }
        return false;
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
    public static void sudokuAll(int m[][], int i, int j) {
        if (i >= m.length) {
            mostrar(m);
            cant++;
        } else if (j >= m[i].length) {
            sudokuAll(m, i + 1, 0);
        } else if (m[i][j] != 0) {
            sudokuAll(m, i, j + 1);
        } else {
            LinkedList<Integer> l1 = reglasAplicables(m, i, j);
            while (!l1.isEmpty()) {
                m[i][j] = l1.removeFirst();
                sudokuAll(m, i, j + 1);
                m[i][j] = 0;
            }
        }
    }
    
    public static Integer reglaSodokuA(LinkedList<Integer> lista) {
        return lista.remove( lista.size() / 2);
    }

    public static Integer reglaSodokuB(LinkedList<Integer> lista) {
        return lista.remove((int) (Math.random() * lista.size()) );
    }
    
    
    public static int cant;
    public static int vueltas;
    public static void main(String[] args) {
        int m[][] = new int[4][4];
        vueltas = 0;
        cant = 0;
        //sudokuAll(m, 0, 0);
        //System.out.println("soluciones: " + cant);
        if (sudoku(m, 0, 0)) {
            System.out.println("tiene solucion");
        } else {
            System.out.println("no tiene solucion");
        }
        System.out.println("vueltas: " + vueltas);
        mostrar(m);
    }
}
