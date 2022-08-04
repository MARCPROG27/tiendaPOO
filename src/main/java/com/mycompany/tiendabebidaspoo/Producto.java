/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendabebidaspoo;

import static com.mycompany.tiendabebidaspoo.TiendaBebidasPoo.entrada;
import static com.mycompany.tiendabebidaspoo.TiendaBebidasPoo.product;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Formatter;

/**
 *
 * @author Marco Salas,Yenny Gomez, Marcelo Valenzuela,Jose Nilo
 */
public class Producto {

    static int i, n;

    private String nombre;
    private int precio;
    private int stock;

    public Producto() {
    }

    public Producto(String nombre, int precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void modificarStock(int sto) {
        stock = stock - sto;
          System.out.println("VENTA REALIZADA");
    }

    public boolean quedaStock(int sto) {

        if (stock >= sto) {
             return true;
        } else {
            System.err.println("ERROR .SOLO QUEDAN " + stock + " UNIDADES");
            return false;
        }
    }

    public static void PedirProducto() {
        String opciondecompra;
        String productoconsultado;
        int unidades = 0;
        String respuesta;
        double factura = 0;

        ListadoProductos();
        System.out.println("\n\n\n");
        System.out.println("-------¿DESEA REALIZAR UNA COMPRA : SI(S) / NO (N)?----------  ");
        opciondecompra = entrada.next();

        switch (opciondecompra) {
            case "S":

                do {
                    System.out.println("\n\n\n");
                    System.out.print("INGRESE NOMBRE PRODUCTO ");
                    //LIMPIA BUFFER
                    entrada.nextLine();
                    productoconsultado = entrada.nextLine();

                    for (int i = 0; i < product.size(); i++) {

                        if (product.get(i).getNombre().equals(productoconsultado.toUpperCase())) {

                            System.out.print("UNIDADES POR COMPRAR:");
                            unidades = entrada.nextInt();

                            if (product.get(i).quedaStock(unidades) == false) {
                                System.out.println("NO HAY STOCK PARA ESTE PRODUCTO");
                                unidades = 0;

                            } else if (product.get(i).quedaStock(unidades) == true) {
                                product.get(i).modificarStock(unidades);
                                unidades = unidades * product.get(i).getPrecio();
                                System.out.println(product.get(i).getStock() + " UNIDADES QUEDAN EN STOCK DE " + product.get(i).getNombre() + "\n");
                                System.out.println(" TOTAL COMPRA PRODUCTO $" + unidades);
                                System.out.println("================================================");
                            }

                        }

                    }

                    factura = factura + unidades;
                    System.out.println("¿DESEA COMPRAR OTRO PRODUCTO?(SI (S)/NO (N) EMITIR BOLETA O FACTURA)");
                    respuesta = entrada.next();
                    ListadoProductos();
                } while (respuesta.equalsIgnoreCase("S"));
                System.out.println("\n\n\n");
                System.out.println("EL TOTAL DE SU COMPRA ES: " + factura + " PESOS");
                System.out.println("==================================================");
                System.out.println("EL TOTAL DE SU COMPRA MAS IVA ES: " + Math.round(calcularIVA(factura)) + " PESOS");
                VolveralMenu();
                break;

            case "N":
                VolveralMenu();

            default:
                System.out.print("INGRESE S O N");
                break;

        }

    }

    public static void ListadoProductos() {

        System.out.println("          ==================LISTADO STOCK DE PRODUCTOS================================");
        System.out.println("\n\n\n");
        System.out.println("                         PRODUCTO     PRECIO         STOCK DISPONIBLE");
        for (int i = 0; i < product.size(); i++) {
            //IMPRIME EN COLUMNAS Y EN FORMATO LOS VALORES DEL NOMBRE PRECIO Y PRODUCTO SE USA CLASE JAVA.UTIL.FORMATTER
            System.out.format("%32s%10d%16s", product.get(i).getNombre(), product.get(i).getPrecio(), product.get(i).getStock() + "\n");
        }

    }

    public static void MostrarProductos() {
        ListadoProductos();
        VolveralMenu();
    }

    public static void IngresoProductos() {
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("\n\n");
            System.out.print("  NUMERO DE PRODUCTOS QUE INGRESARÁ? ");
             n = Integer.parseInt(entrada.nextLine());
            System.out.print("  (PRESIONE ENTER 1 VEZ MAS)");
         
            for (i = 0; i <= n - 1; i++) {
                product.add(new Producto());
                //LIMPIA BUFFER
                entrada.nextLine();
                System.out.println("NOMBRE PRODUCTO: " + (i + 1) + "\t ");
                product.get(i).setNombre(entrada.nextLine());
                System.out.println("PRECIO PRODUCTO: " + (i + 1) + " \t");
                product.get(i).setPrecio(entrada.nextInt());
                System.out.println("STOCK PRODUCTO: " + (i + 1) + "\t ");
                product.get(i).setStock(entrada.nextInt());
                System.out.println("===================================");
            }

        } while (n < 0);
        VolveralMenu();
    }

    public static void VolveralMenu() {
        String volver;
        try {
            System.out.println("\n\n\n");
            System.out.print("------------------------¿DESEA VOLVER AL MENU PRINCIPAL: SI(S) / NO (N)?  ");
            volver = entrada.next();

            switch (volver) {
                case "S":
                    TiendaBebidasPoo.MenuPrincipal();
                    break;
                case "N":
                    System.out.print("INGRESE S O N");
                    break;
                     default:
                    System.out.print("INGRESE S O N");
                    break;

            }
        } catch (Exception e) {
            System.out.println("DEBE INSERTAR S (SI) O N (NO); UN CARACTER VALIDO");

        }

    }

    public static double calcularIVA(double p) {
        double iva;
        iva = (p * 0.19) + p;
        return iva;
    }

}
