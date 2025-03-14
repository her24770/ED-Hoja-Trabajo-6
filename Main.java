import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MapFactory mapFactory = new MapFactory();

        // Pedir al usuario que elija una implementación de Map
        System.out.println("Seleccione el tipo de Map a utilizar:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        System.out.print("Ingresa tu opcion : ");
        String choice = scanner.nextLine();

        // Crear el Map usando el Factory
        Map<String, Pokemon> pokemonMap = mapFactory.createMap(choice);

        readCSV("pokemon_data_pokeapi.csv", pokemonMap);

        // Lista para la colección del usuario
        List<Pokemon> userCollection = new ArrayList<>();

        // Menu en loop 
        boolean loop = true;
        while (loop) {
            System.out.println("\nSelect operation:");
            System.out.println("1. Agregar pokémon a tu coleccion");
            System.out.println("2. Mosrtar informacion por nommbre");
            System.out.println("3. Mostrar pókemon de tu coleccion por tipo1");
            System.out.println("4. Mostrar pókemon por tipo1");
            System.out.println("5. Mostrar pókemon por abilidad");
            System.out.println("6. Exit");
            System.out.print("Ingresa tu opcion : ");
            String operation = scanner.nextLine();

            switch (operation) {
                case "1":
                    System.out.println("Ingresar nombre del pókemon:");
                    String name = scanner.nextLine();
                    ControllerPokemon.addColeccion(pokemonMap, userCollection, name);
                    break;
                case "2":
                System.out.println("Ingresar nombre del pókemon:");
                name = scanner.nextLine();
                    ControllerPokemon.mostrarDeswcripcion(pokemonMap, name);
                    break;
                case "3":
                    ControllerPokemon.mostrarColeccionPorTipo1(userCollection);
                    break;
                case "4":
                    ControllerPokemon.mostrarListaPorTipo1(pokemonMap);
                    break;
                case "5":
                System.out.println("Ingresar habilidad");
                String ability = scanner.nextLine();
                    ControllerPokemon.mostrarPorHabilidad(pokemonMap, ability);
                    break;
                case "6":
                    System.out.println("Saliendo...");
                    loop = false;
                    break;
                default:
                    System.out.println("Valor invalido");
            }
        }
    }

    // Función para leer el archivo CSV y cargar los datos en el Map
    public static void readCSV(String filePath, Map<String, Pokemon> pokemonMap) {
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            fileScanner.nextLine(); 
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = parseLine(line); 

                // Extraer los datos del Pokémon
                String name = data[0];
                int pokedexNumber = Integer.parseInt(data[1]);
                String type1 = data[2];
                String type2 = data[3];
                String classification = data[4];
                double height = Double.parseDouble(data[5]);
                double weight = Double.parseDouble(data[6]);
                List<String> abilities = Arrays.asList(data[7].split(", "));
                int generation = Integer.parseInt(data[8]);
                boolean isLegendary = data[9].equalsIgnoreCase("Yes");

                Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, type2, classification, height, weight, abilities, generation, isLegendary);

                pokemonMap.put(name, pokemon);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    // Función para manejar comillas en el CSV
    public static String[] parseLine(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentValue = new StringBuilder();
        boolean comillas = false;

        for (char ch : line.toCharArray()) {
            if (ch == '"') {
                comillas = !comillas; 
            } else if (ch == ',' && !comillas) {
                tokens.add(currentValue.toString().trim());
                currentValue = new StringBuilder(); 
            } else {
                currentValue.append(ch); 
            }
        }

        tokens.add(currentValue.toString().trim());

        return tokens.toArray(new String[0]);
    }
}