package ES1;

public class Chitarra extends AbstrStrumento{
    private final Categoria<Chitarra> categoria;
    public Chitarra(Nome nome, Anno annoCostruzione, Anno annoArrivo, Fabbricante fabbricante, Categoria<Chitarra> categoria){
        super(nome, annoCostruzione, annoArrivo, fabbricante);
        this.categoria = categoria;
    }

    public Categoria<Chitarra> getCategoria() {return categoria;}

    @Override
    public String toString() {return super.toString() + "Cateogoria: Chitarra";}
}
