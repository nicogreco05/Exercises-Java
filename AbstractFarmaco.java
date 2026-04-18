package ES1;

import java.util.Objects;

public abstract class AbstractFarmaco implements Farmaco{
    private final NomeCommerciale nome;
    private final Data dataScadenza;
    private final Data dataProduzione;
    private final PrincipioAttivo principio;
    protected AbstractFarmaco(NomeCommerciale nome, Data dataScadenza, Data dataProduzione, PrincipioAttivo principio){
        this.nome = nome;
        this.dataScadenza = dataScadenza;
        this.dataProduzione = dataProduzione;
        this.principio = principio;
    }

    @Override
    public NomeCommerciale getNome() {
        return nome;
    }

    @Override
    public Data dataScadenza(){
        return dataScadenza;
    }

    @Override
    public Data dataProduzione() {
        return dataProduzione;
    }

    @Override
    public PrincipioAttivo getPrincipio() {
        return principio;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o == null || o.getClass() != this.getClass()){
            return false;
        }
        AbstractFarmaco that = (AbstractFarmaco) o;
        return Objects.equals(nome, that.nome) && Objects.equals(dataScadenza, that.dataScadenza) && Objects.equals(dataProduzione, that.dataProduzione) && Objects.equals(principio, that.principio);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nome, dataScadenza, dataProduzione, principio);
    }

    @Override
    public String toString(){
        return "Farmaco con nome: " + nome.val() + ", Data Scadenza: " + dataScadenza.val() + ", Data produzione: " + dataProduzione.val() + ", Principio: " + principio.val();
    }
}
