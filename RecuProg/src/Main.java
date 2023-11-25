
import almacen.Almacen;
import almacen.Productos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int numero;

        while (true) {
            System.out.println("******************************************************************\n");
            System.out.print("Elija una de las siguientes opciones a través de número correspondiente:\n ");
            System.out.println("1- Insertar producto en almacén");
            System.out.println("2- Buscar producto");
            System.out.println("3- Venta de producto");
            System.out.println("4- Cambiar precio producto");
            System.out.println("5- Mostrar facturación general");
            System.out.println("6- Mostrar facturación de producto");
            System.out.println("7- Salir");
            System.out.println("******************************************************************\n");

            if (teclado.hasNextInt()){
                numero = teclado.nextInt();
                teclado.nextLine();

                Almacen almacen = new Almacen();

                if (numero == 1) {
                    System.out.println("Tipo: ");
                    Productos.Type tipo = Productos.Type.valueOf(teclado.next().toUpperCase());
                    System.out.println("Modelo: ");
                    String modelo = teclado.next();
                    System.out.println("Precio: ");
                    int precio = teclado.nextInt();
                    almacen.addProduct(tipo, precio, modelo);
                }
                if (numero == 2) {
                    System.out.println("Introduzca el id del producto que quiera encontrar: ");
                    int id = teclado.nextInt();
                    almacen.buscarProducto(id);
                    if (almacen.buscarProducto(id) == null) {
                        System.out.println("*****************************************************");
                        System.out.println("****** PRODUCTO NO ENCONTRADO **********************");
                        System.out.println("******************************************************");
                    } else {
                        System.out.println("*****************************************************");
                        System.out.println("****** PRODUCTO ENCONTRADO *************************");
                        System.out.println("TIPO: " + almacen.buscarProducto(id).getType() + "\nID: " +
                                almacen.buscarProducto(id).getId() + "\nMODELO: " + almacen.buscarProducto(id).getModelo() +
                                "\nPRECIO: " + almacen.buscarProducto(id).getPrice());
                        System.out.println("******************************************************");
                        System.out.println("******************************************************");
                    }
                }
                if (numero == 3) {
                    System.out.println("Introduzca el tipo de producto: ");
                    Productos.Type t = Productos.Type.valueOf(teclado.next().toUpperCase());
                    boolean bool = almacen.venderProducto(t);
                    if (bool) {
                        System.out.println("Producto vendido");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                }
                if (numero == 4) {
                    System.out.println("Introduzca el id del producto al que le quiere cambiar el precio: ");
                    int i = teclado.nextInt();
                    System.out.println("Introduzca el precio nuevo: ");
                    int pr = teclado.nextInt();
                    almacen.cambiarPrecio(i, pr);
                    System.out.println("Se ha cambiado el precio");
                }
                if (numero == 5) almacen.mostrarFact();
                if (numero == 6) {
                    System.out.println("Introduzca el tipo de producto cuya facturación quiere consultar: ");
                    Productos.Type ti = Productos.Type.valueOf(teclado.next().toUpperCase());
                    almacen.mostrarFact1(ti);
                }
                if (numero == 7) {
                    System.out.println("Saliendo del programa...");
                    teclado.close();
                    System.exit(0);
                }
            }

        }




    }
}