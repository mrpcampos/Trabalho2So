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
public class Bosque {

    private static Bosque instance;
    private Pote potes[];
    private final SalvaVidas cachorroVermelho;

    private Bosque() {
        potes = new Pote[21];
        cachorroVermelho = new SalvaVidas();
        for (int i=1; i<potes.length; i++) {
            potes[i] = new Pote(i, 3);
        }

        potes[1].addConecao(2);
        potes[1].addConecao(15);
        potes[2].addConecao(3);
        potes[2].addConecao(1);
        potes[2].addConecao(4);
        potes[2].addConecao(5);
        potes[3].addConecao(2);
        potes[3].addConecao(9);
        potes[4].addConecao(2);
        potes[4].addConecao(9);
        potes[4].addConecao(10);
        potes[5].addConecao(2);
        potes[5].addConecao(6);
        potes[6].addConecao(5);
        potes[6].addConecao(7);
        potes[6].addConecao(8);
        potes[7].addConecao(6);
        potes[8].addConecao(6);
        potes[9].addConecao(3);
        potes[9].addConecao(4);
        potes[9].addConecao(15);
        potes[9].addConecao(18);
        potes[10].addConecao(4);
        potes[10].addConecao(12);
        potes[11].addConecao(12);
        potes[11].addConecao(14);
        potes[11].addConecao(17);
        potes[12].addConecao(10);
        potes[12].addConecao(11);
        potes[12].addConecao(13);
        potes[13].addConecao(12);
        potes[14].addConecao(11);
        potes[14].addConecao(16);
        potes[15].addConecao(1);
        potes[15].addConecao(9);
        potes[16].addConecao(14);
        potes[16].addConecao(18);
        potes[16].addConecao(19);
        potes[16].addConecao(20);
        potes[17].addConecao(11);
        potes[17].addConecao(16);
        potes[18].addConecao(9);
        potes[18].addConecao(16);
        potes[18].addConecao(19);
        potes[19].addConecao(18);
        potes[19].addConecao(20);
        potes[20].addConecao(16);
        potes[20].addConecao(19);

    }

    public static Bosque getInstance() {
        if (instance == null) {
            instance = new Bosque();
        }
        return instance;
    }

    public synchronized void entrar(Cachorro dog) {
        dog.setPoteAtual(1);
    }

    /**
     *
     * @param pote Which pot the dog is coming from
     * @return Return where the dog is going to.
     */
    public int trocarDePote(int pote) {
        return potes[pote].trocarDePote();
    }

    public void sair(Cachorro c) {
        /*Chamada pelo cachorro quando atinge o limite de moedas ou quando
        seu dono chegou a 50, deve encerrar a thread do cachorro e dar as 
        moedas para seu dono, ou chamar um método que faça isso
        */
        c.setPoteAtual(0);
        
    }

    /**
     * Coloca uma moeda em cada pote vazio e acorda todos os cachorros que
     * estiverem dormindo naquele pote.
     *
     * É chamado pelo salva-vidas (cachorro vermelho) a cada .2 segundos.
     */
    public void colocarMoedas() {
        for (Pote p : potes) {
            if (p.getMoedas() == 0) {
                p.colocarMoeda();
            }
        }
    }

    /**
     *
     * @param pote indicates which pot the dog is trying to take coins from
     * @param limite indicates how many more coins the dog can carry
     *
     * @return how many coins the dog took from the pot
     */
    public int pegarMoedas(Cachorro c, int pote, int limite) {
        return potes[pote].pegarMoedas(c, limite);
    }
    
    public void comecarRefil(){
        cachorroVermelho.start();
    }
}
