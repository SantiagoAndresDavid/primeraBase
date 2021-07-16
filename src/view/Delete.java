package view;

import Controller.Consultas;

import java.util.Scanner;

public class Delete {
    Scanner scanner = new Scanner(System.in);
    public void eliminar(){
        System.out.println("Ingrese el codigo del producto que desea Eliminar");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        Consultas consultas= new Consultas();
        consultas.eliminar(codigo);
    }
}
