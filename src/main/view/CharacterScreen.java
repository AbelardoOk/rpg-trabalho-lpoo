package src.main.view;

import com.googlecode.lanterna.graphics.TextGraphics;

public class CharacterScreen {
    
    public void draw(TextGraphics tg, String nomeAtual) {
        // Título da Tela
        tg.putString(10, 3, "== CRIAÇÃO DE PERSONAGEM ==");
        
        // Instruções
        tg.putString(5, 5, "BEM-VINDO, HERÓI! DIGITE SEU NOME PARA INICIAR A AVENTURA.");
        
        // Rótulo de Entrada
        tg.putString(5, 7, "SEU NOME : ");
        
        // O Nome Sendo Digitado
        // Desenha o nome atual na tela (após o rótulo)
        tg.putString(16, 7, nomeAtual); 
        
        // Mensagem de Confirmação
        tg.putString(5, 9, "APERTE ENTER PARA CONFIRMAR O NOME.");
    }
}