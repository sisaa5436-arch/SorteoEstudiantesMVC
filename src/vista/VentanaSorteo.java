package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VentanaSorteo extends JFrame {
    private static final long serialVersionUID = 1L;
    public final JTextField txtCantidad = new JTextField(5);
    public final JButton btnSortear = new JButton("Sortear");
    public final JButton btnLimpiar = new JButton("Limpiar");
    public final DefaultListModel<String> estudiantes = new DefaultListModel<>();
    public final DefaultListModel<String> ganadores = new DefaultListModel<>();
    public final JLabel mensaje = new JLabel("Ingrese cuántos estudiantes desea seleccionar.");

    public VentanaSorteo() {
        super("Sorteo de estudiantes");
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(16, 16, 16, 16));
        JLabel titulo = new JLabel("SORTEO DE ESTUDIANTES");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 20));
        JPanel arriba = new JPanel(new BorderLayout(8, 8));
        arriba.add(titulo, BorderLayout.NORTH);
        JPanel controles = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controles.add(new JLabel("Cantidad:")); controles.add(txtCantidad);
        controles.add(btnSortear); controles.add(btnLimpiar);
        arriba.add(controles, BorderLayout.SOUTH); panel.add(arriba, BorderLayout.NORTH);
        JPanel listas = new JPanel(new GridLayout(1, 2, 12, 0));
        listas.add(crearLista("Participantes", estudiantes));
        listas.add(crearLista("Seleccionados", ganadores));
        panel.add(listas, BorderLayout.CENTER); panel.add(mensaje, BorderLayout.SOUTH);
        setContentPane(panel); setSize(680, 440); setResizable(false);
        setLocationRelativeTo(null); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(btnSortear);
    }

    private JPanel crearLista(String titulo, DefaultListModel<String> datos) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.add(new JLabel(titulo), BorderLayout.NORTH);
        JList<String> lista = new JList<>(datos); lista.setFixedCellHeight(25);
        panel.add(new JScrollPane(lista), BorderLayout.CENTER);
        return panel;
    }
}
