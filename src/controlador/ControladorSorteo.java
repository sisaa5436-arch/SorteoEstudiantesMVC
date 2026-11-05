package controlador;

import modelo.ListadoEstudiantes;
import vista.VentanaSorteo;

public class ControladorSorteo {
    private final ListadoEstudiantes modelo;
    private final VentanaSorteo vista;

    public ControladorSorteo(ListadoEstudiantes modelo, VentanaSorteo vista) {
        this.modelo = modelo; this.vista = vista;
        for (String nombre : modelo.getEstudiantes()) { vista.estudiantes.addElement(nombre); }
        vista.btnSortear.addActionListener(e -> sortear());
        vista.btnLimpiar.addActionListener(e -> {
            vista.txtCantidad.setText(""); vista.ganadores.clear();
            vista.mensaje.setText("Listo para un nuevo sorteo."); vista.txtCantidad.requestFocusInWindow();
        });
        vista.mensaje.setText("Total de participantes: " + modelo.getEstudiantes().size());
    }

    private void sortear() {
        vista.ganadores.clear();
        try {
            for (String nombre : modelo.sortear(vista.txtCantidad.getText())) {
                vista.ganadores.addElement(nombre);
            }
            vista.mensaje.setText("Seleccionados: " + vista.ganadores.size() + " (sin repetir).");
        } catch (IllegalArgumentException e) { vista.mensaje.setText(e.getMessage()); }
    }
}
