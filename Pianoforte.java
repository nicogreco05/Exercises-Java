package ES1;

public class Pianoforte extends AbstrStrumento {
    private final Categoria<Pianoforte> categoria;

    public Pianoforte(Nome nome, Anno annoCostruzione, Anno annoArrivo, Fabbricante fabbricante, Categoria<Pianoforte> genere) {
        super(nome, annoCostruzione, annoArrivo, fabbricante);
        this.categoria = genere;
    }

    public Categoria<Pianoforte> getCategoria() {return categoria;}

    @Override
    public String toString() {return super.toString() + "Categoria: Pianoforte";}
}
