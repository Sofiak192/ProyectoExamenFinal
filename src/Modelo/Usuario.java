
package Modelo;

public class Usuario {
    //Atributos
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;
    private int estado;
    
    //Constructor
    public Usuario(){
        this.idUsuario = 0;
        this.nombre = "";
        this.apellido = "";
        this.usuario = "";
        this.contraseña = "";
        this.estado = 0;
       
    }
    
    //set and get

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getcontraseña() {
        return contraseña;
    }

    public void setcontraseña(String password) {
        this.contraseña = password;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
