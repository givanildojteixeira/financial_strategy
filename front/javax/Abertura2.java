package front.javax;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Abertura2 extends JFrame implements ActionListener, FacInterface {

    // Declara Componentes
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JTextArea rotulo;
    JTextField texto = new JTextField();
    JButton botao = new JButton("Ok");

    public Abertura2() {

        String conteudo = "O objetivo do jogo é FATURAR e ganhar $$  \n" +
            "para isso, você recebera um salario mensal e poderá  \n" +
            "usar esse recurso para aplicar financeiramente ou  \n" +
            "adquirir bens e produtos  \n \n" +
            "No inicio voçê nao terá despesas, mas a quanto atingir  \n" +
            "uma fase no jogo, seus problemas iniciarao, e terá alguns  \n" +
            "problemas financeiros comuns do cotidiano! \n  \n" +
            "Fique atento as dicas que aparecem na tela, aos rendimmentos   \n" +
            "de seus bens e aplicações. \n \n" +
            "Faças as contas direito para nao perder $$  nem ter que   \n" +
            "emprestar no mercado negro  \n \n" +
            "Para jogar voce deve criar uma conta:";
        
            JLabel lblCpf = new JLabel("CPF");
            lblCpf.setBounds(10, 50, 120, 25);
    
            this.add(lblCpf);

        rotulo = new JTextArea(conteudo);
        rotulo.setLineWrap(true);
        rotulo.setWrapStyleWord(true);

        setSize(800, 600);
        setLayout(null);
        setTitle("Jogo Financeiro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        botao.addActionListener(this);

        // Border lineBorder = BorderFactory.createLineBorder(Color.green);
        // Adiciona valores as propriedades da area de texto
        rotulo.setFont(new Font("Serif", Font.ITALIC, 20));
        // rotulo.setAlignmentX(3);

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        panel1.setBorder(BorderFactory.createTitledBorder("Objetivo do Jogo"));
        panel1.setBounds(0, 0, 780, 500);
        panel1.add(rotulo);

        panel2.setLayout(new BorderLayout());
        panel2.setBorder(BorderFactory.createTitledBorder("Mensagem"));
        panel2.setBounds(0, 501, 780, 70);

        panel2.add(botao);

        // donoConta.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(panel1);
        add(panel2);
        setLocationRelativeTo(null);
        setVisible(true);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botao) 
            FactoryMethodInterface.getModel("teste");
            this.dispose();
        repaint();
    }

}
