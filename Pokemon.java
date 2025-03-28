/*
 * 
 * Clase para definir a Pokemon como objeto y manejo posterior en mapas de acuerdo a lo pedido por el usuario
 */
import java.util.List;

public class Pokemon {
    private String name;
    private int pokedexNumber;
    private String type1;
    private String type2;
    private String classification;
    private double height;
    private double weight;
    private List<String> abilities;
    private int generation;
    private boolean isLegendary;

    
    /**
     * @param name
     * @param pokedexNumber
     * @param type1
     * @param type2
     * @param classification
     * @param height
     * @param weight
     * @param abilities
     * @param generation
     * @param isLegendary
     */
    public Pokemon(String name, int pokedexNumber, String type1, String type2, String classification, double height, double weight, List<String> abilities, int generation, boolean isLegendary) {
        this.name = name;
        this.pokedexNumber = pokedexNumber;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.isLegendary = isLegendary;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getPokedexNumber() {
        return pokedexNumber;
    }

    /**
     * @param pokedexNumber
     */
    public void setPokedexNumber(int pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }

    /**
     * @return
     */
    public String getType1() {
        return type1;
    }

    /**
     * @param type1
     */
    public void setType1(String type1) {
        this.type1 = type1;
    }

    /**
     * @return
     */
    public String getType2() {
        return type2;
    }

    /**
     * @param type2
     */
    public void setType2(String type2) {
        this.type2 = type2;
    }

    /**
     * @return
     */
    public String getClassification() {
        return classification;
    }

    /**
     * @param classification
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }

    /**
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return
     */
    public List<String> getAbilities() {
        return abilities;
    }

    /**
     * @param abilities
     */
    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    /**
     * @return
     */
    public int getGeneration() {
        return generation;
    }

    /**
     * @param generation
     */
    public void setGeneration(int generation) {
        this.generation = generation;
    }

    /**
     * @return
     */
    public boolean isLegendary() {
        return isLegendary;
    }

    /**
     * @param isLegendary
     */
    public void setLegendary(boolean isLegendary) {
        this.isLegendary = isLegendary;
    }

    /*
     * Meotod impresion de detalles del poémon
     */
    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", pokedexNumber=" + pokedexNumber +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", classification='" + classification + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", abilities=" + abilities +
                ", generation=" + generation +
                ", isLegendary=" + isLegendary +
                '}';
    }
}