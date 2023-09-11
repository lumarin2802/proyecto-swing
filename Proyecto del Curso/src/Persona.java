import java.time.LocalDate;
import java.util.LinkedList;

public class Persona {
    public int idPersona;
    public String nombre;
    public String apellido;
    public String dptoRes;
    private byte cantHijos;
    private LocalDate fechaNacimiento;
    public LinkedList<Vehiculo> vehiculo = new LinkedList<>();

    public Persona (int idPersona,String nombre, String apellido, String dptoRes, byte cantHijos,
                    LocalDate fechaNacimiento, LinkedList<Vehiculo>vehiculo){

        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dptoRes = dptoRes;
        this.cantHijos = cantHijos;
        this.fechaNacimiento = fechaNacimiento;
        this.vehiculo = vehiculo;

    }
    public Persona (){}

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public LinkedList<Vehiculo> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(LinkedList<Vehiculo> vehiculo) {
        this.vehiculo = vehiculo;
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

    public String getDptoRes() {
        return dptoRes;
    }

    public void setDptoRes(String dptoRes) {
        this.dptoRes = dptoRes;
    }

    public byte getCantHijos() {
        return cantHijos;
    }

    public void setCantHijos(byte cantHijos) {
        this.cantHijos = cantHijos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona: " + idPersona +
                ", Nombre: '" + nombre + '\'' +
                ", Apellido: '" + apellido + '\'' +
                ", Departamento de Residencia: '" + dptoRes + '\'' +
                ", Cantidad de hijos: " + cantHijos +
                ", Fecha de Nacimiento: " + fechaNacimiento +
                ", Vehículos: " + vehiculo +
                '}';
    }

}
