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
public class Cacador {
    Cachorro cachorros[];
    int moedas;
    Cor cor;

    public Cacador(Cor cor) {
        this.moedas=0;
        this.cor=cor;
        this.cachorros = new Cachorro[2];
        for(Cachorro c: cachorros){
            c=new Cachorro(cor);
        }
    }
}
