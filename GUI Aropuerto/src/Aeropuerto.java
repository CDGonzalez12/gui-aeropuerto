import java.util.ArrayList;

public class Aeropuerto {
    private String nombre;
    private String ubicacion;
    private ArrayList<Vuelo> vuelos;


    public Aeropuerto(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.vuelos = new ArrayList<>();

    }

    public void registrarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }
  
}
