package model;

public class Producto {
    private int codigo;
    private String nombre;
    //hace referencia si es perecedero o no
    private String tipo;
    private int cantidad;
    private String stock;


    public Producto() {
    }

    public Producto(int codigo, String nombre, String tipo, int cantidad, String stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "\tProducto" +
                "\n==================================================================================="+
                "\ncodigo: " + codigo +
                "\nnombre: " + nombre +
                "\ntipo: " + tipo +
                "\ncantidad: " + cantidad +
                "\nstock: " + stock  +
                "\n======================================================================================";
    }
}
