package ifsc.poo.naves;

import ifsc.poo.interfaces.Tripulada;

public class NaveMineradora extends NaveEspacial 
implements Tripulada{

    // atributos do objeto
    private final int energiaLaserMaxima;
    private int energiaLaserAtual;
    private int maxTripulantes;

    public NaveMineradora(int energiaLaserMaxima, int qtdTripulantes){

        super();
        this.energiaLaserMaxima = energiaLaserMaxima;
        this.velocidadeMaxima = VELOCIDADE_MAX_SEM_BLINDAGEM;
        setQuantidadeTripulantes(maxTripulantes);
        energiaLaserAtual = 0;

    }

    public String toString() {
        return getClass().getSimpleName() +
           "  [ID: " + getId() +
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

    public boolean alternarLaser(){

        return true;

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
        return "Nave pousou. Velocidade atual é " + getVelocidadeAtual();

    }

    // métodos da interface TRIPULADA
    public String controleManual(){

        return "O piloto está no comando";

    }

}