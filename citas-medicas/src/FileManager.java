import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static void guardarDatos(String archivo, List<?> datos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Object dato : datos) {
                writer.write(dato.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar datos: " + e.getMessage());
        }
    }

    public static List<String> cargarDatos(String archivo) {
        List<String> datos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                datos.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
        }
        return datos;
    }
}