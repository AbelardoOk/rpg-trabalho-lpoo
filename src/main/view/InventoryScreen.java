package src.main.view;

import java.util.ArrayList;

import com.googlecode.lanterna.graphics.TextGraphics;

import src.main.model.Entidade.Personagem.Personagem;
import src.main.model.Item.pocao.*;

public class InventoryScreen {

    public void draw(TextGraphics tg, Personagem heroi, ArrayList<Pocao> Itens, int OpcaoSelecionada) {
        tg.putString(16, 3, "== INVENTÁRIO DE " + heroi.getNome() + " ==");


        tg.putString(5, 11, "== AÇÕES (Enter para usar | S para soltar | 10 itens de limite)==");
        int j=12;
        for (int i=0; i<Itens.size(); i++) {
            tg.putString(5, j, (OpcaoSelecionada == i ? ">" : " ") + " " + Itens.get(i));
            j++;
        }
        tg.putString(5, j+1, (OpcaoSelecionada == Itens.size() ? ">" : " ") + " Sair");
        
    }   
}

