/*
 * Clase que crea un mapa de acuerdo a la eleccion del usuario
 */
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class MapFactory {
    public Map<String, Pokemon> createMap(String choice) {
        switch (choice) {
            case "1":
                return new HashMap<>();
            case "2":
                return new TreeMap<>();
            case "3":
                return new LinkedHashMap<>();
            default:
            System.out.println("Opcion invalida");
                throw new IllegalArgumentException("Opcion invalida");
        }
    }
}