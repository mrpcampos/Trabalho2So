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
public class Cachorro {

    private final Cor cor;
    private int moedas;
    private int poteAtual;
    private final Cacador dono;
    private final int limite;
    private final long unidadeDeTempo;

    private final Bosque bosque;
    private final Tela tela;
    private final int limiteDono;
    private int moedasComDono;
    
    private Thread ultimaThread;

    public Cachorro(Cacador cacador) {
        this.dono=cacador;
        this.moedas = 0;
        this.cor = cacador.getCor();
        this.poteAtual = 0;
        this.limite = 20;
        this.unidadeDeTempo = 100; //Diz que cada unidade de tempo são 100 milisegundos

        this.bosque = Bosque.getInstance();
        this.tela = Tela.getInstance();
        this.limiteDono=50;
        this.moedasComDono = cacador.getMoedas();
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
            tela.cachorroPegaMoedas(this, poteAtual, moedasRecolhidas);
        }
    }

    private synchronized void trocarDePote() {
        esperar(1);
        this.poteAtual = bosque.trocarDePote(poteAtual);
        tela.cachorroTrocaDePote(this, poteAtual);
    }

    private synchronized void sair() {
        bosque.sair(this);
        tela.cachorroSaiDoBosque(this);
        dono.addMoedas(moedas);
        moedas=0;
    }

    public void start(){
    	this.ultimaThread = new Thread(this::run);
    	this.ultimaThread.start();
    }
    
    public void join(long millis) throws InterruptedException {
    	if (ultimaThread != null)
    		this.ultimaThread.join(millis);
    }
    
    public void run() {
        if (ControladorPrincipal.getInstance().deveContinuar()){
        	entrar();
            pegarMoedas();
            int total = moedasComDono+moedas;
            while (moedas < limite && limiteDono>total && ControladorPrincipal.getInstance().deveContinuar()) {
                trocarDePote();
                pegarMoedas();
                total = moedasComDono+moedas;
            }
            sair();
        }
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