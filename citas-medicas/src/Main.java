import java.util.*;

public class Main {
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
        }while (opcion != 5);
    }
}

