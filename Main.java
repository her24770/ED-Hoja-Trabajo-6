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
        System.out.println("Select Map implementation:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Crear el Map usando el Factory
        Map<String, Pokemon> pokemonMap = mapFactory.createMap(choice);

        // Leer el archivo CSV y cargar los datos en el Map
        readCSV("pokemon_data_pokeapi.csv", pokemonMap);

        // Lista para la colección del usuario
        List<Pokemon> userCollection = new ArrayList<>();

        // Menú de operaciones
        while (true) {
            System.out.println("\nSelect operation:");
            System.out.println("1. Add Pokémon to collection");
            System.out.println("2. Show Pokémon data");
            System.out.println("3. Show user's Pokémon by type");
            System.out.println("4. Show all Pokémon by type");
            System.out.println("5. Show Pokémon by ability");
            System.out.println("6. Exit");
            int operation = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (operation) {
                case 1:
                    System.out.println("Enter Pokémon name:");
                    String name = scanner.nextLine();
                    ControllerPokemon.addPokemonToCollection(pokemonMap, userCollection, name);
                    break;
                case 2:
                    System.out.println("Enter Pokémon name:");
                    name = scanner.nextLine();
                    ControllerPokemon.showPokemonData(pokemonMap, name);
                    break;
                case 3:
                    ControllerPokemon.showPokemonsByType(userCollection);
                    break;
                case 4:
                    ControllerPokemon.showAllPokemonsByType(pokemonMap);
                    break;
                case 5:
                    System.out.println("Enter ability:");
                    String ability = scanner.nextLine();
                    ControllerPokemon.showPokemonsByAbility(pokemonMap, ability);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid operation.");
            }
        }
    }

    // Función para leer el archivo CSV y cargar los datos en el Map
    public static void readCSV(String filePath, Map<String, Pokemon> pokemonMap) {
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            fileScanner.nextLine(); // Saltar la primera línea (encabezados)
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = parseCSVLine(line); // Usar una función para manejar comillas

                // Extraer los datos del Pokémon
                String name = data[0];
                int pokedexNumber = Integer.parseInt(data[1]);
                String type1 = data[2];
                String type2 = data[3];
                String classification = data[4];
                double height = Double.parseDouble(data[5]);
                double weight = Double.parseDouble(data[6]);
                List<String> abilities = Arrays.asList(data[7].split(", ")); // Separar las habilidades
                int generation = Integer.parseInt(data[8]);
                boolean isLegendary = data[9].equalsIgnoreCase("Yes");

                // Crear el objeto Pokemon
                Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, type2, classification, height, weight, abilities, generation, isLegendary);

                // Guardar el Pokémon en el Map
                pokemonMap.put(name, pokemon);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    // Función para manejar comillas en el CSV
    public static String[] parseCSVLine(String line) {
        List<String> values = new ArrayList<>();
        StringBuilder currentValue = new StringBuilder();
        boolean comillas = false;

        for (char c : line.toCharArray()) {
            if (c == '"') {
                comillas = !comillas; // Cambiar el estado de "dentro de comillas"
            } else if (c == ',' && !comillas) {
                // Si no estamos dentro de comillas, agregar el valor actual a la lista
                values.add(currentValue.toString().trim());
                currentValue = new StringBuilder(); // Reiniciar el valor actual
            } else {
                currentValue.append(c); // Agregar el carácter al valor actual
            }
        }

        // Agregar el último valor
        values.add(currentValue.toString().trim());

        return values.toArray(new String[0]);
    }
}