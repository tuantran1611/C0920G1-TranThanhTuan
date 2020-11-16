package _17_io_binary_file.exercise.bt_2_optional;

import java.io.*;

public class CopyFileBinary {
    public void copyFileBinary(File source, File dest){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(source));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(dest));
            objectOutputStream.writeObject(objectInputStream.readObject());
            objectOutputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
