package almacen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Almacen {
    protected ArrayList<Productos> productos;
    private int ventasGrafs = 0;
    private int ventasPlacas = 0;
    private int ventasFuentes = 0;
    private int ventasRAM = 0;
    private int ventasSSD = 0;

    public Almacen() {
        this.productos = new ArrayList<>();
    }

    public void addProduct(Productos.Type type, int price, String modelo){
        Productos prod = new Productos(type, price, modelo);
        productos.add(prod);
    }

    public Productos buscarProducto(int id){
        int cont = 0;
        while(productos.get(cont).getId() != id){
            cont++;
        }
        if (cont < productos.size()){
            return productos.get(cont);
        }
        return null;
    }


    public boolean venderProducto(Productos.Type tipo){
        int contador = 0;
        Productos.Type type;
         while (productos.get(contador).getType() != tipo){
            contador++;
        }
         type = productos.get(contador).getType();
             switch (type){
                 case RAM -> {
                     ventasRAM += productos.get(contador).getPrice();
                     productos.remove(contador);
                     break;
                 }
                 case SSD -> {
                     ventasSSD += productos.get(contador).getPrice();
                     productos.remove(contador);
                     break;
                 }
                 case PLACAS -> {
                     ventasPlacas += productos.get(contador).getPrice();
                     productos.remove(contador);
                     break;
                 }
                 case FUENTES -> {
                     ventasFuentes += productos.get(contador).getPrice();
                     productos.remove(contador);
                     break;
                 }
                 case GRAFICAS -> {
                     ventasGrafs += productos.get(contador).getPrice();
                     productos.remove(contador);
                     break;
                 }
        }
        return false;
    }

    public void cambiarPrecio(int id, int precio){
        buscarProducto(id).cambiarPrecio(precio);
    }

    public void mostrarFact(){
        System.out.println("*****************************************************");
        System.out.println("****** VENTAS DE RAM ********************\n");
        System.out.println(ventasRAM + "€");
        System.out.println("*****************************************************");
        System.out.println("*****************************************************");

        System.out.println("*****************************************************");
        System.out.println("****** VENTAS DE SSD ********************\n");
        System.out.println(ventasSSD + "€");
        System.out.println("*****************************************************");
        System.out.println("*****************************************************");

        System.out.println("*****************************************************");
        System.out.println("****** VENTAS DE TARJETAS GRÁFICAS ********************\n");
        System.out.println(ventasGrafs + "€");
        System.out.println("*****************************************************");
        System.out.println("*****************************************************");

        System.out.println("*****************************************************");
        System.out.println("****** VENTAS DE FUENTES ********************\n");
        System.out.println(ventasFuentes + "€");
        System.out.println("*****************************************************");
        System.out.println("*****************************************************");

        System.out.println("*****************************************************");
        System.out.println("****** VENTAS DE PLACAS ********************\n");
        System.out.println(ventasPlacas + "€");
        System.out.println("*****************************************************");
        System.out.println("*****************************************************");
    }

    private int getVentas(Productos.Type tipo){
        int ventas = 0;
        if (tipo == Productos.Type.FUENTES) {
            ventas += ventasFuentes;
        }
        else if (tipo == Productos.Type.SSD) {
            ventas += ventasSSD;
        }
        else if (tipo == Productos.Type.PLACAS) {
            ventas += ventasPlacas;
        }
        else if (tipo == Productos.Type.RAM) {
            ventas += ventasRAM;
        }
        else if (tipo == Productos.Type.GRAFICAS) {
            ventas += ventasGrafs;
        }
        return ventas;
    }

    public void mostrarFact1(Productos.Type tipo){
        System.out.println("*****************************************************");
        System.out.println("****** VENTAS DE" + tipo.toString().toUpperCase() + "********************\n");
        System.out.println(getVentas(tipo) + "€");
        System.out.println("*****************************************************");
        System.out.println("*****************************************************");
    }

}