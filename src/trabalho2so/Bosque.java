/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2so;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class Bosque {

    private static Bosque instance;
    private Pote potes[];
    private SalvaVidas cachorroVermelho;
    Random rd = new Random();

    private Bosque() {
        potes = new Pote[20];
        potes[1].addConecao(potes[2]);
        potes[1].addConecao(potes[15]);
        potes[2].addConecao(potes[3]);
        potes[2].addConecao(potes[1]);
        potes[2].addConecao(potes[4]);
        potes[2].addConecao(potes[5]);
        potes[3].addConecao(potes[2]);
        potes[3].addConecao(potes[9]);
        potes[4].addConecao(potes[2]);
        potes[4].addConecao(potes[9]);
        potes[4].addConecao(potes[10]);
        potes[5].addConecao(potes[2]);
        potes[5].addConecao(potes[6]);
        potes[6].addConecao(potes[5]);
        potes[6].addConecao(potes[7]);
        potes[6].addConecao(potes[8]);
        potes[7].addConecao(potes[6]);
        potes[8].addConecao(potes[6]);
        potes[9].addConecao(potes[3]);
        potes[9].addConecao(potes[4]);
        potes[9].addConecao(potes[15]);
        potes[9].addConecao(potes[18]);
        potes[10].addConecao(potes[4]);
        potes[10].addConecao(potes[12]);
        potes[11].addConecao(potes[12]);
        potes[11].addConecao(potes[14]);
        potes[11].addConecao(potes[17]);
        potes[12].addConecao(potes[10]);
        potes[12].addConecao(potes[11]);
        potes[12].addConecao(potes[13]);
        potes[13].addConecao(potes[12]);
        potes[14].addConecao(potes[11]);
        potes[14].addConecao(potes[16]);
        potes[15].addConecao(potes[1]);
        potes[15].addConecao(potes[9]);
        potes[16].addConecao(potes[14]);
        potes[16].addConecao(potes[18]);
        potes[16].addConecao(potes[19]);
        potes[16].addConecao(potes[20]);
        potes[17].addConecao(potes[11]);
        potes[17].addConecao(potes[16]);
        potes[18].addConecao(potes[9]);
        potes[18].addConecao(potes[16]);
        potes[18].addConecao(potes[19]);
        potes[19].addConecao(potes[18]);
        potes[19].addConecao(potes[20]);
        potes[20].addConecao(potes[16]);
        potes[20].addConecao(potes[19]);

    }

    public static Bosque getInstance() {
        if (instance == null) {
            instance = new Bosque();
        }
        return instance;
    }

    public void entrar() {

    }

    /**
     *
     * @param pote Which pot the dog is coming from
     * @return Return where the dog is going to.
     */
    public synchronized int trocarDePote(int pote) {
        try {
            wait(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bosque.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rd.nextInt(potes[pote].getConectadoCom().size());
    }

    public void sair() {
        /*Chamada pelo cachorro quando atinge o limite de moedas ou quando
        seu dono chegou a 50, deve encerrar a thread do cachorro e dar as 
        moedas para seu dono, ou chamar um método que faça isso
         */
    }

    public void colocarMoedas() {
        try {
            wait(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bosque.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Pote p : potes) {
            if (p.getMoedas() == 0) {
                p.colocarMoeda();
                notifyAll();    //Confirmar se isso esta pegando, fiz a 
            }                   //primeira coisa que me pareceu certa
        }
        /*Chamada pelo cachorro vermelho (ou Salva Vidas) para colocar
        uma moeda no pote indicado
        
         */
    }

    /**
     *
     * @param pote indicates which pot the dog is trying to take coins from
     * @param limite indicates how many more coins the dog can carry
     *
     * @return how many coins the dog took from the pot
     */
    public synchronized int pegarMoedas(int pote, int limite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
