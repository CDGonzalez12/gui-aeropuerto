import java.util.ArrayList;
import java.util.Scanner;

public class Vuelo implements IReservable {
    private int numeroVuelo;
    private String aerolinea;
    private String horaSalida;
    private String destino;
    private int capacidadMaxima;
    private Aeropuerto aeropuertoPartida;
    private Aeropuerto aeropuertoLlegada;
    private ArrayList<Pasajero> pasajeros;

    public Vuelo(int numeroVuelo, String aerolinea, String horaSalida, String destino, int capacidadMaxima, Aeropuerto aeropuertoPartida, Aeropuerto aeropuertoLlegada) {
        this.numeroVuelo = numeroVuelo;
        this.aerolinea = aerolinea;
        this.horaSalida = horaSalida;
        this.destino = destino;
        this.capacidadMaxima = capacidadMaxima;
        this.aeropuertoPartida = aeropuertoPartida;
        this.aeropuertoLlegada = aeropuertoLlegada;
        this.pasajeros = new ArrayList<>();
    }

    public boolean reservarAsiento(int cantidadAsientos) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos asientos desea comprar?: ");
        int cantidadPuestos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= cantidadPuestos; i++) {
            System.out.println("Ingrese detalles para el asiento " + i + ":");
            
            System.out.print("(X) - Ingrese su nombre: ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("x")) {
                System.out.println("Reserva Cancelada");
                return false;
            }
    
            System.out.print("(X) - Ingrese su numero de pasaporte: ");
            String numeroPasaporte = scanner.nextLine();
            if (numeroPasaporte.equalsIgnoreCase("x")) {
                System.out.println("Reserva Cancelada");
                return false;
            }
    
            System.out.print("(X) - Ingrese la cantidad de equipaje: ");
            String cantidadEquipajeStr = scanner.nextLine();
            if (cantidadEquipajeStr.equalsIgnoreCase("x")) {
                System.out.println("Reserva Cancelada");
                return false;
            }
    
            int cantidadEquipaje = Integer.parseInt(cantidadEquipajeStr);
    
            Pasajero pasajero = new Pasajero(nombre, numeroPasaporte, cantidadEquipaje);
    
            double precio = 100 + pasajero.calcularPrecioReserva();
            System.out.println("Precio de la reserva para el asiento " + i + ": " + precio);
    
            System.out.print("¿Desea realizar la reserva? - (X) - Ingrese SI para confirmar: ");
            String confirmar = scanner.nextLine();
            if (!confirmar.equalsIgnoreCase("si")) {
                System.out.println("Reserva Cancelada");
                return false;
            }
    
            agregarPasajero(pasajero);
            
        }
    
        return true;
    }

    public void agregarPasajero(Pasajero pasajero) {
        pasajeros.add(pasajero);
    }

    public int getNumeroVuelo() {
        return numeroVuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getDestino() {
        return destino;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public Aeropuerto getAeropuertoPartida() {
        return aeropuertoPartida;
    }

    public Aeropuerto getAeropuertoLlegada() {
        return aeropuertoLlegada;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    
}
