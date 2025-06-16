package ifsc.poo.naves;

import ifsc.poo.interfaces.Tripulada;

public class NaveMineradora extends NaveEspacial 
implements Tripulada{

    // atributos do objeto
    private final int energiaLaserMaxima;
    private int energiaLaserAtual;

    public NaveMineradora(int energiaLaserMaxima){

        super();
        this.energiaLaserMaxima = energiaLaserMaxima;
        energiaLaserAtual = 0;

    }

    public boolean alternarLaser(){

        return true;

    }

    // implementar metodos da classe abstratos
}