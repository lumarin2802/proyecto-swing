import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Consultas extends JFrame {
    private JList<Persona> listaPersonas;
    private JButton ButFiltrar;

    public Consultas(LinkedList<Persona> personas) {
        setTitle("Lista de Persona");

        setSize(1100, 500);

        DefaultListModel<Persona> modeloLista = new DefaultListModel<>();
        for (Persona persona : personas) {
            modeloLista.addElement(persona);
        }
        listaPersonas = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaPersonas);
        getContentPane().add(scrollPane);
        setVisible(true);

    }
}
