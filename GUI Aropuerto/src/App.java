import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class App {

    public static void main(String[] args) throws SQLException {

        //Conectamos a la base de datos

        String url = "jdbc:mysql://localhost:3306/sistema_de_vuelo?serverTimezone=UTC";
        String username = "root";
        String password = "S3n42023*";

        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            if (connection!=null) {
                System.out.println("conectado");   
            }

            // Creamos la ventana
            JFrame ventana = new JFrame("Sistema de Vuelo");
            ventana.setVisible(true);
            ventana.setBounds(300, 200, 700, 500);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Creamos el panel de pestañas
            JTabbedPane pestañas = new JTabbedPane(JTabbedPane.TOP);

            //   ---   Creamos los elementos de la primera pestaña (Añadir Aeropuerto)   ---

            JPanel interfazAñadirAerupuerto = new JPanel(null);
            pestañas.addTab("Añadir Aeropuerto", interfazAñadirAerupuerto);

            JLabel labelAñadirAeropuerto1 = new JLabel("Nombre del Aeropuerto");
            labelAñadirAeropuerto1.setBounds(200, 30, 200, 100);
            interfazAñadirAerupuerto.add(labelAñadirAeropuerto1);
            JTextField cajaAñadirVuelo1 = new JTextField();
            cajaAñadirVuelo1.setBounds(350, 70,150, 20);
            interfazAñadirAerupuerto.add(cajaAñadirVuelo1);
            
            JLabel labelAñadirAeropuerto2 = new JLabel("Ubicación del Aeropuerto");
            labelAñadirAeropuerto2.setBounds(200, 60, 200, 100);
            interfazAñadirAerupuerto.add(labelAñadirAeropuerto2);
            JTextField cajaAñadirVuelo2 = new JTextField();
            cajaAñadirVuelo2.setBounds(350, 100,150, 20);
            interfazAñadirAerupuerto.add(cajaAñadirVuelo2);

            JButton botonAñadirAeropuerto = new JButton("Ingresar");
            botonAñadirAeropuerto.setBounds(280, 140, 100, 20);
            interfazAñadirAerupuerto.add(botonAñadirAeropuerto);

            //   ---Creamos los elementos de la segunda pestaña ("Añadir Vuelo")   ---

            JPanel interfazAñadirVuelo = new JPanel(null);
            pestañas.addTab("Añadir Vuelo", interfazAñadirVuelo);

            JLabel labelNumeroVuelo = new JLabel("Numero de Vuelo");
            labelNumeroVuelo.setBounds(200, 30, 250, 100);
            interfazAñadirVuelo.add(labelNumeroVuelo);
            JTextField cajaNumeroVuelo = new JTextField();
            cajaNumeroVuelo.setBounds(350, 70, 150, 20);
            interfazAñadirVuelo.add(cajaNumeroVuelo);

            JLabel labelNombreAerolinea = new JLabel("Nombre de la Aerolinea");
            labelNombreAerolinea.setBounds(200, 60, 250, 100);
            interfazAñadirVuelo.add(labelNombreAerolinea);
            JTextField cajaNombreAerolinea = new JTextField();
            cajaNombreAerolinea.setBounds(350, 100, 150, 20);
            interfazAñadirVuelo.add(cajaNombreAerolinea);

            JLabel labelHoraSalida = new JLabel("Hora de salida del vuelo");
            labelHoraSalida.setBounds(200, 90, 250, 100);
            interfazAñadirVuelo.add(labelHoraSalida);
            JTextField cajaHoraSalida = new JTextField();
            cajaHoraSalida.setBounds(350, 130, 150, 20);
            interfazAñadirVuelo.add(cajaHoraSalida);

            JLabel labelDestinoVuelo = new JLabel("Destino del vuelo");
            labelDestinoVuelo.setBounds(200, 120, 250, 100);
            interfazAñadirVuelo.add(labelDestinoVuelo);
            JTextField cajaDestinoVuelo = new JTextField();
            cajaDestinoVuelo.setBounds(350, 160, 150, 20);
            interfazAñadirVuelo.add(cajaDestinoVuelo);

            JLabel labelCapacidadMaxima = new JLabel("Capacidad Max del Vuelo");
            labelCapacidadMaxima.setBounds(200, 150, 250, 100);
            interfazAñadirVuelo.add(labelCapacidadMaxima);
            JTextField cajaCapacidadMaxima = new JTextField();
            cajaCapacidadMaxima.setBounds(350, 190, 150, 20);
            interfazAñadirVuelo.add(cajaCapacidadMaxima);

            JLabel labelAeropuertoDePartida = new JLabel("Aeropuerto de Partida");
            labelAeropuertoDePartida.setBounds(200, 180, 250, 100);
            interfazAñadirVuelo.add(labelAeropuertoDePartida);
            JTextField cajaAeropuertoDePartida = new JTextField();
            cajaAeropuertoDePartida.setBounds(350, 220, 150, 20);
            interfazAñadirVuelo.add(cajaAeropuertoDePartida);

            JLabel labelAeropuertoDeSalida = new JLabel("Aeropuerto de salida");
            labelAeropuertoDeSalida.setBounds(200, 210, 250, 100);
            interfazAñadirVuelo.add(labelAeropuertoDeSalida);
            JTextField cajaAeropuertoDeSalida = new JTextField();
            cajaAeropuertoDeSalida.setBounds(350, 250, 150, 20);
            interfazAñadirVuelo.add(cajaAeropuertoDeSalida);

            JButton botonAñadirVuelo = new JButton("Ingresar");
            botonAñadirVuelo.setBounds(280, 290, 100, 20);
            interfazAñadirVuelo.add(botonAñadirVuelo);

            //   ---   Creamos los elementos de la tercera pestaña (Reservar Asiento)   ---

            JPanel interfazReseverAsiento = new JPanel(null);
            pestañas.addTab("Reservar Asiento", interfazReseverAsiento);

            JLabel labelNumeroVuelo2 = new JLabel("Numero de Vuelo");
            labelNumeroVuelo.setBounds(200, 30, 250, 100);
            interfazReseverAsiento.add(labelNumeroVuelo2);
            JTextField cajaNumeroVuelo2 = new JTextField();
            cajaNumeroVuelo.setBounds(350, 70, 150, 20);
            interfazReseverAsiento.add(cajaNumeroVuelo2);

            JLabel labelNombrePasajero = new JLabel("Nombre del Pasajero");
            labelNombrePasajero.setBounds(200, 60, 250, 100);
            interfazReseverAsiento.add(labelNombrePasajero);
            JTextField cajaNombrePasajero = new JTextField();
            cajaNombrePasajero.setBounds(350, 100, 150, 20);
            interfazReseverAsiento.add(cajaNombrePasajero);

            JLabel labelNumeroPasaporte = new JLabel("Numero de Pasaporte");
            labelNumeroPasaporte.setBounds(200, 90, 250, 100);
            interfazReseverAsiento.add(labelNumeroPasaporte);
            JTextField cajaNumeroPasaporte = new JTextField();
            cajaNumeroPasaporte.setBounds(350, 130, 150, 20);
            interfazReseverAsiento.add(cajaNumeroPasaporte);

            JLabel labelCantidadEquipaje = new JLabel("Cantidad de Equipaje");
            labelCantidadEquipaje.setBounds(200, 120, 250, 100);
            interfazReseverAsiento.add(labelCantidadEquipaje);
            JTextField cajaCantidadEquipaje = new JTextField();
            cajaCantidadEquipaje.setBounds(350, 160, 150, 20);
            interfazReseverAsiento.add(cajaCantidadEquipaje);

            JButton botonReservarAsiento = new JButton("Ingresar");
            botonReservarAsiento.setBounds(280, 200, 100, 20);
            interfazReseverAsiento.add(botonReservarAsiento);

            //   ---   Creamos los elementos de la cuarta pestaña ("Información Pasajeros")   ---

            JPanel interfazInformacionPasajeros = new JPanel(null);
            pestañas.addTab("Información Pasajeros", interfazInformacionPasajeros);

            JButton botonVerVuelo = new JButton("Ver Informacion de Pasajeros");
            botonVerVuelo.setBounds(220, 40, 250, 20);
            interfazInformacionPasajeros.add(botonVerVuelo);

            //   ---   Creamos los elementos de la quinta pestaña ("Ver vuelo")

            JPanel interfazVerVuelo1 = new JPanel(null);
            pestañas.addTab("Ver Vuelo", interfazVerVuelo1);

            JLabel labelNumeroVuelo1 = new JLabel("Numero de Vuelo");
            labelNumeroVuelo1.setBounds(200, 30, 250, 100);
            interfazVerVuelo1.add(labelNumeroVuelo1);
            JTextField cajaNumeroVuelo1 = new JTextField();
            cajaNumeroVuelo1.setBounds(350, 70, 150, 20);
            interfazVerVuelo1.add(cajaNumeroVuelo1);

            JButton botonVerVuelo1 = new JButton("Ingresar");
            botonVerVuelo1.setBounds(280, 110, 100, 20);
            interfazVerVuelo1.add(botonVerVuelo1);

            //   ---   Creamos los elementos de la sexta pestaña ("Ver vuelos")

            JPanel interfazVerVuelos = new JPanel(null);
            pestañas.addTab("Ver Vuelos", interfazVerVuelos);

            JButton botonVerVuelos = new JButton("Ver Vuelos");
            botonVerVuelos.setBounds(280, 40, 100, 20);
            interfazVerVuelos.add(botonVerVuelos);

            //   ---   Aqui generamos las acciones de los botones   ---

            // Añadir Aeropuerto

            String sqlAeropuertos = "";
            ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();
            sqlAeropuertos = "SELECT * FROM aeropuerto";
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sqlAeropuertos);

            while (rs.next()) {

                String nombreAero = rs.getString("nombre");
                String ubicacionAero = rs.getString("ubicacion");

                aeropuertos.add(new Aeropuerto(nombreAero, ubicacionAero)); 
            }

            botonAñadirAeropuerto.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String cajaTextoVacia = cajaAñadirVuelo1.getText();

                    if (cajaTextoVacia.length()!=0) {
                        
                        String nombreAeropuerto = cajaAñadirVuelo1.getText();
                        String ubicacionAeropuerto = cajaAñadirVuelo2.getText();
                        Boolean confirmarExistencia = false;            
                        Aeropuerto buscarAeropuerto = buscarAeropuertoNombre(aeropuertos, nombreAeropuerto);

                        if (buscarAeropuerto == null) {
                            confirmarExistencia = true;      
                        }

                        if (confirmarExistencia) {

                            Aeropuerto aeropuerto = new Aeropuerto(nombreAeropuerto, ubicacionAeropuerto);
                            aeropuertos.add(aeropuerto);

                            String sql = "INSERT INTO aeropuerto (nombre, ubicacion) VALUES (?,?)";
                            PreparedStatement pstm;
                            try {

                                pstm = connection.prepareStatement(sql);
                                pstm.setString(1, nombreAeropuerto);
                                pstm.setString(2, ubicacionAeropuerto);
                                pstm.executeUpdate();
                                pstm.close();

                                JOptionPane.showMessageDialog(ventana, "Aeropuerto Agregado Exitosamente");

                            } catch (SQLException e1) {
                            
                                e1.printStackTrace();
                                JOptionPane.showMessageDialog(ventana, "ERROR: no se pudo agregar al vuelo", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } 
                        } else {

                            JOptionPane.showMessageDialog(ventana, "ERROR: no se pudo agregar al vuelo", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }                        
                }               
            });

            // Añadir Vuelo

            String sqlvuelos = "";
            ArrayList<Vuelo> vuelos = new ArrayList<>();
            sqlvuelos = "SELECT * FROM aeropuerto";
            Statement stmvuelos = connection.createStatement();
            ResultSet rsvuelos = stm.executeQuery(sqlvuelos);

            while (rs.next()) {

                String nombreAero = rs.getString("nombre");
                String ubicacionAero = rs.getString("ubicacion");

                aeropuertos.add(new Aeropuerto(nombreAero, ubicacionAero)); 
            botonAñadirVuelo.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    String cajaTextoVacia = cajaNumeroVuelo.getText();
                    if (cajaTextoVacia.length()!=0) {

                        String nombreAerolinea = cajaNombreAerolinea.getText();
                        String horaSalida = cajaHoraSalida.getText();
                        String destino = cajaDestinoVuelo.getText();
                        String capacidadMaxima = cajaCapacidadMaxima.getText();
                        String aeropuertoPartida = cajaAeropuertoDePartida.getText();
                        String aeropuertoSalida = cajaAeropuertoDeSalida.getText();
                        
                    }
                }
                
            });
            

            // Agregamos el panel de pestañas a la ventana
            ventana.add(pestañas);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);


            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
 
    }

    private static Vuelo buscarVueloNombre (ArrayList<Aeropuerto> aeropuertos, int numeroVuelo ) {

        for (Aeropuerto aeropuerto : aeropuertos) {
            for (Vuelo vuelos : aeropuerto.getVuelos()) {
                if (vuelos.getNumeroVuelo()==numeroVuelo) {
                    return vuelos;          
                }
            } 
        }
        return null;
    }

    private static boolean existeNumeroVuelo (ArrayList<Aeropuerto> aeropuertos, int numeroVuelo ) {

        for (Aeropuerto aeropuerto : aeropuertos) {
            for (Vuelo vuelos : aeropuerto.getVuelos()) {
                if (vuelos.getNumeroVuelo()==numeroVuelo) {
                    return true;          
                }
            }
        }
        return false;
    }

    private static Aeropuerto buscarAeropuertoNombre (ArrayList<Aeropuerto> aeropuerto, String nombreAeropuerto) {

        for (Aeropuerto aeropuertos : aeropuerto) {
            if (aeropuertos.getNombre().equalsIgnoreCase(nombreAeropuerto)) {
                return aeropuertos;
            }  
        }
        return null;
    }

}
