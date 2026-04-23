package tema7.funko;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class InputFunkos {
    private FileInputStream file;
    private ObjectInputStream input;

    //Abrir fichero
    public void abrirFSerial() throws IOException {

        file = new FileInputStream("/media/inicermar/flarp/IdeaProjects/ProgramacionInigo/src/tema7/funko/funkos.bat");
        input = new ObjectInputStream(file);
    }

    //Cerrar el fichero
    public void cerrarFSerial() throws IOException{
        if(input!=null)
            input.close();
    }

    public ArrayList<Funko> leerFSerial() throws IOException, ClassNotFoundException{
        ArrayList<Funko> funko = null;
        if(input!=null){
            try{
                funko = (ArrayList<Funko>)input.readObject();
            }catch (EOFException eof){
                //Fin del fichero
            }
        }
        return funko;
    }
}
