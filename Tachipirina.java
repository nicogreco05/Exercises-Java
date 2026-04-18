package ES1;

public class Tachipirina extends AbstractFarmaco{
    private final ClasseTerapeutica<Tachipirina> classe;
    public Tachipirina(NomeCommerciale nome, Data dataScadenza, Data dataProduzione, PrincipioAttivo principio, ClasseTerapeutica<Tachipirina> classe){
        super(nome, dataScadenza, dataProduzione, principio);
        this.classe = classe;
    }

    @Override
    public ClasseTerapeutica<Tachipirina> getClasse(){
        return classe;
    }

    @Override
    public String toString(){
        return super.toString() + ", Tipo: tachipirina";
    }

}
