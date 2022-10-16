package front.javax;

import javax.swing.*;

import console.Global;
import dominio.Operacoes;

import java.awt.Color;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener, FacInterface {
    Operacoes o = new Operacoes();

    // Declara Componentes
    JPanel panel1 = new JPanel();
    JTextArea rotulo;
    JTextField txtNome = new JTextField();
    JTextField txtPass = new JTextField();
    JButton botao = new JButton("Jogar");
    JLabel logo = new JLabel(new ImageIcon("resources/imagens/logo.jpg"));
    JLabel lblNome = new JLabel("Digite seu nome para criar uma conta: ");
    JLabel lblPro = new JLabel("Digite sua senha de Jogador Pro: ");

    public Login() {

        setSize(320, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Global.TITULO);
        setBackground(Color.WHITE);

        logo.setBounds(0, 0, 320, 50);
        lblNome.setBounds(50, 45, 320, 30);
        txtNome.setBounds(30, 70, 250, 30);
        txtNome.setAlignmentY(CENTER_ALIGNMENT);
        txtNome.setAlignmentX(CENTER_ALIGNMENT);
        lblPro.setBounds(70, 100, 200, 30);
        txtPass.setBounds(30, 130, 250, 30);
        botao.setBounds(50, 200, 200, 30);

        add(logo);
        add(lblNome);
        add(txtNome);
        add(lblPro);
        add(txtPass);
        add(botao);
        botao.addActionListener(this);
        getRootPane().setDefaultButton(botao);    //SETA O BOTAO COMO DEFAULT

        setVisible(true);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String user = "";
        if (e.getSource() == botao) {
            user = txtNome.getText();
            if (user.isEmpty()) {
                FactoryMethodInterface.getModel("login");
            } else {
                // o.CriarConta(user.toUpperCase(), "");
                // System.out.println(o.saldoDaConta());
                // System.out.println(o.limiteDaConta());
                Global.USUARIO = user.toUpperCase();
                FactoryMethodInterface.getModel("Principal");
            }
        }
        this.dispose();
        repaint();
    }

}
