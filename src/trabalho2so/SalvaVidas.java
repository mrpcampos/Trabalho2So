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
public class SalvaVidas implements Runnable {

    public void colocarMoedas() {

    }

    @Override
    public void run() {
        boolean ever = true;
        for (;ever;) {
            try {
                wait(200);
            } catch (InterruptedException e) {
                return;
            }
            Bosque.getInstance().colocarMoedas();
        }
    }
}
