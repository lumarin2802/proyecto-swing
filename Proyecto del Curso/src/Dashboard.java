import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Dashboard {
    private JButton volverAMenúButton;
    private JButton cantidadDeVehículosButton;
    private JLabel jlimgPer;
    private JButton cantidadDePersonasButton;
    private JLabel jlVehi;
    private JPanel PanelD;
    public LinkedList<Persona> personas = new LinkedList<>();
    public LinkedList<Vehiculo> vehiculo = new LinkedList<>();


    public Dashboard(LinkedList<Persona> persona) {
    this.personas = persona;
    JFrame frame = new JFrame();
    frame.setContentPane(PanelD);
    frame.setDefaultCloseOperation(3);
    frame.setSize (550,950);
    frame.setVisible(true);


    volverAMenúButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);

        }
    });
    cantidadDePersonasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int cantidadPersona = personas.size();
            JOptionPane.showMessageDialog(null, "La cantidad de Personas ingresadas en el sistema es: " +cantidadPersona,null,JOptionPane.INFORMATION_MESSAGE);

        }
    });
    cantidadDeVehículosButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int pConVehi = 0;
            for (Persona p: personas){
                if (p.getVehiculo().size()>0) {
                    pConVehi ++;
                }
            }
            JOptionPane.showMessageDialog(null, "La cantidad de Vehículos ingresados en el sistema es: " +pConVehi,null,JOptionPane.INFORMATION_MESSAGE);

        }
    });

}
}
