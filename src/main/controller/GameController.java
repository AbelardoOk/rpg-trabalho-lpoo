package src.main.controller;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
//
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorAutoCloseTrigger;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorDeviceConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorColorConfiguration;
import java.awt.Font;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
//
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;
import com.googlecode.lanterna.screen.TerminalScreen;

import src.main.model.Entidade.Personagem.Personagem;
import src.main.model.Item.pocao.PocaoCura;
import src.main.model.Entidade.Monstro.Monstro;
import src.main.view.*;

public class GameController {
    public enum GameState {
        MAIN_MENU,
        CHARACTER,
        PATH_CHOICE,
        ITEM_ROOM,
        IN_BATTLE,
        GAME_OVER
    }

    private Screen screen;
	private TextGraphics tg;
    private SwingTerminalFrame terminal;
	private Personagem heroi;
	private int level=1;
	private int maior_nivel=0;
	private String nome_melhor;
    private boolean batalhou=false;

    private MenuController menuController;
    private PathController pathController;
    private BattleController battleController; 
    private GameOverController gameoverController; 
    private CharacterController characterController; 
    private ItemRoomController itemroomController;
    
    private BattleScreen battleScreen; 
    private MenuScreen menuScreen;
    private GameOverScreen gameoverScreen;
    private PathBattleScreen pathbattleScreen;
    private PathScreen pathScreen;
    private InventoryScreen inventoryScreen;
    private CharacterScreen characterScreen;
    private ItemRoomScreen itemroomScreen;

    private GameState currentState;

    public GameController() throws java.io.IOException {
        ///
        TerminalSize initialSize = new TerminalSize(120, 30);    

        TerminalEmulatorDeviceConfiguration deviceConfig = TerminalEmulatorDeviceConfiguration.getDefault();
        Font awtFont = new Font("Monospaced", Font.PLAIN, 18);
        SwingTerminalFontConfiguration fontConfig = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, awtFont);

        TerminalEmulatorColorConfiguration colorConfig = TerminalEmulatorColorConfiguration.getDefault();

        this.terminal = new SwingTerminalFrame(
            "Meu Jogo",                                         
            initialSize,                                        
            deviceConfig,                                       
            fontConfig,                                         
            colorConfig,                                        
            TerminalEmulatorAutoCloseTrigger.CloseOnEscape 
        );
        this.terminal.setVisible(true);
        ///
        this.screen = new TerminalScreen(this.terminal);
        this.screen.startScreen();
        this.tg = this.screen.newTextGraphics();

        this.battleScreen = new BattleScreen();
        this.menuScreen = new MenuScreen();
        this.gameoverScreen = new GameOverScreen();
        this.pathbattleScreen = new PathBattleScreen();
        this.pathScreen = new PathScreen();
        this.inventoryScreen = new InventoryScreen();
        this.characterScreen = new CharacterScreen();
        this.itemroomScreen = new ItemRoomScreen();
 
        this.currentState = GameState.MAIN_MENU; 
    }

    public void run() throws java.io.IOException  {
        Monstro inimigo = new Monstro("teste", 1);

        while(level < 100) {
            switch (this.currentState) {
                case IN_BATTLE:
                    battleController = new BattleController(screen, tg, battleScreen, inventoryScreen, heroi, inimigo, terminal, level);
                    boolean heroiVenceu = battleController.run();

                    if (heroiVenceu) {
                        batalhou = true;
                        this.currentState = GameState.PATH_CHOICE;
                    } else {
                        this.currentState = GameState.GAME_OVER;
                    }
                    
                    level ++;
                    break;
                case MAIN_MENU:
                    menuController = new MenuController(screen, tg, menuScreen, terminal);
                    boolean iniciar = menuController.run();

                    if (iniciar) {this.currentState = GameState.CHARACTER;}
                    
                    break;
                
                case CHARACTER:
                    characterController = new CharacterController(screen, tg, characterScreen, terminal);
                    String nome = characterController.run();
                    
                    this.heroi = new Personagem(nome);
                    heroi.setPocoes(new PocaoCura(heroi.getNivel()));

                    this.currentState = GameState.PATH_CHOICE;

                case PATH_CHOICE:
                    if (batalhou) {  //Mensagem de Vitória
                        pathController = new PathController(screen, tg, null, pathbattleScreen, heroi, terminal); 
                        batalhou = false;
                    }
                    else { //Sem mensagem adicional
                        pathController = new PathController(screen, tg, pathScreen, null, heroi, terminal);
                    }
                    String path_escolhido = pathController.run();

                    if (path_escolhido.equals("IN_BATTLE")) {
                        this.currentState = GameState.IN_BATTLE;
                        if(level % 3 == 0){
                            inimigo = new Monstro("MONSTRAO",(level+2));
                        }else{
                            inimigo = new Monstro("monstrim",level);
                        }
                    }
                    else if (path_escolhido.equals("ITEM_ROOM")) {
                        this.currentState = GameState.ITEM_ROOM;
                    } 
                    else if (path_escolhido.equals("IN_BATTLE")) {} // Pra sala especial
                    

                    break;

                case ITEM_ROOM:
                    itemroomController = new ItemRoomController(screen, tg, inventoryScreen, itemroomScreen, heroi, inimigo, terminal, level);
                    itemroomController.run();

                    this.currentState = GameState.PATH_CHOICE;

                    break;

                case GAME_OVER:
                    if (level > maior_nivel) {
                        maior_nivel = level;
                        nome_melhor = heroi.getNome();
                    }

                    gameoverController = new GameOverController(screen, tg, gameoverScreen, terminal, maior_nivel, nome_melhor);
                    int num = gameoverController.run();
                    if (num == 1) {
                        level = 1;
                        this.currentState = GameState.MAIN_MENU;
                    }
                    break;
            }
		}
		this.screen.stopScreen();
        
        if (heroi.estaVivo()) {
            System.out.println("Voce Venceu!");
        } else {
            System.out.println("Fim.");
        }

    }

    public static void main(String[] args) throws java.io.IOException {
        System.setProperty("java.awt.headless", "false");
        GameController game = new GameController();
        game.run();
    }
}
