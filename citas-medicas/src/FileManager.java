import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    // Guardar datos en un archivo
    public static void guardarDatos(String archivo, List<?> datos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Object dato : datos) {
                writer.write(dato.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar datos en " + archivo + ": " + e.getMessage());
        }
    }

    // Cargar datos desde un archivo
    public static List<String> cargarDatos(String archivo) {
        List<String> datos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                datos.add(linea);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + archivo + ". Se creará uno nuevo al guardar datos.");
        } catch (IOException e) {
            System.err.println("Error al cargar datos desde " + archivo + ": " + e.getMessage());
        }
        return datos;
    }

    // Validar y regenerar archivos si no existen
    public static void validarArchivos() {
        String[] archivos = {"db/doctores.txt", "db/pacientes.txt", "db/citas.txt"};
        for (String archivo : archivos) {
            File file = new File(archivo);
            if (!file.exists()) {
                try {
                    file.getParentFile().mkdirs(); // Crea la carpeta db/ si no existe
                    file.createNewFile(); // Crea el archivo
                    System.out.println("Archivo creado: " + archivo);
                } catch (IOException e) {
                    System.err.println("Error al crear el archivo: " + archivo);
                }
            }
        }
    }
}