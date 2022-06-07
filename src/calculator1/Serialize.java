package calculator1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize {
    public static final String filePath = "C:\\Users\\User\\OneDrive\\Documents\\NetBeansProjects\\New Folder\\Calculator1\\src\\calculator1\\calculatorDatabase.bin";
        
    public static void serialize(String pathToDatabaseFile, Object object)throws IOException {
        File databaseFile = new File(pathToDatabaseFile);
        FileOutputStream fileOutputStream = new FileOutputStream(databaseFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        fileOutputStream.close();
        
    }
    
    public static Object deserialize(String pathToDatabaseFile)throws IOException, ClassNotFoundException {
        File databaseFile = new File(pathToDatabaseFile);
        FileInputStream fileInputStream = new FileInputStream(databaseFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object readObject = (Object)objectInputStream.readObject();
        
        objectInputStream.close();
        fileInputStream.close();
        
        return readObject;
    }
}
