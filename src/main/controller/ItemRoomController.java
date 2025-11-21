package src.main.controller;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import src.main.model.Entidade.Personagem.Personagem;
import src.main.view.InventoryScreen;
import src.main.view.ItemRoomScreen;
import src.main.model.Item.pocao.*;

import java.util.ArrayList;

public class ItemRoomController {
    private Screen screen;
	private TextGraphics tg;
	private ItemRoomScreen irs;
    private InventoryScreen is;
	private Personagem heroi;
	private SwingTerminalFrame terminal;
	private int OpcaoSelecionada = 0;
	private int nivel;
    private int cheio=0;
    private int num=0;
    int TOTAL_OPCOES;
	ArrayList<Pocao> lista = new ArrayList<>();

	public ItemRoomController(Screen screen, TextGraphics tg, InventoryScreen is, ItemRoomScreen irs, Personagem heroi, SwingTerminalFrame terminal, int nivel) {
        	this.screen = screen;
        	this.tg = tg;
			this.irs = irs;
            this.is = is;
        	this.heroi = heroi;
			this.terminal = terminal;
			this.nivel = nivel;
            this.lista.add(new PocaoCura(this.nivel));
            this.lista.add(new PocaoForca());
            this.lista.add(new PocaoLetal());
    	}

    public void run() throws java.io.IOException {
        

		while(num==0) {
			screen.clear();
			irs.draw(tg, heroi, lista, OpcaoSelecionada, cheio);
			screen.refresh();

            TOTAL_OPCOES = lista.size();
			KeyStroke key = screen.readInput();
			
			if (key == null) {continue;}

            if (key.getKeyType() == KeyType.Character) {
                if (OpcaoSelecionada < lista.size()) {
                    char caractere = key.getCharacter();
                    
                    if (caractere == 's' || caractere == 'S') {
                        lista.remove(OpcaoSelecionada); 
                    }
                    if (OpcaoSelecionada >= lista.size()) {
                        OpcaoSelecionada = lista.size(); 
                    }
                }
            }

            else {
                switch (key.getKeyType()) {
                    case ArrowUp:
                        OpcaoSelecionada--;
                        if (OpcaoSelecionada < 0) {
                            OpcaoSelecionada = TOTAL_OPCOES+1; 
                        }
                        break;

                    case ArrowDown:
                        OpcaoSelecionada++;
                        if (OpcaoSelecionada > TOTAL_OPCOES+1) {
                            OpcaoSelecionada = 0;
                        }
                        break;
                    
                    case Enter:
                        num = Acao();
                        break;
                        
                    case Escape:
                        screen.stopScreen();
                        terminal.close();
                        System.exit(0);
                        break;

                    default:
                        break;
                }
            }

			
		}
        
	}

	private int Acao() throws java.io.IOException {
        if (OpcaoSelecionada < lista.size()) {       //Itens
            if (heroi.getPocoes().size() == 10) {
                cheio = 1;
            }
            else {
                heroi.setPocoes(lista.get(OpcaoSelecionada));;
                lista.remove(OpcaoSelecionada);
            }
            return 0;
		}
        else if (OpcaoSelecionada == lista.size()) { //Inventário
            InventoryController inventoryController = new InventoryController(screen, tg, is, heroi, terminal);
            ArrayList<Pocao> p = new ArrayList<>();
            p = inventoryController.run();
            heroi.setPocoes(p);

            return 0;
        }
        else if (OpcaoSelecionada == lista.size()+1){ // Sair
            return 1;
        }
        else {
            return 0;
        }
	}

}
