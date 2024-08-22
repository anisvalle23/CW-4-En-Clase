
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMiFile {

    static MiFile mf = new MiFile();
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        do {
            try {
                System.out.println("\n==============================");
                System.out.println("         MENU PRINCIPAL       ");
                System.out.println("==============================");
                System.out.println("1. Set el archivo / folder. ");
                System.out.println("2. Ver información");
                System.out.println("3. Crear un archivo");
                System.out.println("4. Crear un folder");
                System.out.println("5. Borrar");
                System.out.println("6. cmd - DIR");
                System.out.println("7. Tree");
                System.out.println("8. Escribir en el archivo (reemplazar)");
                System.out.println("9. Escribir en el archivo (añadir)");
                System.out.println("10. Leer archivo");
                System.out.println("11. Salir");
                System.out.println("==============================");
                System.out.print("Seleccione una opción: ");

                opcion = read.nextInt();
                System.out.println();

                switch (opcion) {
                    case 1:
                        set();
                        break;
                    case 2:
                        mf.Info();
                        break;
                    case 3:
                        mf.crearFile();
                        break;
                    case 4:
                        mf.crearFolder();
                        break;
                    case 5:
                        mf.borrar();
                        break;
                    case 6:
                        mf.dir();
                        break;
                    case 7:
                        mf.tree();
                        break;
                    case 8:
                        escribirReemplazar();
                        break;
                }

            } catch (InputMismatchException e) {
                read.nextLine();
                System.out.println("\n** Error: Por favor ingrese una opción válida. **\n");
            } catch (NullPointerException e) {
                System.out.println("\n** Error: Debes seleccionar la opción 1 al menos una vez. **\n");
            } catch (IOException e) {
                System.out.println("\n** Error: " + e.getMessage() + " **\n");
            }
        } while (opcion != 11);

        System.out.println("\nGracias por usar el programa. ¡Hasta luego!\n");
    }

    private static void set() {
        System.out.println("-------------------------------");
        System.out.print("Ingrese la dirección del archivo/folder: ");
        mf.setFile(read.next());
        System.out.println("-------------------------------");
    }

    private static void escribirReemplazar() throws IOException {
        System.out.println("-------------------------------");
        System.out.println("Escribe el texto que quieres reemplazar en el archivo:");
        read.nextLine();
        String texto = read.nextLine();
        mf.escribirArchivo(texto, false);
        System.out.println("-------------------------------");
    }

}
