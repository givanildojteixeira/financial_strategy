
package console;

import java.util.Scanner;

import bancoDados.dbPropertiesFiles.IdFiles;
import dominio.Operacoes;
import front.javax.FactoryMethodInterface;

public class Console {

    Operacoes o = new Operacoes();
    Ferramentas f = new Ferramentas();

    public void start() throws Exception {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FactoryMethodInterface.getModel("Abertura");
            }
        });
        // simulador();


    }

    public void vintage() throws Exception {
        f.limpaConsole();
        o.ConectarDB("",IdFiles.FileConfig);

        System.out.println(o.leDB("Usuario",IdFiles.FileConfig));

        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        System.out.println("## Escolha uma das opções abaixo ##");
        System.out.println("Pra jogar deve-se criar uma conta:");
        System.out.println("Qual é o seu nome?");
        String userName = sc.nextLine();
        if (userName == "") {
            System.out.println("Um nome de usuario é necessário!");
            System.exit(0);
        }
        Global.USUARIO = userName;

        if (o.leDB("Usuario",IdFiles.FileConfig).equals(userName)) {
            System.out.println("encontrei");
        } else {
            o.GravarDB("Usuario", userName,IdFiles.FileConfig);
            System.out.println("Tem senha para nivel Pro");
            String senha = sc.nextLine();
            if (senha == "contapro") {
                o.CriarConta(userName, "Pro");
            } else {
                o.CriarConta(userName, "");
            }
        }
        do {
            System.out.println("╔═══════════════════════════╦═══════════════════════════╗");
            System.out.println("║  " + userName + "                         ║                           ║");
            System.out.println("╠═══════════════════════════╩═══════════════════════════╣");
            System.out.println("║                                                       ║");
            System.out.println("║                                                       ║");
            System.out.println("║                                                       ║");
            System.out.println("║                                                       ║");
            System.out.println("╚═══════════════════════════════════════════════════════╝");
            System.out.println("## Escolha uma das opções abaixo ##");
            System.out.println("Opção 1 - Verificar extrato da conta");
            System.out.println("Opção 2 - Aplicar Dinheiro");
            System.out.println("Opção 3 - Comprar Bens");
            System.out.println("Opcao 8 - Limpar a tela");
            System.out.println("Opção 9 - Listar as contas");

            System.out.println("Opção 0 - Sair do programa");
            System.out.println("_______________________");

            System.out.print("Digite aqui sua opção: ");
            opcao = Integer.parseInt(sc.nextLine());
            switch (opcao) {
                case 9:
                    o.ListaContas();
                    break;
                case 1:
                    // o.extrato(1);

                    break;
                case 8:
                    // bloco de código que será executado
                    f.limpaConsole();
                    break;
                default:
                    // bloco de código que será executado se nenhum dos cases for aceito
            }
            System.out.println(opcao);
        } while (opcao != 0);

        sc.close();
    }

    public void simulador() throws Exception {
        o.CriarConta("Givanildo", "");
        o.CriarConta("Elisangela", "Pro");
        o.CriarConta("Lucas", "Administrador");

        o.ListaContas();
        // System.out.println(o.depositar( 100, ""));
        // System.out.println(o.depositar( 10000, ""));
        o.ListaContas();
        // o.sacar(40000, "");

        // o.depositar( 30, "descricao");
        o.ListaContas();

        // o.transferir(1, 3, 50);
        o.ListaContas();

        o.ciclo();
        o.ListaContas();
        // o.extrato(1);

        // o.PesquisaBens();

    }

}
