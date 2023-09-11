import java.awt.*;

public class Vehiculo {
    public int idVehiculo;
    public String nombre;
    public String color;
    public Persona persona;

    @Override
    public String toString() {
        return "Vehiculo{" +
                "idVehiculo=" + idVehiculo +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public Vehiculo(int idVehiculo, String nombre, String color, Persona persona) {
        this.idVehiculo = idVehiculo;
        this.nombre = nombre;
        this.color = color;
        this.persona = persona;

    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

