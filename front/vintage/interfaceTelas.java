package front.vintage;

import java.util.Scanner;

import console.Ferramentas;

public class interfaceTelas {
    Ferramentas f = new Ferramentas();
    Scanner sc = new Scanner(System.in);

    public String boasVindas() {
        String s = "";
        f.limpaConsole();
        s += ("╔═══════════════════════════════════════════════════════════════════════════╗\n");
        s += ("║                                                                           ║\n");
        s += ("║                     SEJA BEM VINDO AO JOGO FINANCEIRO                     ║\n");
        s += ("║                                                                           ║\n");
        s += ("║                                                                           ║\n");
        s += ("║       O objetivo do jogo é FATURAR e ganhar $$                            ║\n");
        s += ("║       para isso, voce recebera um salario mensal e poderá                 ║\n");
        s += ("║       usar esse recurso para aplicar financeiramente ou                   ║\n");
        s += ("║       adquirir bens e produtos                                            ║\n");
        s += ("║                                                                           ║\n");
        s += ("║       No inicio voçê nao terá despesas, mas a quanto atingir              ║\n");
        s += ("║       uma fase no jogo, seus problemas iniciarao, e terá alguns           ║\n");
        s += ("║       problemas financeiros comuns do cotidiano!                          ║\n");
        s += ("║                                                                           ║\n");
        s += ("║       Fique atento as dicas que aparecem na tela, aos rendimmentos        ║\n");
        s += ("║       de seus bens e aplicações.                                          ║\n");
        s += ("║                                                                           ║\n");
        s += ("║       Faças as contas direito para nao perder $$  nem ter que             ║\n");
        s += ("║       emprestar no mercado negro                                          ║\n");
        s += ("║                                                                           ║\n");
        s += ("║       Para jogar voce deve criar uma conta:                               ║\n");
        s += ("║                                                                           ║\n");
        s += ("║                                                                           ║\n");
        s += ("╠═══════════════════════════════════════════════════════════════════════════╣\n");
        s += ("║                            QUAL O SEU NOME?                               ║\n");
        s += ("╚═══════════════════════════════════════════════════════════════════════════╝");
        System.out.println(s);
        return sc.nextLine();

    }

    public String opcoes() {
        String s = "";
        f.limpaConsole();
        s += ("╔═════════════════════════════════════╦═════════════════════════════════════╗\n");
        s += ("║                                     ║                                     ║\n");
        s += ("╠═════════════════════════════════════╩═════════════════════════════════════╣\n");
        s += ("║         LISTA DE OPÇOES:            ║                                     ║\n");
        s += ("║                                     ║                                     ║\n");
        s += ("║ Opção 1 - Verificar extrato da conta║                                     ║\n");
        s += ("║ Opção 2 - Aplicar Dinheiro          ║                                     ║\n");
        s += ("║ Opção 3 - Comprar Bens              ║                                     ║\n");
        s += ("║                                     ║                                     ║\n");
        s += ("║                                     ║                                     ║\n");
        s += ("║                                     ║                                     ║\n");
        s += ("║                                     ║                                     ║\n");
        s += ("║                                     ║                                     ║\n");
        s += ("║                                     ║                                     ║\n");
        s += ("║                                     ║                                     ║\n");
        s += ("║                                     ║                                     ║\n");
        s += ("║                                     ║                                     ║\n");
        s += ("║                                     ║                                     ║\n");
        s += ("║                                     ║                                     ║\n");
        s += ("║ Opção 9 - Listar as contas          ║                                     ║\n");
        s += ("║ Opção 0 - Sair do programa          ║                                     ║\n");
        s += ("║                                     ║                                     ║\n");
        s += ("║                                     ║                                     ║\n");
        s += ("╠═════════════════════════════════════╩═════════════════════════════════════╣\n");
        s += ("║                            ESCOLHA UMA OPÇÃO:                             ║\n");
        s += ("╚═══════════════════════════════════════════════════════════════════════════╝\n");

        return s;
    }

}
