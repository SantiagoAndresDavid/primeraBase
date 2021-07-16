package view;

import Controller.Consultas;

import java.util.Scanner;

public class Select {
    Scanner scanner = new Scanner(System.in);
    public void buscar(){
        System.out.println("Ingrese el codigo del producto que desea buscar");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        Consultas consultas = new Consultas();
        System.out.println(consultas.buscar(codigo));
    }
}
