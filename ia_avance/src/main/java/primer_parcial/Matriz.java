/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primer_parcial;

import java.util.Random;

/**
 *
 * @author EQUIPO
 */
public class Matriz { 
  public int[][] elem;
    public int MaxFil;
    public int MaxCol;
    public int CantFil;
    public int CantCol;
    
    public Matriz(int MaxF, int MaxC) {
        MaxFil = MaxF;
        MaxCol = MaxC;
        CantFil = MaxFil;
        CantCol = MaxCol;
        elem = new int[MaxFil][MaxCol];
    }   
 
     public Matriz menor(int i, int j) {
        Matriz me = new Matriz(this.CantFil-1, this.CantCol-1);
        int k = 0, l = 0;
        for (int m = 0; m < this.CantFil; m++) {
            for (int n = 0; n < this.CantCol; n++) {
                if (i != m && j != n) {
                    me.elem[k][l] = this.elem[m][n];
                    l++;
                }   
            }
            l = 0;
            if (m != i) {
                k++;
            }
        }
        return me;
    } 
    
    
    public void SubMatrices() {
        SubMatrices(this);
    }

    public void SubMatrices(Matriz x) {
        if (x == null) {
            return;
        }
        if (x.CantFil <= 0 && x.CantCol <= 0) {
            return;
        }
        System.out.println(x);
        for (int i = 0; i < x.CantFil; i++) {
            for (int j = 0; j < x.CantCol; j++) {
                SubMatrices(x.menor(i, j));
            }
        }
    }   
  
  //------------------------- INCIO PROBLEMA DEL DETERMINANTE ----------------------------------
    
    public int signo(int i) {
        return (int)Math.pow(-1, i+1);
    }
    public int det() {
        return det(this);
    }
    
    public int det(Matriz x) {
        if (x.CantFil == 1) {
            return x.elem[0][0];
        }
        int sum = 0;
        for (int j = 0; j < x.CantFil; j++) {
            sum += x.signo(j) * x.elem[0][j] * det(x.menor(0, j));
        }
        return sum;
    }
    
    //------------------------- FIN PROBLEMA DEL DETERMINANTE ----------------------------------
    
    
    
    
    
    public void cargarRandom() {
       for (int m = 0; m < this.CantFil; m++) {
            for (int n = 0; n < this.CantCol; n++) {
                Random x = new Random();
                this.elem[m][n]=x.nextInt(18)+2;
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int m = 0; m < this.CantFil; m++) {
            for (int n = 0; n < this.CantCol; n++) {
              s += this.elem[m][n] + " ";
            }
            s += '\n';
        }
        s += '\n';
        return s;
    }
    
 public static void main(String [] arg){
     Matriz a = new Matriz(3, 3);
        a.cargarRandom();
        System.out.println(a);
        System.out.println(a.menor(1, 0));
        System.out.println(a.det());  
 } 
}