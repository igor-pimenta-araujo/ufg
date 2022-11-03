import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BuffReader {

    private BuffReader() {
        throw new IllegalStateException("Utility class");
    }

    public static String searchAtCsv(String uf) {
        Map<Integer, String> hashMapRegions = new HashMap<Integer, String>();
        hashMapRegions.put(1, "Norte"); hashMapRegions.put(2, "Nordeste"); hashMapRegions.put(3, "Sudeste"); hashMapRegions.put(4, "Sul"); hashMapRegions.put(5, "Centro-Oeste");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("UF.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                String[] values = line.split(",");
                if (values[1].equals(uf)) {
                    String state = values[2];
                    String countryRegion = hashMapRegions.get(Integer.parseInt(values[3]));
                    return ("O estado é: " + state + ", e a regiao é " + countryRegion);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Estado não encontrado";
    }
}
