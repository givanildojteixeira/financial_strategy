package front.javax;

import javax.swing.*;

import console.Global;

import java.awt.*;
import java.awt.event.*;

public class regra2 extends JFrame implements ActionListener, FacInterface {
    JButton btAvanco;
    JButton btRetrocesso;

    public regra2() {

        setSize(680, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Global.TITULO);

        JLabel background = new JLabel(new ImageIcon("resources/imagens/Regra2.jpg"));

        add(background);
        background.setLayout(new FlowLayout());

        btRetrocesso = new JButton("<== Retornar");
        background.add(btRetrocesso);
        btRetrocesso.addActionListener(this);
        
        btAvanco = new JButton("Avançar =>");
        background.add(btAvanco);
        btAvanco.addActionListener(this);

        setVisible(true);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btAvanco)
            FactoryMethodInterface.getModel("Regra3");
        if (e.getSource() == btRetrocesso)
            FactoryMethodInterface.getModel("Regra1");
        this.dispose();
        repaint();
    }
}
