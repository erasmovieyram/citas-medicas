import java.util.*;

public class Main {
    private static List<Doctor> doctores = new ArrayList<>();
    private static List<Paciente> pacientes = new ArrayList<>();
    private static Admin admin = new Admin("admin", "password");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema de Citas Médicas ===");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        if (!admin.iniciarSesion(usuario, contrasena)) {
            System.out.println("Acceso denegado. Credenciales incorrectas.");
            return;
        }

        int opcion;
        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Registrar doctor");
            System.out.println("2. Registrar paciente");
            System.out.println("3. Crear cita");
            System.out.println("4. Relacionar cita con doctor y paciente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> registrarDoctor(scanner);
                case 2 -> registrarPaciente(scanner);
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);

        // Guardar datos antes de salir
        FileManager.guardarDatos("db/doctores.txt", doctores);
        FileManager.guardarDatos("db/pacientes.txt", pacientes);
    }

    private static void registrarDoctor(Scanner scanner) {
        System.out.print("ID del doctor: ");
        String id = scanner.nextLine();
        System.out.print("Nombre completo: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        doctores.add(new Doctor(id, nombreCompleto, especialidad));
        System.out.println("Doctor registrado exitosamente.");
    }
    
    private static void registrarPaciente(Scanner scanner) {
        System.out.print("ID del paciente: ");
        String id = scanner.nextLine();
        System.out.print("Nombre completo: ");
        String nombreCompleto = scanner.nextLine();

        pacientes.add(new Paciente(id, nombreCompleto));
        System.out.println("Paciente registrado exitosamente.");
    }

}


