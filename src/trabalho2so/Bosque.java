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
    static Bosque instance;
    Pote potes[];
    SalvaVidas cachorroVermelho;
    
    private Bosque(){
        potes = new Pote[20];
        for(Pote p:potes){
            //Cria cada um dos potes e fala com quem estão ligados
        }
        
    }
    
    public static Bosque getInstance(){
        if(instance==null){
            instance = new Bosque();
        }
        return instance;
    }
    
    public void entrar(){
        
    }
    
    public void trocarDePote(int pote){
        
    }
    
    public void sair(){
        /*Chamada pelo cachorro quando atinge o limite de moedas ou quando
        seu dono chegou a 50, deve encerrar a thread do cachorro e dar as 
        moedas para seu dono, ou chamar um método que faça isso
        */
    }
    
    public void colocarMoedas(int pote){
        /*Chamada pelo cachorro vermelho (ou Salva Vidas) para colocar
        uma moeda no pote indicado
        
        */
    }
    /**
     * 
     * @param pote indicates which pot the dogs trying to take coins from
     * @param limite indicates how many more coins the dog can carry
     * 
     * @return how many coins the dog took from the pot
     */
    public int pegarMoedas(int pote, int limite){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}