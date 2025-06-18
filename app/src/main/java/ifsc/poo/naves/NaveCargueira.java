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
        this.cargaMaxima = cargaMaxima;
        this.cargaAtual = 0;
        this.blindagem = false;

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

        return "Nave está com velocidade de " + this.velocidadeAtual + "milhas por hora";
    }

    public String frear(int i){

        if(i > 0) acelerar(i);

        if(getVelocidadeAtual() - i <= 0)
            return "Velocidade em zero";

        this.velocidadeAtual -= i;

        return "Nave está com velocidade de " + this.velocidadeAtual + "milhas por hora";
    }

    public String decolar(){

        this.velocidadeAtual = VELOCIDADE_AO_DECOLAR;

        if(getCargaAtual() > PORCENTAGEM_CARGA_MAX * getCargaMaxima())
            ativarBlindagem();

        return "A nave decolou e está com velocidade de " + getVelocidadeAtual() + "milhas";

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

}