package ifsc.poo.naves;

public abstract class NaveEspacial{

    // atributo da classe
    static private int id_naves;

    static{
        id_naves = 0;
    }

    // atributo de uma nave
    protected final int id;
    protected int velocidadeAtual;
    protected int velocidadeMaxima;
    protected boolean emVoo;

    NaveEspacial(){

        this.id = ++id_naves;
        this.velocidadeAtual = this.velocidadeMaxima = 0;
        this.emVoo = false;
    }

    public final int getId(){

        return this.id;

    }

    public abstract String acelerar(int i);

    public abstract String frear(int i);

    public abstract String decolar();

    public abstract String pousar();

}