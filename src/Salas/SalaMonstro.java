package src.Salas;
import src.Entidade.Monstro.Monstro;
import src.Entidade.Personagem.Personagem;
import java.util.Scanner;

public class SalaMonstro extends Sala{

    public void entrouSala(Personagem heroi){
        /* ao entrar na sala a expercia ascrescentada caso ganhe a luta é do nível +2
        se o  nível é multiplo de 3 o nível de expericiencia é multiplicado pelo nível da dificuldade
        do monstro*/
        int experiencia= heroi.getNivel()+2;

        if(heroi.getNivel()%3==0){ experiencia*=3; }

        Monstro inimigo = new Monstro("Gollum",heroi.getNivel());

        System.out.println("\n=======================");
        System.out.println("      FASE " + heroi.getVida());
        System.out.println("=======================");

        inimigo.atacar(heroi);



        if(heroi.estaVivo()){
            System.out.println("Se você derrotar o montros irá ganhar"+ experiencia +" de experiência.");
            System.out.println("Deseja enfrentar monstro ? ");
            int opcao;
            do {
                System.out.println("Digite 0 para fugir e 1 para lutar: ");
                Scanner sc = new Scanner(System.in);
                opcao = sc.nextInt();
            }while(opcao != 0 || opcao != 1);

            if(opcao==0){
                // Heroi fugiu da batalha

            } else{
                while(inimigo.estaVivo() && heroi.estaVivo()){
                    // tres opcoes , lutar, defender-se ou usar item que estiver na lista (se houver)
                    Scanner sc = new Scanner(System.in);
                    int escolha = sc.nextInt();
                    if(escolha==1){
                        heroi.atacar(inimigo);
                        if (inimigo.estaVivo()) {
                            System.out.println(inimigo.getNome() + " Vida: "+ inimigo.getVida() + ".");
                            inimigo.atacar(heroi);
                            System.out.println(heroi.getNome() + " Vida: "+ heroi.getVida() + ".");
                        } else{
                            System.out.println(heroi.getNome() + " Vida: "+ heroi.getVida() + ".");
                            System.out.println(inimigo.getNome()+" saiu derrotado!");
                    }

                    }else if(escolha == 2){
                        heroi.defender();
                    }
                    else{
                        //Verificar itens disponíveis
                    }
                }
            }

        } else{
            System.out.println(heroi.getNome() +" está derrotado!!");
        }


        
    }
    
}
