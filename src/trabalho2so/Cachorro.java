/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2so;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class Cachorro extends Thread {

    private final Cor cor;
    private int moedas;
    private int poteAtual;
    private final int limite;
    private final long unidadeDeTempo;

    private final Bosque bosque;
    private final Tela tela;
    private final int limiteDono;
    private int moedasComDono;

    public Cachorro(Cor cor) {
        this.moedas = 0;
        this.cor = cor;
        this.poteAtual = 0;
        this.limite = 20;
        this.unidadeDeTempo = 100; //Diz que cada unidade de tempo são 100 milisegundos

        this.bosque = Bosque.getInstance();
        this.tela = Tela.getInstance();
        this.limiteDono=50;
        this.moedasComDono = 0;
    }

    private synchronized void entrar() {
        esperar(1);
        bosque.entrar(this);
        tela.cachorroEntraNoBosque(this);
    }

    private synchronized void pegarMoedas() {
        int moedasRecolhidas = -1;
        while (moedasRecolhidas <= 0) {
            esperar(1);
            moedasRecolhidas = bosque.pegarMoedas(this, poteAtual, limite - moedas);
            moedas += moedasRecolhidas;
            tela.cachorroPegaMoedas(this, poteAtual, moedas);
        }
    }

    private synchronized void trocarDePote() {
        esperar(1);
        bosque.trocarDePote(poteAtual);
        tela.cachorroTrocaDePote(this, poteAtual);
    }

    private synchronized void sair() {

    }

    @Override
    public void run() {
        entrar();
        pegarMoedas();
        int total = moedasComDono+moedas;
        while (moedas < limite && limiteDono>total) {
            trocarDePote();
            pegarMoedas();
            total = moedasComDono+moedas;
        }
        sair();
    }

    public synchronized void esperar(int tempoEmUnidade) {
        try {
            wait(tempoEmUnidade * unidadeDeTempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cachorro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cor getCor() {
        return cor;
    }

    public int getMoedas() {
        return moedas;
    }

    public int getPoteAtual() {
        return poteAtual;
    }

    public void setPoteAtual(int poteAtual) {
        this.poteAtual = poteAtual;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public void setMoedasComDono(int moedasComDono) {
        this.moedasComDono = moedasComDono;
    }

}
