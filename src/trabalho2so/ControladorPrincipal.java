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
	private boolean continuar = true;

    private ControladorPrincipal() {
        this.bosque = Bosque.getInstance();
        this.cacadores = new Cacador[3];
        cacadores[0] = new Cacador(Cor.Azul);
        cacadores[1] = new Cacador(Cor.Amarelo);
        cacadores[2] = new Cacador(Cor.Verde);
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
    }

    public Bosque getBosque() {
        return bosque;
    }

    public void matarThreads() {
    	this.continuar = false;
    	Tela.getInstance().mostraPlacar(cacadores);
    }
    
    public Cacador[] getCacadores() {
        return cacadores;
    }

	public boolean deveContinuar() {
		return this.continuar;
	}
}
