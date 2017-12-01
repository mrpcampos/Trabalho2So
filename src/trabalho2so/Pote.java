/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2so;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class Pote {

    private int moedas;
    private final int index;
    private final ArrayList<Integer> conectadoCom;

    private final Random rd = new Random();

    public Pote(int index, int moedas) {
        this.index = index;
        this.moedas = moedas;
        this.conectadoCom = new ArrayList<>();
    }

    /**
     * @param c indicates which dog is trying to take coins
     * @param limite indicates how many more coins the dog can carry
     *
     *
     * @return Return 0 if there's are no coins, or 1, 2, 3 according to how
     * many coins are in the pot and how many more can the dog carry
     */
    public synchronized int pegarMoedas(Cachorro c, int limite) {
        while (!this.hasCoins()) {
            Tela.getInstance().cachorroDorme(c, index);
            try {
                wait(6000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pote.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int maximo = 3;
        if (limite <= maximo) {
            maximo = limite;
        }
        if (maximo <= moedas) {
            moedas -= maximo;
            return maximo;
        } else {
            maximo = moedas;
            moedas = 0;
        }
        return maximo;
    }

    public int trocarDePote() {
        int poteSorteado = rd.nextInt(conectadoCom.size());
        return conectadoCom.get(poteSorteado);
    }

    public synchronized void colocarMoeda() {
        moedas++;
        notifyAll();
    }

    public synchronized boolean hasCoins() {
        return moedas > 0;
    }

    public ArrayList<Integer> getConectadoCom() {
        return conectadoCom;
    }

    public void addConecao(Integer pote) {
        conectadoCom.add(pote);
    }

    public int getMoedas() {
        return moedas;
    }
}
