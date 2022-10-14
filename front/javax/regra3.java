package front.javax;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class regra3 extends JFrame implements ActionListener, FacInterface {
    JButton btAvanco;
    JButton btRetrocesso;

    public regra3() {

        setSize(680, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel background = new JLabel(new ImageIcon("resources/imagens/Regra3.jpg"));

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
            FactoryMethodInterface.getModel("Regra4");
        if (e.getSource() == btRetrocesso)
            FactoryMethodInterface.getModel("Regra2");
        this.dispose();
        repaint();
    }
}
