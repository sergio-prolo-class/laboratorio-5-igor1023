package ifsc.poo.naves;

public abstract class naveEspacial{

    // atributo da classe
    static private int id_naves;

    static{
        id_naves = 0;
    }

    // atributo de uma nave
    protected int id;
    protected int velocidadeAtual;

    naveEspacial(){

        this.id = ++id_naves;
        this.velocidadeAtual = 0;

    }

    public abstract int acelerar(int i);

    public abstract int frear(int i);

    public abstract void decolar();

    public abstract void pousar();

}