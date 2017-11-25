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
    
    public synchronized int pegarMoedas(){
        switch (moedas){
            case 0:        //Talvez colocar algo aqui para "fazer o cachorro dormir",     
                return 0;  // da para tb se retornar zero fazer isso onde esse metodo é chamado
            case 1:
                moedas-=1;
                return 1;
            case 2:
                moedas-=2;
                return 2;
            default:
                moedas-=3;
                return 3;
        }
    }
    public synchronized void colocarMoeda(){
        moedas++;
    }
}
