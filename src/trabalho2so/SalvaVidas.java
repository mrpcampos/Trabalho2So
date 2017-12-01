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
public class SalvaVidas extends Thread{

    public void colocarMoedas() {
        Bosque.getInstance().colocarMoedas();
    }

    @Override
    public void run() {
        boolean ever = true;
        for (;ever;) {
            colocarMoedas();
        }
    }
}
