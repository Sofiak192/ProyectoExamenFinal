
package Modelo;


public class productos {
    
    private String codigo;
    private String nombre;
    private int cantidadProducto;
    private double precio;
    
    
    public productos(){
    
    }

    public productos( String codigo, String nombre, double precio, int cantidadProducto) {
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadProducto = cantidadProducto;
        
    }

   

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }
        
    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    
    
    
}
