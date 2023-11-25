package almacen;

public class Productos {
    public enum Type {RAM, GRAFICAS, PLACAS, FUENTES, SSD;}

    private Type type;
    private int price;
    private int id;
    private int contador = 0; //contador para asignar un id único a cada producto
    private String modelo;

    public Productos(Type type, int price, String modelo) {
        this.type = type;
        this.price = price;
        this.id = ++contador;
        this.modelo = modelo;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    //setter del precio
    public void cambiarPrecio(int price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}