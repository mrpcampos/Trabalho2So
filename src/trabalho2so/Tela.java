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
public class Tela {
    
    private static Tela instance;
    
    private Tela() {
    }
    
    public static Tela getInstance(){
    	if (instance == null) instance = new Tela();
        return instance;
    }
    
    void sout(String text, Object ...objs) {
    	System.out.println(String.format(text, objs));
    }
    
    void sout(String text) {
    	System.out.println(text);
    }
    
    public void iniciaCorrida(){
    	sout("Corrida iniciada");
    }
    
    public void cachorroEntraNoBosque(Cachorro c){
    	sout("Cachorro %s entra no bosque", c.getCor());
    }
    
    public void cachorroTrocaDePote(Cachorro c, int p){
    	sout("Cachorro %s entra no pote %d", c.getCor(), p);
    }
    
    public void cachorroDorme(Cachorro c, int p){
    	sout("Cachorro %s dorme no pote %d", c.getCor(), p);
    }
    
    public void cachorroPegaMoedas(Cachorro c, int p, int moedas){
    	sout("Cachorro %s pega %d moedas no pote %d", c.getCor(), moedas, p);
    }
    
    public void cachorroSaiDoBosque(Cachorro c){
    	sout("Cachorro %s sai do bosque", c.getCor());
    }
    
    public void salvaVidasAbastecePote(int p){
    	sout("Salva vidas abastece pote %d", p);
    }
    
    public void mostraPlacar(Cacador[] cacadores){
    	String log = "\n\n\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
    	for (Cacador cacador : cacadores) {
			log += String.format("Caçador %s coletou %d moedas\n", cacador.getCor(), cacador.getMoedas());
		}
    	sout(log);
    	System.exit(0);
    }

	public void cacadorRecebeMoedas(Cacador cacador, int moedas) {
		sout("Caçador %s recebeu %d moedas, agora tem %d", cacador.getCor(), moedas , cacador.getMoedas());
	}
    
    
    
    
}
