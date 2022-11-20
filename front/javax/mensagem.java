package front.javax;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class mensagem extends JDialog implements ActionListener, FacInterface {
    JButton btAvanco;
    JLabel msgTitulo, msgSubtitulo, msgSubtitulo2, background;
    JPanel panel = new JPanel();
    JLabel ben = new JLabel();

    public mensagem(boolean ok, String titulo, String msTitulo, String mensagem, String comentario,
            String nomeDoBemImagem) {

        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle(titulo);
        setModal(true);

        panel.setBounds(0, 0, 800, 400);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        msgTitulo = new JLabel();
        msgTitulo.setBounds(350, 0, 400, 100);
        msgTitulo.setFont(new Font("Serif", Font.BOLD, 60));

        if (ok == true) {
            background = new JLabel(new ImageIcon("resources/imagens/ok.jpg"));
            msgTitulo.setForeground(Color.GREEN);
            msgTitulo.setText(msTitulo);
        } else {
            background = new JLabel(new ImageIcon("resources/imagens/no_ok.jpg"));
            msgTitulo.setForeground(Color.RED);
            msgTitulo.setText("Hoo não!!!");
        }
        background.setBounds(0, 80, 250, 200);
        if (!nomeDoBemImagem.equals("")) {
            ben = new JLabel(new ImageIcon("resources/imagens/" + nomeDoBemImagem + ".jpg"));
            ben.setBounds(400, 90, 200, 200);
        }

        msgSubtitulo = new JLabel();
        msgSubtitulo.setBounds(290, 70, 700, 100);
        msgSubtitulo.setFont(new Font("Serif", Font.BOLD, 20));
        msgSubtitulo.setText(mensagem);

        msgSubtitulo2 = new JLabel();
        msgSubtitulo2.setBounds(290, 200, 700, 100);
        msgSubtitulo2.setFont(new Font("Serif", Font.BOLD, 20));
        msgSubtitulo2.setText(comentario);

        add(panel);
        panel.add(msgTitulo);
        panel.add(msgSubtitulo);
        panel.add(msgSubtitulo2);
        panel.add(background);
        panel.add(ben);

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
