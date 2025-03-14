/*
 * Clase ControllerPokemon con funciones para controlar funciones de mapeo de Pokémon sin importar la eleccion del usuario al Map
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ControllerPokemon {

    // Método para agregar un Pokémon a la colección del usuario
    public static void addColeccion(Map<String, Pokemon> mapeoPokemon, List<Pokemon> coleccion, String name) {
        Pokemon pokemon = mapeoPokemon.get(name);
        if (pokemon == null) {
            System.out.println("No existe este Pokémon");
        } else if (coleccion.contains(pokemon)) {
            System.out.println("Ya tienes guardado este Pokémon");
        } else {
            coleccion.add(pokemon);
            System.out.println("Pókemon '"+name+"'' agregado");
        }
    }

    // Método para mostrar los datos de un Pokémon
    public static void mostrarDeswcripcion(Map<String, Pokemon> mapeoPokemon, String name) {
        Pokemon pokemon = mapeoPokemon.get(name);
        if (pokemon == null) {
            System.out.println("No existe este Pokémon");
        } else {
            System.out.println(pokemon.toString());
        }
    }

    // Método para mostrar los Pokémon en la colección del usuario, ordenados por tipo1
    public static void mostrarColeccionPorTipo1(List<Pokemon> coleccion) {

        if (coleccion.isEmpty()) {
            System.out.println("Coleccion vacia");
            return;
        }
    
        List<Pokemon> coleccionOrdenada = new ArrayList<>(coleccion);
        Collections.sort(coleccionOrdenada, Comparator.comparing(Pokemon::getType1));
    
        System.out.println("Pokémon in your collection (sorted by Type1):");
        for (Pokemon pokemon : coleccionOrdenada) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType1());
        }
    }

    // Método para mostrar todos los Pokémon, ordenados por tipo1
    public static void mostrarListaPorTipo1(Map<String, Pokemon> mapeoPokemons) {
        // Verificar si el Map está vacío
        if (mapeoPokemons.isEmpty()) {
            System.out.println("No Pokémon data available.");
            return;
        }
    
        List<Pokemon> listaPokemons = new ArrayList<>(mapeoPokemons.values());
    
        Collections.sort(listaPokemons, Comparator.comparing(Pokemon::getType1));
    
        System.out.println("Ppókemones ordenados por tipo1");
        for (Pokemon pokemon : listaPokemons) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType1());
        }
    }

    // Método para mostrar los Pokémon que tienen una habilidad específica
    public static void mostrarPorHabilidad(Map<String, Pokemon> mapeoPokemon, String abilidad) {
        for (Pokemon pokemon : mapeoPokemon.values()) {
            if (pokemon.getAbilities().contains(abilidad)) {
                System.out.println(pokemon.getName());
            }
        }
    }
}
