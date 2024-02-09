package serializationDeserializaton;

import java.io.*;

public class SerialDeserial implements Serializable {

    int i = 10; int j = 20;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SerialDeserial sd = new SerialDeserial();

        //Serialization - convert obj to file format
        //use fileOutputStream & ObjectOutputStream classes
        //writeObject method

        FileOutputStream fos = new FileOutputStream("test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(sd);

        //De-Serialization - convert file to object
        //use fileInputStream & ObjectInputStream classes
        //readObject method

        FileInputStream fis = new FileInputStream("test.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        SerialDeserial sd1 = (SerialDeserial)ois.readObject();
        System.out.println(sd1.i +" "+sd1.j );



    }
}
