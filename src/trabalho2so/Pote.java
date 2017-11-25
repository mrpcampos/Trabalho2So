/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2so;

import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class Pote {
    int moedas;
    ArrayList<Pote> conectadoCom;

    public Pote(int moedas) {
        this.moedas = moedas;
        this.conectadoCom = new ArrayList<>();
    }
    /**
     * @param limite indicates how many more coins the dog can carry
     * 
     * 
     * @return Return 0 if there's are no coins, or 1, 2, 3 according to how many
     *         coins are in the pot and how many more can the dog carry
     */
    public synchronized int pegarMoedas(int limite){
        int maximo = 3;
        if(limite<=maximo){
            maximo=limite;
        }
        if(maximo<=moedas){
            moedas-=maximo;
            return maximo;
        }else{
            maximo=moedas;
            moedas=0;
        }
        return maximo;
    }
    public synchronized void colocarMoeda(){
        moedas++;
    }
}
