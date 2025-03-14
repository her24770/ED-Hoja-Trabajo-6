import org.junit.Test;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import static org.junit.Assert.*;

public class ControllerPokemonTest {

    // Pruebas para addColeccion
    @Test
    public void testAddColeccion() {
        Map<String, Pokemon> mapeoPokemon = new HashMap<>();
        mapeoPokemon.put("Bulbasaur", new Pokemon("Bulbasaur", 1, "Grass", "Poison", "Seed Pokémon", 0.7, 6.9, Arrays.asList("Overgrow", "Chlorophyll"), 1, false));
        mapeoPokemon.put("Charmander", new Pokemon("Charmander", 4, "Fire", null, "Lizard Pokémon", 0.6, 8.5, Arrays.asList("Blaze"), 1, false));

        List<Pokemon> coleccion = new ArrayList<>();

        ControllerPokemon.addColeccion(mapeoPokemon, coleccion, "Bulbasaur");
        assertEquals(1, coleccion.size()); 

        ControllerPokemon.addColeccion(mapeoPokemon, coleccion, "Bulbasaur");
        assertEquals(1, coleccion.size()); 

        ControllerPokemon.addColeccion(mapeoPokemon, coleccion, "Pikachu");
        assertEquals(1, coleccion.size()); 
    }

    // Pruebas para mostrarColeccionPorTipo1
    @Test
    public void testMostrarColeccionPorTipo1() {
        List<Pokemon> coleccion = new ArrayList<>();
        coleccion.add(new Pokemon("Charmander", 4, "Fire", null, "Lizard Pokémon", 0.6, 8.5, Arrays.asList("Blaze"), 1, false));
        coleccion.add(new Pokemon("Bulbasaur", 1, "Grass", "Poison", "Seed Pokémon", 0.7, 6.9, Arrays.asList("Overgrow", "Chlorophyll"), 1, false));
        coleccion.add(new Pokemon("Squirtle", 7, "Water", null, "Tiny Turtle Pokémon", 0.5, 9.0, Arrays.asList("Torrent"), 1, false));

        ControllerPokemon.mostrarColeccionPorTipo1(coleccion);

        assertEquals("Fire", coleccion.get(0).getType1()); 
        assertEquals("Grass", coleccion.get(1).getType1());
        assertEquals("Water", coleccion.get(2).getType1()); 
    }

    @Test
    public void testMostrarColeccionPorTipo1_Vacia() {
        List<Pokemon> coleccion = new ArrayList<>();

        ControllerPokemon.mostrarColeccionPorTipo1(coleccion);

        assertTrue(coleccion.isEmpty());
    }

    // Pruebas para mostrarListaPorTipo1
    @Test
    public void testMostrarListaPorTipo1() {
        // Crear un Map con algunos Pokémon
        Map<String, Pokemon> mapeoPokemon = new HashMap<>();
        mapeoPokemon.put("Charmander", new Pokemon("Charmander", 4, "Fire", null, "Lizard Pokémon", 0.6, 8.5, Arrays.asList("Blaze"), 1, false));
        mapeoPokemon.put("Bulbasaur", new Pokemon("Bulbasaur", 1, "Grass", "Poison", "Seed Pokémon", 0.7, 6.9, Arrays.asList("Overgrow", "Chlorophyll"), 1, false));
        mapeoPokemon.put("Squirtle", new Pokemon("Squirtle", 7, "Water", null, "Tiny Turtle Pokémon", 0.5, 9.0, Arrays.asList("Torrent"), 1, false));

        ControllerPokemon.mostrarListaPorTipo1(mapeoPokemon);

        List<Pokemon> listaPokemons = new ArrayList<>(mapeoPokemon.values());
        listaPokemons.sort(Comparator.comparing(Pokemon::getType1));

        assertEquals("Fire", listaPokemons.get(0).getType1()); 
        assertEquals("Grass", listaPokemons.get(1).getType1()); 
        assertEquals("Water", listaPokemons.get(2).getType1()); 
    }

    @Test
    public void testMostrarListaPorTipo1_Vacia() {
        Map<String, Pokemon> mapeoPokemon = new HashMap<>();

        ControllerPokemon.mostrarListaPorTipo1(mapeoPokemon);

        assertTrue(mapeoPokemon.isEmpty());
    }

    // Pruebas para mostrarPorHabilidad
    @Test
    public void testMostrarPorHabilidad() {
        Map<String, Pokemon> mapeoPokemon = new HashMap<>();
        mapeoPokemon.put("Bulbasaur", new Pokemon("Bulbasaur", 1, "Grass", "Poison", "Seed Pokémon", 0.7, 6.9, Arrays.asList("Overgrow", "Chlorophyll"), 1, false));
        mapeoPokemon.put("Charmander", new Pokemon("Charmander", 4, "Fire", null, "Lizard Pokémon", 0.6, 8.5, Arrays.asList("Blaze"), 1, false));
        mapeoPokemon.put("Squirtle", new Pokemon("Squirtle", 7, "Water", null, "Tiny Turtle Pokémon", 0.5, 9.0, Arrays.asList("Torrent"), 1, false));

        ControllerPokemon.mostrarPorHabilidad(mapeoPokemon, "Blaze");

        assertTrue(mapeoPokemon.get("Charmander").getAbilities().contains("Blaze"));
        assertFalse(mapeoPokemon.get("Bulbasaur").getAbilities().contains("Blaze"));
        assertFalse(mapeoPokemon.get("Squirtle").getAbilities().contains("Blaze"));
    }

    @Test
    public void testMostrarPorHabilidad_Inexistente() {
        Map<String, Pokemon> mapeoPokemon = new HashMap<>();
        mapeoPokemon.put("Bulbasaur", new Pokemon("Bulbasaur", 1, "Grass", "Poison", "Seed Pokémon", 0.7, 6.9, Arrays.asList("Overgrow", "Chlorophyll"), 1, false));
        mapeoPokemon.put("Charmander", new Pokemon("Charmander", 4, "Fire", null, "Lizard Pokémon", 0.6, 8.5, Arrays.asList("Blaze"), 1, false));

        ControllerPokemon.mostrarPorHabilidad(mapeoPokemon, "Volt Absorb");

        assertFalse(mapeoPokemon.get("Bulbasaur").getAbilities().contains("Volt Absorb"));
        assertFalse(mapeoPokemon.get("Charmander").getAbilities().contains("Volt Absorb"));
    }
}