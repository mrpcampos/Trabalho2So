/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2so;

/**
 *
 * @author Matheus
 */
public class Cachorro implements Runnable{
    
    Cor cor;
    int moedas;
    int poteAtual;
    
    Cachorro(Cor cor) {
        this.moedas=0;
        this.cor=cor;
        this.poteAtual=0;
    }

    @Override
    public void run() {
        
    }
    
}
