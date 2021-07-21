package view;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public void imprimirMenu(){
        System.out.println("\tMENU");
        System.out.println("======================================================================");
        System.out.println("1. Ingresar");
        System.out.println("2. Eliminar");
        System.out.println("3. Consultar");
        System.out.println("4. Modificar");
        System.out.println("5. salir");
        System.out.println("========================================================================");
        System.out.println("QUE OPCION QUIERE ESCOJER");
        int opcion = scanner.nextInt();
        switch (opcion){
            case 1:
                Insert insert = new Insert(null,true);
                new Menu().imprimirMenu();
            case 2:
                new Delete().eliminar();
                new Menu().imprimirMenu();
            case 3:
                Select select = new Select(null,true);
                new Menu().imprimirMenu();
            case 4:
                Update update = new Update(null,true);
                new Menu().imprimirMenu();
            case 5:

            default:
                System.out.println("opcion incorrecta");
        }
    }
}
