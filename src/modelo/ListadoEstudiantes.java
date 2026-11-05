package modelo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListadoEstudiantes {
    private final List<String> estudiantes = new ArrayList<>();

    public ListadoEstudiantes(File archivo) throws IOException {
        for (String linea : Files.readAllLines(archivo.toPath(), StandardCharsets.UTF_8)) {
            String nombre = linea.trim();
            if (nombre.isEmpty()) { continue; }
            for (String existente : estudiantes) {
                if (existente.equalsIgnoreCase(nombre)) {
                    throw new IOException("Hay un estudiante repetido: " + nombre);
                }
            }
            estudiantes.add(nombre);
        }
        if (estudiantes.isEmpty()) { throw new IOException("El listado de estudiantes está vacío."); }
    }

    public List<String> getEstudiantes() { return Collections.unmodifiableList(estudiantes); }

    public List<String> sortear(String entrada) {
        int cantidad;
        try { cantidad = Integer.parseInt(entrada.trim()); }
        catch (NumberFormatException e) { throw new IllegalArgumentException("Ingrese una cantidad entera."); }
        if (cantidad < 1 || cantidad > estudiantes.size()) {
            throw new IllegalArgumentException("La cantidad debe estar entre 1 y " + estudiantes.size() + ".");
        }
        // Se mezcla una copia para conservar el listado original y evitar repetidos.
        List<String> copia = new ArrayList<>(estudiantes);
        Collections.shuffle(copia);
        return new ArrayList<>(copia.subList(0, cantidad));
    }
}
