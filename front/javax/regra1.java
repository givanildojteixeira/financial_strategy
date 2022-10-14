package front.javax;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class regra1 extends JFrame implements ActionListener, FacInterface {
    JButton btAvanco;
    JButton btRetroc;

    public regra1() {

        setSize(680, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel background = new JLabel(new ImageIcon("resources/imagens/Regra1.jpg"));

        add(background);

        background.setLayout(new FlowLayout());

        btAvanco = new JButton("Avançar =>");
        background.add(btAvanco);
        btAvanco.addActionListener(this);

        setVisible(true);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btAvanco)
            FactoryMethodInterface.getModel("Regra2");
        this.dispose();
        repaint();
    }
}
