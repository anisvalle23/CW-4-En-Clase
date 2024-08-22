
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class MiFile {

    private File mf = null;

    public void setFile(String dir) {
        mf = new File(dir);
    }

    public void Info() {
        if (mf.exists()) {
            System.out.println("Sí existe:");
            System.out.println("Nombre: " + mf.getName()
                    + "\nPath: " + mf.getPath()
                    + "\nAbsoluta: " + mf.getAbsolutePath()
                    + "\nPadre: " + mf.getAbsoluteFile().getParentFile().getName()
                    + "\nBytes: " + mf.length());

            if (mf.isFile()) {
                System.out.println("Es un archivo");
            } else if (mf.isDirectory()) {
                System.out.println("Es un folder");
            }

            System.out.println("Ultima modificación: " + new Date(mf.lastModified()));

        } else {
            System.out.println("El archivo no existe");
        }
    }

    public void crearFile() throws IOException {
        if (mf.createNewFile()) {
            System.out.println("Creado exitosamente");
        } else {
            System.out.println("No se pudo crear");
        }
    }

    public void crearFolder() {
        if (mf.mkdir()) {
            System.out.println("Creado exitosamente");
        } else {
            System.out.println("No se pudo crear");
        }
    }

    private boolean antidoto(File file) {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                antidoto(child);
            }
        }
        return file.delete();
    }

    public void borrar() {
        if (antidoto(mf)) {
            System.out.println("SE BORRO");
        } else {
            System.out.println("NO SE BORRO");
        }
    }

    public void dir() {
        if (mf.isDirectory()) {
            System.out.println("Directorio de:" + mf.getAbsolutePath());
            System.out.println("");
            int cfiles = 0, cdirs = 0, tbytes = 0;

            for (File child : mf.listFiles()) {
                if (child.isHidden()) {
                    //fecha ultima modificacion
                    Date ultima = new Date(child.lastModified());
                    System.out.println(ultima + "\t");
                    //si es file o folder
                    if (child.isDirectory()) {
                        cdirs++;
                        System.out.println("<DIR>\t\t");
                    } else {
                        //si es file
                        cfiles++;
                        tbytes += child.length();
                        System.out.println("        \t" + child.length() + "\t");
                    }
                    System.out.println("child.getName");
                }
            }
            System.out.println(cfiles + "archivos\t" + tbytes + "bytes" + "\n" + cdirs + "dirs");
        }
    }

    public void tree() {
        tree(mf, "-");
    }

    private void tree(File dir, String tab) {
        if (dir.isDirectory()) {
            System.out.println(tab + dir.getName());
        }
        for (File child : dir.listFiles()) {
            if (!child.isHidden()) {
                tree(child, tab + "--");
            }
        }
    }

    public void escribirArchivo(String texto, boolean anadir) throws IOException {
        if (mf != null && mf.isFile()) {
            try (FileWriter writer = new FileWriter(mf, anadir)) {
                if (anadir && mf.length() > 0) {
                    writer.write(System.lineSeparator());
                }
                writer.write(texto);
                System.out.println("Texto escrito exitosamente.");
            }
        } else {
            System.out.println("Debes seleccionar un archivo válido.");
        }
    }

}
