/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jantarfilosofos;


public class JantarFilosofos {
    public static void main(String[] args) {
        MesaDeJantar mesa= new MesaDeJantar();
        for (int filosofo = 0; filosofo < 5; filosofo ++){
            new Filosofo("Filosofo_"+filosofo, mesa, filosofo).start();
        }
    }
    
}

class Filosofo extends Thread{
    final static int TEMPO_MAXIMO=100;
    MesaDeJantar mesa;
    int filosofo;
    
    public Filosofo(String nomeThread, MesaDeJantar mesa, int filosofo){
        super(nomeThread);
        this.mesa = mesa;
        this.filosofo = filosofo;
    }
    
    public void run(){
        int tempo=0;
        while(true){
            tempo=(int)(Math.random()*TEMPO_MAXIMO);
            pensar(tempo);
            pegarGarfos();
            tempo=(int)(Math.random()*TEMPO_MAXIMO);
            comer(tempo);
            devolverGarfos();
        }
    }
    
    private void pensar(int tempo){
        try{
            sleep(tempo);
        }catch(InterruptedException e){
            System.out.println("Filosofo pensou demais,morreu");
        }
    }
    
    private void comer(int tempo){
        try{
            sleep(tempo);
        }catch(InterruptedException e){
            System.out.println("Filosofo comeu demais,morreu");
        }
    }
    
    private void pegarGarfos(){
        mesa.pegandoGarfos(filosofo);
    }
    
    private void devolverGarfos(){
        mesa.devolvendoGarfos(filosofo);
    }
}

class MesaDeJantar{
    final static int PENSANDO = 1;
    final static int COMENDO = 2;
    final static int COM_FOME = 3;
    final static int QUANT_FILOSOFOS = 5;
    final static int PRIMEIRO_FILOSOFO = 0;
    final static int ULTIMO_FILOSOFO = QUANT_FILOSOFOS - 1;
    
    boolean [] garfos = new boolean[QUANT_FILOSOFOS];
    int[] filosofos = new int [QUANT_FILOSOFOS];
    int[] tentativasParaComer = new int[QUANT_FILOSOFOS];
    
    public MesaDeJantar(){
        for(int i=0; i<5;i++){
            garfos[i]=true;
            filosofos[i]=PENSANDO;
            tentativasParaComer[i]=0;
        }
    }
    
    synchronized void pegandoGarfos(int filosofo){
        filosofos[filosofo]=COM_FOME;
        while (filosofos[aEsquerda(filosofo)]==COMENDO || filosofos[aDireita(filosofo)]==COMENDO){
            try{
                tentativasParaComer[filosofo]++;
                wait();
            }catch(InterruptedException e){
                System.out.println("Filosofo morreu de fome");
            }
        }
        tentativasParaComer[filosofo]=0;
        garfos[garfoEsquerdo(filosofo)]=false;
        garfos[garfoDireito(filosofo)]=false;
        filosofos[filosofo]=COMENDO;
        imprimeEstadosFilosofos();
        imprimeGarfos();
        imprimeTentativasParaComer();   
    }
    
    synchronized void devolvendoGarfos(int filosofo){
        garfos[garfoEsquerdo(filosofo)]=true;
        garfos[garfoDireito(filosofo)]=true;
        if(filosofos[aEsquerda(filosofo)]==COM_FOME || filosofos[aDireita(filosofo)]==COM_FOME){
            notifyAll();
        }
        filosofos[filosofo]=PENSANDO;
        imprimeEstadosFilosofos();
        imprimeGarfos();
        imprimeTentativasParaComer();   
    }
    
    private int aDireita(int filosofo){
        int direito;
        if(filosofo==ULTIMO_FILOSOFO){
            direito= PRIMEIRO_FILOSOFO;
        }else{
            direito=filosofo+1;
        }
        return direito;
    }
    
    private int aEsquerda(int filosofo){
        int esquerdo;
        if(filosofo==PRIMEIRO_FILOSOFO){
            esquerdo= ULTIMO_FILOSOFO;
        }else{
            esquerdo=filosofo-1;
        }
        return esquerdo;
    }
    
    private int garfoEsquerdo(int filosofo){
        int garfoEsquerdo=filosofo;
        return garfoEsquerdo;
    }
    
    private int garfoDireito(int filosofo){
        int garfoDireito;
        if(filosofo == ULTIMO_FILOSOFO){
            garfoDireito=0;
        }else{
            garfoDireito=filosofo+1;
        }
        return garfoDireito;
    }
    
    private void imprimeEstadosFilosofos(){
        String texto="*";
        System.out.print("Filosofos = [");
        for(int i=0; i<QUANT_FILOSOFOS; i++){
            switch (filosofos[i]){
                case PENSANDO:
                    texto= "PENSANDO";
                    break;
                case  COM_FOME:
                    texto="COM_FOME";
                    break;
                case COMENDO:
                    texto="COMENDO";
                    break;
            }
            System.out.print(texto+" ");
        }
        System.out.println("]");
    }
    
    private void imprimeGarfos(){
        String garfo="*";
        System.out.print("Garfos   = [");
        for(int i=0; i<QUANT_FILOSOFOS;i++){
            if(garfos[i]){
                garfo="LIVRE";
            }else{
                garfo="OCUPADO";
            }
            System.out.println("]");
        }
    }
        
    private void imprimeTentativasParaComer(){
        System.out.print("Tentou comer = [");
        for(int i=0; i<QUANT_FILOSOFOS; i++){
            System.out.print(filosofos[i]+" ");
        }
        System.out.println("]");
    }
}