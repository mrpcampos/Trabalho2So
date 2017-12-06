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
    private final Cachorro cachorros[];
    private int moedas;
    private final Cor cor;

    private boolean cachorroDescancado;


    public Cacador(Cor cor) {
        this.moedas=0;
        this.cor=cor;
        this.cachorros = new Cachorro[2];
        cachorroDescancado=true;
        for (int i = 0; i < cachorros.length; i++) {
            cachorros[i] = new Cachorro(this);
        }
    }

    public int getMoedas() {
        return moedas;
    }

    public Cor getCor() {
        return cor;
    }

    public void addMoedas(int moedas) {
        this.moedas += moedas;
        Tela.getInstance().cacadorRecebeMoedas(this, moedas);
        atualizaCachorros();
        if(this.moedas < 50){
            soltarCachorro();
        } else {
        	ControladorPrincipal.getInstance().matarThreads();
        }
    }

    void soltarCachorro() {
        if(cachorroDescancado){
        	cachorros[0].start();
            cachorroDescancado=false;
        }else{
        	cachorros[0].start();
            cachorroDescancado=true;
        }
    }
    

    private void atualizaCachorros() {
        for(Cachorro c : cachorros){
            c.setMoedasComDono(moedas);
        }
    }

}
