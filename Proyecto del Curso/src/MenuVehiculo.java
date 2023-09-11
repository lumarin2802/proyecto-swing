import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class MenuVehiculo {
    private JPanel panel;
    private JComboBox<String> BoxBarAvion;
    private JTextField TFeslora;
    private JTextField TFmanga;
    private JTextField TFcolor;
    private JTextField TFnombre;
    private JButton ButAgregar;
    private JLabel JLNombre;
    private JLabel JLColor;
    private JLabel JLTipVehi;
    private JLabel JLeslora;
    private JLabel JLmanga;
    private JTextField TFlong;
    private JTextField TFcantPas;
    private JLabel JLlong;
    private JLabel JLcantPas;
    private JButton ButCancelar;
    private JButton ButFinalizar;
    public LinkedList<Vehiculo> vehiculos = new LinkedList<>();
    private Persona ultimaPersona;
    public LinkedList<Persona> personas = new LinkedList<>();

    // Devuelve los vehículos creados
    public LinkedList<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }

    public MenuVehiculo(LinkedList<Vehiculo> vehiculos, LinkedList<Persona> personas) {
        this.vehiculos = vehiculos;
        this.personas = personas;
    }

    public MenuVehiculo(Persona persona) {

        this.ultimaPersona = persona;
        JFrame frame = new JFrame("Menú Vehículo");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(3);
        frame.setSize(550, 350);
        JLeslora.setVisible(false);
        TFeslora.setVisible(false);
        JLmanga.setVisible(false);
        TFmanga.setVisible(false);
        JLlong.setVisible(false);
        TFlong.setVisible(false);
        JLcantPas.setVisible(false);
        TFcantPas.setVisible(false);
        frame.setVisible(true);


        BoxBarAvion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String opcionSelec = (String) BoxBarAvion.getSelectedItem();

                if (opcionSelec.equals("Barco")) {

                    JLeslora.setVisible(true);
                    TFeslora.setVisible(true);
                    JLmanga.setVisible(true);
                    TFmanga.setVisible(true);

                    JLlong.setVisible(false);
                    TFlong.setVisible(false);
                    JLcantPas.setVisible(false);
                    TFcantPas.setVisible(false);

                } else if (opcionSelec.equals("Avion")) {
                    TFcantPas.setVisible(false);
                    JLeslora.setVisible(false);
                    TFeslora.setVisible(false);
                    JLmanga.setVisible(false);
                    TFmanga.setVisible(false);

                    JLlong.setVisible(true);
                    TFlong.setVisible(true);
                    JLcantPas.setVisible(true);
                    TFcantPas.setVisible(true);
                } else {
                    JLeslora.setVisible(false);
                    TFeslora.setVisible(false);
                    JLmanga.setVisible(false);
                    TFmanga.setVisible(false);
                    JLlong.setVisible(false);
                    TFlong.setVisible(false);
                    JLcantPas.setVisible(false);
                    TFcantPas.setVisible(false);

                }
            }
        });

        ButAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String opcionSelec = (String) BoxBarAvion.getSelectedItem();

                    String nombre = TFnombre.getText();
                    String color = TFcolor.getText();

                    if (nombre.isEmpty() || color.isEmpty()) {
                        throw new IllegalArgumentException("No se pueden dejar campos vacios");
                    }
                    if (!color.matches("[A-z]+")) {
                        throw new IllegalArgumentException("El color solo debe contener letras");
                    }


                    if (opcionSelec.equals("Barco")) {

                        Barco nuevoBarco = new Barco(
                                vehiculos.size() + 1,
                                nombre,
                                color,
                                ultimaPersona,
                                Double.parseDouble(TFeslora.getText()),
                                Double.parseDouble(TFmanga.getText())

                        );
                        vehiculos.add(nuevoBarco);
                        JOptionPane.showMessageDialog(null, "Barco añadido con éxito");
                        TFnombre.setText("");
                        TFcolor.setText("");
                        TFeslora.setText("");
                        TFmanga.setText("");

                    } else if (opcionSelec.equals("Avion")) {

                        Avion nuevoAvion = new Avion(
                                vehiculos.size() + 1,
                                nombre,
                                color,
                                ultimaPersona,
                                Double.parseDouble(TFlong.getText()),
                                Integer.parseInt(TFcantPas.getText())
                        );
                        vehiculos.add(nuevoAvion);
                        JOptionPane.showMessageDialog(null, "Avion añadido con éxito");
                        TFnombre.setText("");
                        TFcolor.setText("");
                        TFlong.setText("");
                        TFcantPas.setText("");


                    } else if (opcionSelec.equals("")) {
                        Vehiculo nuevoVehiculo = new Vehiculo(
                                vehiculos.size() + 1,
                                nombre,
                                color,
                                ultimaPersona

                        );
                        vehiculos.add(nuevoVehiculo);

                        JOptionPane.showMessageDialog(null, "Vehículo añadido con éxito");

                        TFnombre.setText("");
                        TFcolor.setText("");

                    }
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, "Los detalles de Barco y de Avión deben de ser números", "Dato Invalido", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (IllegalArgumentException iae) {
                    JOptionPane.showMessageDialog(null, iae.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        ButCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.setVisible(false);

            }
        });

        ButFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                String opcionSelec = (String) BoxBarAvion.getSelectedItem();

                String nombre = TFnombre.getText();
                String color = TFcolor.getText();

                if (nombre.isEmpty() || color.isEmpty()) {
                    throw new IllegalArgumentException("No se pueden dejar campos vacios");
                }
                if (!color.matches("[A-z]+")) {
                    throw new IllegalArgumentException("El color solo debe contener letras");
                }

                if (opcionSelec.equals("Barco")) {
                    Barco nuevoBarco = new Barco(
                            vehiculos.size() + 1,
                            TFnombre.getText(),
                            TFcolor.getText(),
                            ultimaPersona,
                            Double.parseDouble(TFeslora.getText()),
                            Double.parseDouble(TFmanga.getText())

                    );
                    vehiculos.add(nuevoBarco);
                    JOptionPane.showMessageDialog(null, "Barco añadido con éxito");
                    TFnombre.setText("");
                    TFcolor.setText("");
                    TFeslora.setText("");
                    TFmanga.setText("");
                } else if (opcionSelec.equals("Avion")) {
                    Avion nuevoAvion = new Avion(
                            vehiculos.size() + 1,
                            TFnombre.getText(),
                            TFcolor.getText(),
                            ultimaPersona,
                            Double.parseDouble(TFlong.getText()),
                            Integer.parseInt(TFcantPas.getText())
                    );
                    vehiculos.add(nuevoAvion);
                    JOptionPane.showMessageDialog(null, "Avion añadido con éxito");
                    TFnombre.setText("");
                    TFcolor.setText("");
                    TFlong.setText("");
                    TFcantPas.setText("");

                } else if (opcionSelec.equals("")) {
                    Vehiculo nuevoVehiculo = new Vehiculo(
                            vehiculos.size() + 1,
                            TFnombre.getText(),
                            TFcolor.getText(),
                            ultimaPersona

                    );
                    vehiculos.add(nuevoVehiculo);

                    JOptionPane.showMessageDialog(null, "Vehículo añadido con éxito");
                    TFnombre.setText("");
                    TFcolor.setText("");

                }
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null, "Los detalles de Barco y de Avión deben de ser números", "Dato Invalido", JOptionPane.ERROR_MESSAGE);
            }
                catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, iae.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            }

                frame.setVisible(false);

            }

        });


    }

    public static void main(String[] args) {
        MenuVehiculo menuv = new MenuVehiculo(new Persona());
    }


}