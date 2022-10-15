package front.javax;
import javax.swing.*;

import console.Global;

import java.awt.*;
import java.awt.event.*;

public class Creditos extends JFrame implements ActionListener, FacInterface{
    JButton btAvanco;

    public Creditos() {

        setSize(700,550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Global.TITULO);
        JLabel background=new JLabel(new ImageIcon("resources/imagens/Creditos.jpg"));
        add(background);

        background.setLayout(new FlowLayout());

        btAvanco = new JButton("Fechar");
        background.add(btAvanco);
        btAvanco.addActionListener(this);

        setVisible(true);
        repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btAvanco) 
            FactoryMethodInterface.getModel("Abertura");
            this.dispose();
        repaint();
    }
}
