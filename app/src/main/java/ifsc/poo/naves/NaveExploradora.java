package ifsc.poo.naves;

import ifsc.poo.interfaces.Tripulada;
import ifsc.poo.interfaces.Blindada;

public class NaveExploradora extends NaveEspacial
implements Tripulada, Blindada{

    // atributos do objeto
    private boolean holofotes;

    public NaveExploradora(){

        super();
        this.holofotes = false;

    }

    public boolean ligarHolofotes(){

        return (this.holofotes = true);

    }

    public boolean desligarHolofotes(){

        return (this.holofotes = false);

    }

    // implementar metodos da classe abstratos
}