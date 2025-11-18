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
import src.main.model.Entidade.Monstro.Monstro;
import src.main.view.*;

public class GameController {
    public enum GameState {
        MAIN_MENU,
        PATH_CHOICE,
        IN_BATTLE,
        GAME_OVER
    }

    private Screen screen;
	private TextGraphics tg;
    private SwingTerminalFrame terminal;
	private Personagem heroi;
	private int level=1;

    private MenuController menuController;
    //private PathController pathController;
    private BattleController battleController; 
    private GameOverController gameoverController; 
    
    private BattleScreen battleScreen; 
    private MenuScreen menuScreen;
    private GameOverScreen gameoverScreen;

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
        
        //Temporário
        this.heroi = new Personagem("Antonio", 100, 10, 1, 1, 1);
 
        this.currentState = GameState.MAIN_MENU; 
    }

    public void run() throws java.io.IOException  {
        while(level < 100) {
            Monstro inimigo = new Monstro("Monstro", level);
            System.out.println("AQui  " + level);

            switch (this.currentState) {
                case IN_BATTLE:
                    battleController = new BattleController(screen, tg, battleScreen, heroi, inimigo, terminal);
                    boolean heroiVenceu = battleController.run();

                    System.out.println(heroiVenceu);
                    if (heroiVenceu) {
                        this.currentState = GameState.IN_BATTLE;
                    } else {
                        this.currentState = GameState.GAME_OVER;
                    }
                    
                    break;
                case MAIN_MENU:
                    menuController = new MenuController(screen, tg, menuScreen, terminal);
                    boolean iniciar = menuController.run();

                    if (iniciar) {this.currentState = GameState.IN_BATTLE;}
                    
                    break;

                case PATH_CHOICE:
                    break;

                case GAME_OVER:
                    System.out.println("Chego aqui");
                    gameoverController = new GameOverController(screen, tg, gameoverScreen, terminal);
                    gameoverController.run();
                    break;
            }
            level ++;
		}
		this.screen.stopScreen();
        
        if (heroi.estaVivo()) {
            System.out.println("Voce Venceu!");
        } else {
            System.out.println("Cabo.");
        }

    }

    public static void main(String[] args) throws java.io.IOException {
        System.setProperty("java.awt.headless", "false");
        GameController game = new GameController();
        game.run();
    }
}
