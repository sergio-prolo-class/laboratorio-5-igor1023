package ifsc.poo.naves;

import ifsc.poo.interfaces.Blindada;
import ifsc.poo.interfaces.Tripulada;

public class NaveExploradora extends NaveEspacial
implements Tripulada, Blindada{

    // atributos do objeto
    private boolean holofotes;
    private int maxTripulantes;
    private boolean blindagem;

    public NaveExploradora(int maxTripulantes){

        super();
        this.velocidadeMaxima = VELOCIDADE_MAX_COM_BLINDAGEM;
        setQuantidadeTripulantes(maxTripulantes);
        this.holofotes = false;

    }

    public String toString() {
        return getClass().getSimpleName() +
           " [ID: " + getId() +
           ", velocidade atual (Mm/h): " + getVelocidadeAtual() +
           ", velocidade máxima (Mm/h): " + getVelocidadeMaxima() + "]";
    }

    private boolean setQuantidadeTripulantes(int maxTripulantes){

        if(maxTripulantes <= MAX_TRIPULANTES){
            this.maxTripulantes = maxTripulantes;
            return true;
        }
        
        return false;

    }

    public boolean ligarHolofotes(){

        return (this.holofotes = true);

    }

    public boolean desligarHolofotes(){

        return (this.holofotes = false);

    }

    // implementar metodos da classe abstrata

    public  int getVelocidadeAtual(){

        return this.velocidadeAtual;

    }

    public int getVelocidadeMaxima(){

        return this.velocidadeMaxima;

    }

    public boolean EstaEmVoo(){

        return this.emVoo;

    }

    public String acelerar(int i){

        if(i < 0)
            return frear(i);
            
        if(getVelocidadeAtual() + i > getVelocidadeMaxima())
            return "Está na velocidade máxima";

        this.velocidadeAtual += i;
        return "Nave está com velocidade de " + this.velocidadeAtual + "Mm/h";

    }

    public String frear(int i){

        if(i < 0)
            i = Math.abs(i);
        
        if(getVelocidadeAtual() - i <= 0)
            return pousar();

        this.velocidadeAtual -= i;
        return "Nave está com velocidade de " + getVelocidadeAtual() + "Mm/h";

    }

    public String decolar(){

        this.velocidadeAtual = VELOCIDADE_AO_DECOLAR;
        return "A nave decolou e está com velocidade de " + getVelocidadeAtual() + "Mm/h";

    }

    public String pousar(){
     
        this.velocidadeAtual = 0;
        desativarBlindagem();
        return "Nave pousou. Velocidade atual é " + getVelocidadeAtual();

    }

    // Método da interface BLINDADA

    @Override
    public String ativarBlindagem(){

        this.blindagem = true;

        return "Blindagem ativada";

    }

    @Override
    public String desativarBlindagem(){

        this.blindagem = false;

        return "Blindagem desativada";

    }

    // Métodos da interface TRIPULADA

    @Override
    public String controleManual(){

        if(getVelocidadeAtual() == 0)
            return "Tem um tripulante pilotando";

        return "Nave ainda está voando";
    }
}