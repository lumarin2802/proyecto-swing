import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;

public class Menu {

   private JPanel Panel;
    private JTextField tfnombre;
    private JTextField tfapellido;
    private JTextField tfcanthijos;
    private JTextField tffechanac;
    private JLabel Lnombre;
    private JLabel Lapellido;
    private JLabel Ldpres;
    private JLabel Lcanthijos;
    private JLabel Lfdn;
    private JLabel Lingresedatos;
    private JButton JBguardar;
    private JButton consultasButton;
    private JLabel JLimagen;
    private JLabel JLVehiculo;
    private JButton JBAgregar;
    private JComboBox BoxDepart;
    private JButton panelDeControlButton;
    public LinkedList<Persona> personas = new LinkedList<>();
    public LinkedList<Vehiculo> vehiculo = new LinkedList<>();


    public Menu() {

        JFrame frame = new JFrame("Menú Principal");
        frame.setContentPane(Panel);
        frame.setDefaultCloseOperation(3);
        frame.setSize (550,450);
        frame.setVisible(true);

        JBguardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              try {
                  String nombre = tfnombre.getText();
                  String apellido = tfapellido.getText();


                  if (!nombre.matches("[A-z]+")){
                      throw new IllegalArgumentException("El nombre solo debe contener letras");}

                  if (!apellido.matches("[A-z]+")){
                      throw new IllegalArgumentException("El apellido solo debe contener letras");}

                  if (nombre == null || nombre.isEmpty() || apellido == null || apellido.isEmpty() ){
                      throw new IllegalArgumentException("Debe de llenar los campos de Nombre y Apellido");
                  }
                  else if (BoxDepart.getSelectedItem()== ""){
                      throw new IllegalArgumentException("Seleccione un Departamento");
                  }

                  Persona nuevaPersona = new Persona(

                          personas.size() + 1,
                          nombre,
                          apellido,
                          (String) BoxDepart.getSelectedItem(),
                          Byte.parseByte(tfcanthijos.getText()),
                          LocalDate.parse(tffechanac.getText()),
                          new LinkedList<>()
                  );

                  personas.add(nuevaPersona);

                  JOptionPane.showMessageDialog(null, "Los datos han sido guardados");
                  tfnombre.setText("");
                  tfapellido.setText("");
                  tfcanthijos.setText("");
                  tffechanac.setText("");

              }catch (NumberFormatException nfe){
                  JOptionPane.showMessageDialog(null, "La cantidad de hijos debe de ser un número","Dato Invalido",JOptionPane.ERROR_MESSAGE);
              }catch (DateTimeParseException dtpe){
                  JOptionPane.showMessageDialog(null,"La fecha de nacimiento debe ingresarse AAAA-MM-DD","Dato Invalido",JOptionPane.ERROR_MESSAGE);
              }catch (IllegalArgumentException iae){
                  JOptionPane.showMessageDialog(null, iae.getMessage(), null, JOptionPane.ERROR_MESSAGE);

              }
            }
        });

        JBAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (personas.size()==0){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una persona!",null,JOptionPane.ERROR_MESSAGE);
                    return;
                }
                MenuVehiculo menuVehiculo = new MenuVehiculo(personas.get(personas.size() - 1));
                    asignarVehiculos(menuVehiculo.getVehiculos());

            }
        });

        consultasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Consultas consultas = new Consultas(personas);

            }
        });

        panelDeControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard panelControl = new Dashboard(personas);

            }
        });
    }

    public static void main(String[] args) {
        Menu menu = new Menu ();

    }

    // Método Para asignar vehiculos a la última persona
    private void asignarVehiculos (LinkedList<Vehiculo> nuevosVehiculos){
      if (personas.size()>0) {
          personas.get(personas.size() - 1).setVehiculo(nuevosVehiculos);
      }
    }

}



