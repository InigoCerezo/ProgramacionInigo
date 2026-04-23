package tema7.funko;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class OutputFunkos {
    private FileOutputStream file;
    private ObjectOutputStream output;

    //Abrir fichero
    public void abrirFSerial() throws IOException {

        file = new FileOutputStream("/media/inicermar/flarp/IdeaProjects/ProgramacionInigo/src/tema7/funko/funkos.bat");
        output = new ObjectOutputStream(file);
    }

    //Cerrar el fichero
    public void cerrarFSerial() throws IOException{
        if(output!=null)
            output.close();
    }

    //Escribir en el fichero
    public void escribirFSerial(ArrayList<Funko> funko) throws IOException{
        if(output!=null) {
            output.writeObject(funko);
            output.write('\n');
        }
    }
}
