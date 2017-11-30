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
public class ControladorPrincipal {
    private static ControladorPrincipal instance;
    private Bosque bosque;
    private Cacador cacadores[];

    private ControladorPrincipal() {
        this.bosque = Bosque.getInstance();
        this.cacadores = new Cacador[3];
        cacadores[1]=new Cacador(Cor.Azul);
        cacadores[2]=new Cacador(Cor.Amarelo);
        cacadores[3]=new Cacador(Cor.Verde);
    }
    
    public static ControladorPrincipal getInstance(){
        if(instance==null){
            instance = new ControladorPrincipal();
        }
        return instance;
    }

    public void soltarOsCachorros() {
        for(Cacador c : cacadores){
            c.soltarCachorro();
        }
    }

    public Bosque getBosque() {
        return bosque;
    }

    public Cacador[] getCacadores() {
        return cacadores;
    }
    
    
}
