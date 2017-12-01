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
    private final Bosque bosque;
    private final Cacador cacadores[];
    private Tela tela;

    private ControladorPrincipal() {
        this.bosque = Bosque.getInstance();
        this.cacadores = new Cacador[3];
        cacadores[1] = new Cacador(Cor.Azul);
        cacadores[2] = new Cacador(Cor.Amarelo);
        cacadores[3] = new Cacador(Cor.Verde);
    }

    public static ControladorPrincipal getInstance() {
        if (instance == null) {
            instance = new ControladorPrincipal();
        }
        return instance;
    }

    public void soltarOsCachorros() {
        cacadores[0].soltarCachorro();
        cacadores[1].soltarCachorro();
        cacadores[2].soltarCachorro();
        
        bosque.comecarRefil();
        //Falta ver qual das sequencias de threads acima acaba primeiro
        //e encerrar todas as outras
        
        
//        if(){
//            
//        }
        
        tela.mostraPlacar(cacadores);
    }

    public Bosque getBosque() {
        return bosque;
    }

    public Cacador[] getCacadores() {
        return cacadores;
    }
}
