package _17_io_binary_file.exercise.bt_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteBinaryFile {
    public static void writeBinaryFile(Product product){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(new File("src/_17_io_binary_file/exercise/bt_1/InfoProduct.dat"),true));
            List<Product> products = new ArrayList<>();
            products.add(product);
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readBinaryFile(){
        List<Product> productsOut = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(new File("src/_17_io_binary_file/exercise/bt_1/InfoProduct.dat")));
            productsOut = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return productsOut;
    }
}
