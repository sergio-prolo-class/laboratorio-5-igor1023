package ifsc.poo;

import java.util.LinkedHashSet;
import java.util.Set;

import ifsc.poo.naves.NaveCargueira;
import ifsc.poo.naves.NaveEspacial;
import ifsc.poo.naves.NaveExploradora;
import ifsc.poo.naves.NaveMineradora;

public class App {
    
    static final int MAX_NAVES;
    static{
        MAX_NAVES = 50;
    }
    

    public static void main(String[] args) {
        
        Set<NaveEspacial> naves = new LinkedHashSet<>();

        for(int i = 0; i < MAX_NAVES; i++){

            NaveEspacial nave;

            if(i % 3 == 0)
                nave = new NaveCargueira(10);
            else if(i % 8 == 0)
                nave = new NaveExploradora(4);
            else nave = new NaveMineradora(2, 5);

            naves.add(nave);
        }

        System.out.println("Linha 36"); // debug

        for(NaveEspacial nave : naves){

            System.out.println(nave.toString()); // estudar como sobreescrever

        }

        System.out.println("Linha 44"); // debug

    }
}
