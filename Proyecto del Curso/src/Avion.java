public class Avion extends Vehiculo{
    public double longitud;
    public int cantPasajeros;
    public Avion (int idVehiculo, String nombre, String color,Persona persona, double longitud, int cantPasajeros){
        super (idVehiculo,nombre,color,persona);
        this.longitud = longitud;
        this.cantPasajeros = cantPasajeros;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "longitud=" + longitud +
                ", cantPasajeros=" + cantPasajeros +
                ", idVehiculo=" + idVehiculo +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +

                '}';
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }
}
