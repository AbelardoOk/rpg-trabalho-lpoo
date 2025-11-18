package src.main.model.Item.pocao;

import src.main.model.Entidade.Entidade;

public class PocaoLetal extends Pocao{///Pocao fatal???
    
    public  void consumir(Entidade p){
        p.setVidaAtual(0);
    }
}
