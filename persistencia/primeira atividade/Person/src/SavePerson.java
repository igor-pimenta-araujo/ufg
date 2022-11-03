import java.io.*;

public class SavePerson {
    private SavePerson() {}

    public static void save(String name, Integer age, Double income) throws IOException {
        File file = new File("personData.dat");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true); DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        dataOutputStream.writeUTF(name); dataOutputStream.writeUTF(age.toString()); dataOutputStream.writeUTF(income.toString());
        dataOutputStream.close(); fileOutputStream.close();
    }
}
