package app;

import java.io.File;
import java.io.IOException;
import javax.swing.SwingUtilities;
import modelo.ListadoEstudiantes;
import vista.VentanaSorteo;
import controlador.ControladorSorteo;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaSorteo vista = new VentanaSorteo();
            try {
                ListadoEstudiantes modelo = new ListadoEstudiantes(new File("doc/estudiantes.txt"));
                new ControladorSorteo(modelo, vista);
            } catch (IOException e) {
                vista.btnSortear.setEnabled(false);
                vista.mensaje.setText("No se pudo cargar doc/estudiantes.txt. Revise que exista y sea válido.");
            }
            vista.setVisible(true);
        });
    }
}
