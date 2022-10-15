package front.javax;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import console.Global;

public class Principal extends JFrame implements ActionListener, FacInterface {

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();

	// Declara Componentes
	JButton bt1, bt2, bt3;
	JLabel donoConta;
	JTextArea text = new JTextArea();

	Principal() {

		setSize(800, 600);
		setLayout(null);
		setVisible(true);
		setTitle(Global.TITULO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		// cria os componentes
		donoConta = new JLabel(Global.USUARIO);

		bt1 = new JButton("Comprar um casa");
		bt2 = new JButton("Vender uma casa");
		bt3 = new JButton("Investir em ações");
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);

		// Border lineBorder = BorderFactory.createLineBorder(Color.green);
		// Adiciona valores as propriedades da area de texto
		donoConta.setFont(new Font("Serif", Font.BOLD, 30));
		donoConta.setAlignmentX(3);

		panel1.setLayout(new FlowLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("Investidor"));
		panel1.setBounds(0, 0, 400, 80);
		panel1.add(donoConta);
		panel1.setBackground(Color.WHITE);

		// panel2.setLayout(new BorderLayout());
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		panel2.setBorder(BorderFactory.createTitledBorder("Saldo da Conta"));
		panel2.setBounds(401, 0, 380, 80);
		panel2.setBackground(Color.WHITE);

		// panel3.setLayout( new FlowLayout(FlowLayout.LEFT));
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
		panel3.setBorder(BorderFactory.createTitledBorder("Conjunto de Opções"));
		panel3.setBounds(0, 82, 400, 400);
		panel3.setBackground(Color.WHITE);

		panel4.setLayout(new BorderLayout());
		panel4.setBorder(BorderFactory.createTitledBorder("Aplicações"));
		panel4.setBounds(401, 82, 380, 200);
		panel4.setBackground(Color.WHITE);

		panel5.setLayout(new BorderLayout());
		panel5.setBorder(BorderFactory.createTitledBorder("Bens"));
		panel5.setBounds(401, 282, 380, 200);
		panel5.setBackground(Color.WHITE);

		panel6.setLayout(new BorderLayout());
		panel6.setBorder(BorderFactory.createTitledBorder("Mensagem"));
		panel6.setBounds(0, 480, 780, 80);
		panel6.setBackground(Color.WHITE);

		panel3.add(bt1);
		panel3.add(bt2);
		panel3.add(bt3);
		
		donoConta.setAlignmentX(Component.CENTER_ALIGNMENT);

		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);

		panel6.add(text, BorderLayout.CENTER);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
