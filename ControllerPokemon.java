import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ControllerPokemon {
    
    // Método para agregar un Pokémon a la colección del usuario
    public static void addPokemonToCollection(Map<String, Pokemon> pokemonMap, List<Pokemon> userCollection, String name) {
        Pokemon pokemon = pokemonMap.get(name);
        if (pokemon == null) {
            System.out.println("Error: Pokémon not found.");
        } else if (userCollection.contains(pokemon)) {
            System.out.println("Error: Pokémon already in collection.");
        } else {
            userCollection.add(pokemon);
            System.out.println("Pokémon added to collection.");
        }
    }

    // Método para mostrar los datos de un Pokémon
    public static void showPokemonData(Map<String, Pokemon> pokemonMap, String name) {
        Pokemon pokemon = pokemonMap.get(name);
        if (pokemon == null) {
            System.out.println("Error: Pokémon not found.");
        } else {
            System.out.println(pokemon);
        }
    }

    // Método para mostrar los Pokémon en la colección del usuario, ordenados por tipo1
    public static void showPokemonsByType(List<Pokemon> userCollection) {
        List<Pokemon> sortedList = new ArrayList<>(userCollection);
        Collections.sort(sortedList, Comparator.comparing(Pokemon::getType1));
        for (Pokemon pokemon : sortedList) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType1());
        }
    }

    // Método para mostrar todos los Pokémon, ordenados por tipo1
    public static void showAllPokemonsByType(Map<String, Pokemon> pokemonMap) {
        List<Pokemon> allPokemons = new ArrayList<>(pokemonMap.values());
        Collections.sort(allPokemons, Comparator.comparing(Pokemon::getType1));
        for (Pokemon pokemon : allPokemons) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType1());
        }
    }

    // Método para mostrar los Pokémon que tienen una habilidad específica
    public static void showPokemonsByAbility(Map<String, Pokemon> pokemonMap, String ability) {
        for (Pokemon pokemon : pokemonMap.values()) {
            if (pokemon.getAbilities().contains(ability)) {
                System.out.println(pokemon.getName());
            }
        }
    }
}
