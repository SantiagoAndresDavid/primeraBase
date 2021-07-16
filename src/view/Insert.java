package view;

import Controller.Consultas;

import model.Producto;

import java.util.Locale;
import java.util.Scanner;


public class Insert {
    Scanner scanner = new Scanner(System.in);

    public void crear() {
        Producto producto = new Producto();
        System.out.println("Ingrese el codigo del producto");
        producto.setCodigo(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Ingrese el nombre del producto");
        producto.setNombre(scanner.nextLine());
        System.out.println("ingrese si es Perecedero o No Perecedero");
        producto.setTipo(scanner.nextLine().toLowerCase(Locale.ROOT));
        System.out.println("ingrese la cantidad del producto");
        producto.setCantidad(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Ingrese si hay stock SI op NO");
        producto.setStock(scanner.nextLine());
        Consultas consultas = new Consultas();
        consultas.llenar(producto);
    }
}
