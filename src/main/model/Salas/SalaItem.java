package src.main.model.Salas;

import java.util.Random;

import src.main.model.Entidade.Personagem.Personagem;
import src.main.model.Item.*;

public class SalaItem extends Sala{
    Item ferramenta;
    
    Item getFerramenta(){
        return this.ferramenta;
    }
    void setFerramenta(Item ferramenta){
        this.ferramenta=ferramenta;
    }
    
    public void entrouSala(Personagem heroi){
        int op=1;
        Random gerador=new Random();
        if(gerador.nextInt(10)>5){
           setFerramenta(new PocaoCura());
        }else{
            setFerramenta(new Arma());
        }
        //informar item que a sala possui.

        //perguntar ao usuário para digitar 1 para selecionar o item e 0 para ignorar
        //ler a resposta em op;

        if(op==1){
            if(heroi.QuantidadeItens()<5){
                heroi.setItens(ferramenta);
            }else{
                //imprimir que a lista está cheia
                heroi.ImprimirItens();
                //deseja trocar? 1-sim 0-nao(le o resultado em op)
                if(op==1){
                    //dar a opção de dar o numero item q deseja trocar
                    //trocar os itens
                }
                //op 0 simplismente nao faz nada
            }
        }
        //op 0 simplismente nao faz nada
        
    }
}
