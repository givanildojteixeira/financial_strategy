package front.javax;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Abertura extends JFrame implements ActionListener, FacInterface {

    JButton btPlay;
    JButton btRegras;
    JButton btCreditos;
    JPanel painel = new JPanel();

    public Abertura() {

        setSize(680, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        JLabel background = new JLabel(new ImageIcon("resources/imagens/financial.jpg"));
        add(background);

        background.setLayout(new FlowLayout());

        btPlay = new JButton("Jogar");
        // background.setBounds(0, 0, 100, 25);
        background.add(btPlay);
        btPlay.addActionListener(this);

        btRegras = new JButton("Regras");
        // btRegras.setBounds(175, 175, 100, 25);
        background.add(btRegras);
        btRegras.addActionListener(this);

        btCreditos = new JButton("Créditos");
        // btCreditos.setBounds(175, 0, 100, 25);
        background.add(btCreditos);
        btCreditos.addActionListener(this);

        setVisible(true);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btPlay)
            FactoryMethodInterface.getModel("Principal");
        if (e.getSource() == btRegras)
            FactoryMethodInterface.getModel("Regra1");
        if (e.getSource() == btCreditos)
            FactoryMethodInterface.getModel("Creditos");
        this.dispose();
        repaint();
    }
}