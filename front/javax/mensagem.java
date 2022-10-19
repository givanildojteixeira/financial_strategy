package front.javax;

import javax.swing.*;

import console.Global;

import java.awt.*;
import java.awt.event.*;

public class mensagem extends JDialog implements ActionListener, FacInterface {
    JButton btAvanco;
    JLabel msgTitulo, msgSubtitulo, background ;
    JPanel panel = new JPanel();
    public mensagem() {

        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle(Global.TITULO);
        setModal(true);

        panel.setBounds(0, 0, 800, 400);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        msgTitulo = new JLabel();
		msgTitulo.setBounds(350, 0, 400, 100);
		msgTitulo.setFont(new Font("Serif", Font.BOLD, 60));
        
        if (Global.MSGOK == true) {
            background = new JLabel(new ImageIcon("resources/imagens/ok.jpg"));
            msgTitulo.setForeground(Color.GREEN);
            msgTitulo.setText("Parabéns!!!");
        } else {
            background = new JLabel(new ImageIcon("resources/imagens/no_ok.jpg"));
            msgTitulo.setForeground(Color.RED);
            msgTitulo.setText("Hoo não!!!");
        }
        background.setBounds(0, 80, 250, 200);


        msgSubtitulo = new JLabel();
		msgSubtitulo.setBounds(290, 70, 700, 100);
		msgSubtitulo.setFont(new Font("Serif", Font.BOLD, 20));
		msgSubtitulo.setText(Global.MSG);
		// msgSubtitulo.setForeground(Color.BLUE);

        add(panel);
		panel.add(msgTitulo);
        panel.add(msgSubtitulo);
        panel.add(background);


        btAvanco = new JButton("Fechar");
        btAvanco.setBounds(350, 300, 100, 35);
        panel.add(btAvanco);
        btAvanco.addActionListener(this);

        repaint();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btAvanco)
            this.dispose();

    }
}
