/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tiendabebidaspoo;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Marco Salas,Yenny Gomez, Marcelo Valenzuela, Jose Nilo
 */
public class TiendaBebidasPoo {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Producto> product = new ArrayList();
    static int i, n;
    static String volver;

    public static void main(String[] args) {
        TiendaBebidasPoo.MenuPrincipal();
    }

    public static void MenuPrincipal() {
        int opcion;

        System.out.println("****MINIMARKET JAVAMARC: TIENDA DE PRODUCTOS*****");
        System.out.println("    1-INGRESO DE PRODUCTOS EN LA TIENDA....");
        System.out.println("    2-LISTADO DE PRODUCTOS");
        System.out.println("    3-VENTAS PARA CLIENTES......");
        System.out.println("    4-SALIR...............");
        System.out.println("\n");
        System.out.println("\n");

        try {

            System.out.print("------------------------INGRESE NUMERO DE MENU:");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:

                    Producto.IngresoProductos();
                    break;
                case 2:

                    Producto.MostrarProductos();
                    break;

                case 3:

                    Producto.PedirProducto();
                    break;

                case 4:
                    System.out.println("GRACIAS POR PREFERIRNOS!...LO ESTAREMOS ESPERANDO PARA UNA PROXIMA VISITA");
                    break;
                default:

                    System.out.println("DEBE INSERTAR UN NUMERO VALIDO ENTRE 1 Y 4");
                    break;

            }

        } catch (Exception e) {
            System.out.println("DEBE INSERTAR UN NUMERO VALIDO ENTRE 1 Y 4 Y NO UN CARACTER");

        }

    }

}
