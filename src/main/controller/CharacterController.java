package src.main.controller;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import src.main.view.CharacterScreen;

import java.io.IOException;

public class CharacterController {
    private Screen screen;
    private TextGraphics tg;
    private CharacterScreen cs;
    private SwingTerminalFrame terminal;
    private StringBuilder nomeDigitado = new StringBuilder(); 
    

    public CharacterController(Screen screen, TextGraphics tg, CharacterScreen cs, SwingTerminalFrame terminal) {
        this.screen = screen;
        this.tg = tg;
        this.cs = cs;
        this.terminal = terminal;
    }

   
    public String run() throws IOException {
        
        while(true) {
        screen.clear();
        cs.draw(tg, nomeDigitado.toString());
        screen.refresh();

        KeyStroke key = screen.readInput();
        
        if (key == null) {
            continue;
        }

        switch (key.getKeyType()) {
            case Enter:
                String nomeFinal = nomeDigitado.toString().trim();
                
                if (nomeFinal.length() > 0) {
                    return nomeFinal;
                }
                break;
                
            case Backspace:
                if (nomeDigitado.length() > 0) {
                    nomeDigitado.setLength(nomeDigitado.length() - 1);
                }
                break;
                
            case Escape:
                screen.stopScreen();
                terminal.close();
                System.exit(0);
                break;

            case Character:
                break; 
                
            default:
                break;
        }
        
        if (key.getKeyType() == KeyType.Character) {
            nomeDigitado.append(Character.toUpperCase(key.getCharacter()));
        }
    }
    }
}