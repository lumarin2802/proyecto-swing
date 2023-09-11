public class Barco extends Vehiculo{
    public double eslora;
    public double manga;

    public Barco (int idVehiculo, String nombre, String color, Persona persona, double eslora, double manga){
        super (idVehiculo,nombre,color,persona);
        this.eslora = eslora;
        this.manga = manga;
    }

    @Override
    public String toString() {
        return "Barco{" +
                "eslora=" + eslora +
                ", manga=" + manga +
                ", idVehiculo=" + idVehiculo +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +

                '}';
    }

    public double getEslora() {
        return eslora;
    }

    public void setEslora(double eslora) {
        this.eslora = eslora;
    }

    public double getManga() {
        return manga;
    }

    public void setManga(double manga) {
        this.manga = manga;
    }

}
