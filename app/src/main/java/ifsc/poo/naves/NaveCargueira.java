package ifsc.poo.naves;

import ifsc.poo.interfaces.Autonoma;
import ifsc.poo.interfaces.Blindada;

public class NaveCargueira extends NaveEspacial 
implements Blindada, Autonoma{

    // atributos da classe
    static private final double PORCENTAGEM_CARGA_MAX;

    static{
        PORCENTAGEM_CARGA_MAX = 70.0 / 100.0; // 70 %
    }

    // atributos do objeto
    private final int cargaMaxima;
    private int cargaAtual;
    private boolean blindagem;

    public NaveCargueira(int cargaMaxima){

        super();
        this.velocidadeMaxima = VELOCIDADE_MAX_SEM_BLINDAGEM;
        this.cargaMaxima = cargaMaxima;
        this.cargaAtual = 0;
        this.blindagem = false;

    }

    public String toString() {
        return getClass().getSimpleName() +
           "   [ID: " + getId() +
           ", velocidade atual (Mm/h): " + getVelocidadeAtual() +
           ", velocidade máxima (Mm/h): " + getVelocidadeMaxima() + "]";
    }

    public boolean getBlindagem(){

        return this.blindagem;

    }

    public int getCargaMaxima(){

        return this.cargaMaxima;

    }

    public int getCargaAtual(){

        return this.cargaAtual;

    }

    // implementar metodos da classe abstrata

    public int getVelocidadeAtual(){

        return this.velocidadeAtual;

    }

    public int getVelocidadeMaxima(){

        return this.velocidadeMaxima;

    }

    public boolean EstaEmVoo(){

        return this.emVoo;

    }

    public String acelerar(int i){

        if(i < 0) frear(i);

        if(getVelocidadeAtual() + i > getVelocidadeMaxima())
            return "Está na velocidade máxima";

        this.velocidadeAtual += i;

        return "Nave está com velocidade de " + this.velocidadeAtual + "Mm/h";
    }

    public String frear(int i){

        if(i > 0) acelerar(i);

        if(getVelocidadeAtual() - i <= 0)
            return pousar();
        
        this.velocidadeAtual -= i;
        return "Nave está com velocidade de " + getVelocidadeAtual() + "Mm/h";
    }

    public String decolar(){

        this.velocidadeAtual = VELOCIDADE_AO_DECOLAR;

        if(getCargaAtual() > PORCENTAGEM_CARGA_MAX * getCargaMaxima()){
            
            ativarBlindagem();
            this.velocidadeMaxima = VELOCIDADE_MAX_COM_BLINDAGEM;
            if(getVelocidadeAtual() > getVelocidadeMaxima())
                this.velocidadeAtual = getVelocidadeMaxima();

        }
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


    // Método da interface AUTONOMA

    @Override
    public String controleAutomatico(){

        if(getVelocidadeAtual() == 0)
            return "Piloto automático acionado";

        return "Nave ainda está em rota";
    }

}