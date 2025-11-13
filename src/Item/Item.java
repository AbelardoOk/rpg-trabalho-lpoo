package src.Item;

public class Item {
  private String nome;

  public void setNome(String nome) { this.nome = nome; }
  public String getNome() { return this.nome; }

  @Override 
    public String toString() {
        return "Item: " + this.nome+"\n";
    }
}
