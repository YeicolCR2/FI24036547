/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inverso.java;

import java.util.Scanner;

/**
 *
 * @author Games
 */
public class InversoJava {

       int invertir(int num, int invertido) {
        if (num>0){
        return invertir(num / 10, invertido * 10 + num % 10);
    }else{
            return invertido;
        }
   }
    
    
    public static void main(String[] args) {
       InversoJava numInv = new InversoJava();
       Scanner sc = new Scanner(System.in);
       int num = 0, invertido = 0;
       while(num <= 0){
       System.out.println("ingrese un numero mayor que 0");
       num  = sc.nextInt();
       }
        System.out.println("Numero original: " + num + " y el numero invertido ->  " + numInv.invertir(num, invertido) );
    }
          
} 