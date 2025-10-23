package src.Monstro;

public abstract class Monstro {
    private String nome;
    private int nivel;
    private float vida;
    private int defesa;
    private int dano;



    public String getNome(){
        return this.nome;
    }

    public int getNivel(){
        return this.nivel;
    }

    public float getVida(){
        return this.vida;
    }

    public int getDefesa(){
        return this.defesa;

    }

    public int getDano(){
        return this.dano;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public void setVida(float vida){
        this.vida = vida;
    }

    public void setDefesa(int defesa){
        this.defesa = defesa;
    }

    public void setDano(int dano){
        this.dano = dano;
    }


}
