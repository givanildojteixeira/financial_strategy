package front.javax;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import console.Ferramentas;
import console.Global;
import dominio.Operacoes;

public class Principal extends JFrame implements ActionListener, FacInterface, MouseListener {

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();

	Operacoes o = new Operacoes();
	Ferramentas f = new Ferramentas();

	// Declara Componentes
	JButton bt1, bt2, bt3;
	JLabel investidor, saldo, limite, sub1, sub2;
	JTextArea text = new JTextArea();
	JLabel casa = new JLabel(new ImageIcon("resources/imagens/Casa.jpg"));
	JLabel apartamento = new JLabel(new ImageIcon("resources/imagens/Apartamento.jpg"));
	JLabel comercio = new JLabel(new ImageIcon("resources/imagens/Comercio.jpg"));
	JLabel fazenda = new JLabel(new ImageIcon("resources/imagens/Fazenda.jpg"));
	JLabel acoes = new JLabel(new ImageIcon("resources/imagens/Acoes.jpg"));
	JLabel fimob = new JLabel(new ImageIcon("resources/imagens/FundoImobiliario.jpg"));
	JLabel frenda = new JLabel(new ImageIcon("resources/imagens/FundoRendaFixa.jpg"));
	JLabel poupan = new JLabel(new ImageIcon("resources/imagens/Poupanca.jpg"));


	JLabel logo = new JLabel(new ImageIcon("resources/imagens/MiniLogo.jpg"));

	Principal() {

		setSize(800, 600);
		setLayout(null);
		setVisible(true);
		setTitle(Global.TITULO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		// cria os componentes
		investidor = new JLabel(Global.USUARIO);
		saldo = new JLabel();
		saldo.setText("Saldo R$ " + String.format("%.2f", Global.SALDO));
		limite = new JLabel();
		limite.setText(" |  Limite R$ " + String.format("%.2f", Global.LIMITE));

		investidor.setFont(new Font("Serif", Font.BOLD, 30));
		investidor.setAlignmentX(3);
		saldo.setFont(new Font("Serif", Font.BOLD, 20));
		saldo.setAlignmentX(3);
		limite.setFont(new Font("Serif", Font.BOLD, 20));
		limite.setAlignmentX(3);
		sub1 = new JLabel("Bens de Patrimonio");
		sub1.setFont(new Font("Serif", Font.BOLD, 20));
		sub2 = new JLabel("Aplicações");
		sub2.setFont(new Font("Serif", Font.BOLD, 20));
		// bt1 = new JButton("Comprar um casa");
		// bt1.addActionListener(this);

		casa.addMouseListener(this);
		casa.setToolTipText("Casa: " +
				"Compra R$" + f.cMB(o.valorCompraBem("Casa")) +
				" Venda R$" + f.cMB(o.valorVendaBem("Casa")));

		apartamento.addMouseListener(this);
		apartamento.setToolTipText("Apartamento: " +
				"Compra R$" + f.cMB(o.valorCompraBem("Apartamento")) +
				" Venda R$" + f.cMB(o.valorVendaBem("Apartamento")));

		comercio.addMouseListener(this);
		comercio.setToolTipText("Comercio: " +
				"Compra R$" + f.cMB(o.valorCompraBem("Comercio")) +
				" Venda R$" + f.cMB(o.valorVendaBem("Comercio")));

		fazenda.addMouseListener(this);
		fazenda.setToolTipText("Fazenda: " +
				"Compra R$" + f.cMB(o.valorCompraBem("Fazenda")) +
				" Venda R$" + f.cMB(o.valorVendaBem("Fazenda")));

		panel1.setLayout(new FlowLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("Investidor"));
		panel1.setBounds(0, 0, 400, 80);
		panel1.add(investidor);
		panel1.setBackground(Color.WHITE);

		// panel2.setLayout(new BorderLayout());
		// panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		panel2.setBorder(BorderFactory.createTitledBorder("Saldo da Conta"));
		panel2.setBounds(401, 0, 380, 80);
		panel2.setBackground(Color.WHITE);
		panel2.add(saldo);
		panel2.add(limite);

		panel3.setLayout(null);
		panel3.setBorder(BorderFactory.createTitledBorder("Negociações"));
		panel3.setBounds(0, 82, 400, 400);
		panel3.setBackground(Color.WHITE);
		casa.setBounds(0, 40, 100, 100);
		apartamento.setBounds(90, 40, 100, 100);
		comercio.setBounds(175, 40, 100, 100);
		fazenda.setBounds(285, 40, 100, 100);
		sub1.setBounds(120,15, 300,25);
		sub2.setBounds(160,150, 300,25);
		acoes.setBounds(0, 180, 100, 100);
		fimob.setBounds(101, 180, 100, 100);
		frenda.setBounds(200, 180, 100, 100);
		poupan.setBounds(285, 180, 100, 100);





		panel3.add(sub1);
		panel3.add(sub2);
		panel3.add(casa);
		panel3.add(apartamento);
		panel3.add(comercio);
		panel3.add(fazenda);
		panel3.add(acoes);
		panel3.add(fimob);
		panel3.add(frenda);
		panel3.add(poupan);

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
		panel6.setBounds(0, 480, 600, 80);
		panel6.setBackground(Color.WHITE);

		investidor.setAlignmentX(Component.CENTER_ALIGNMENT);
		logo.setBounds(490, 520, 400, 40);

		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
		add(logo);

		panel6.add(text, BorderLayout.CENTER);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// clique no botao, qual botao

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == casa)
			FactoryMethodInterface.getModel("Login");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// mouse pressionado

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// mouse movido

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// mouse no item

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// mouse fora do item

	}

}
