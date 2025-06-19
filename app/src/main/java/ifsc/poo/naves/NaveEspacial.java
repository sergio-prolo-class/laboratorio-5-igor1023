// CLASSE ABSTRATA

package ifsc.poo.naves;

public abstract class NaveEspacial{

    // atributo da classe
    static private int id_naves;
    static int VELOCIDADE_MAX_SEM_BLINDAGEM;
    static int VELOCIDADE_MAX_COM_BLINDAGEM;
    static int VELOCIDADE_AO_DECOLAR;

    static{
        id_naves = 0;
        VELOCIDADE_MAX_SEM_BLINDAGEM = 20;
        VELOCIDADE_MAX_COM_BLINDAGEM = 14;
        VELOCIDADE_AO_DECOLAR = 5;
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

    public abstract int getVelocidadeAtual();

    public abstract int getVelocidadeMaxima();

    public abstract boolean EstaEmVoo();

    public abstract String acelerar(int i);

    public abstract String frear(int i);

    public abstract String decolar();

    public abstract String pousar();

}