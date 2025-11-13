package src.Salas;

import src.Entidade.Personagem.Personagem;

public abstract class Sala {
    private String nome;
    private int experiencia;

    void setExperiencia(int experiencia){
        this.experiencia=experiencia;
    }
    int getExperiencia(){
        return this.experiencia;
    }

    void setNome(String nome){
        this.nome=nome;
    }

    String getNome(){
        return this.nome;
    }
    public abstract void entrouSala(Personagem heroi);

    


}
