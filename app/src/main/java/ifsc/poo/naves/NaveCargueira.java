package ifsc.poo.naves;

import ifsc.poo.interfaces.Blindada;
import ifsc.poo.interfaces.Autonoma;

public class NaveCargueira extends NaveEspacial 
implements Blindada, Autonoma{

    // atributos do objeto
    private final int cargaMaxima;
    private int cargaAtual;

    public NaveCargueira(int cargaMaxima){

        super();
        this.cargaMaxima = cargaMaxima;
        this.cargaAtual = 0;

    }


    // implementar metodos da classe abstratos
}