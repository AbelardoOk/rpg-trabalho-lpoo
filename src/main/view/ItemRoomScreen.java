package src.main.view;

import java.util.ArrayList;

import com.googlecode.lanterna.graphics.TextGraphics;

import src.main.model.Entidade.Personagem.Personagem;
import src.main.model.Item.pocao.*;

public class ItemRoomScreen {

    public void draw(TextGraphics tg, Personagem heroi, ArrayList<Pocao> Itens, int OpcaoSelecionada, int cheio) {
        tg.putString(16, 3, "== SALA DE ITENS ==");


        tg.putString(5, 11, "== AÇÕES (Enter para pegar)==");
        if (cheio == 1) {
            tg.putString(20, 11, "## INVENTÁRIO CHEIO ##");
        }
        int j=12;
        for (int i=0; i<Itens.size(); i++) {
            tg.putString(5, j, (OpcaoSelecionada == i ? ">" : " ") + " " + Itens.get(i));
            j++;
        }
        tg.putString(5, j+1, (OpcaoSelecionada == Itens.size() ? ">" : " ") + " Inventário");
        tg.putString(5, j+2, (OpcaoSelecionada == Itens.size()+1 ? ">" : " ") + " Sair");
        
    }   
}


