package front.javax;

import java.awt.BorderLayout;
import java.awt.Color;
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
	JPanel panelBen = new JPanel();

	Operacoes o = new Operacoes();
	Ferramentas f = new Ferramentas();
	// Declara Componentes
	JButton comprar, vender, investir;
	JLabel investidor, saldo, limite, patrimonio, sub1, sub2, compra, venda, despesa, receita;
	JTextArea text = new JTextArea();
	JLabel casa = new JLabel(new ImageIcon("resources/imagens/Casa.jpg"));
	JLabel apartamento = new JLabel(new ImageIcon("resources/imagens/Apartamento.jpg"));
	JLabel comercio = new JLabel(new ImageIcon("resources/imagens/Comercio.jpg"));
	JLabel fazenda = new JLabel(new ImageIcon("resources/imagens/Fazenda.jpg"));
	JLabel casaM = new JLabel(new ImageIcon("resources/imagens/Casa_m.jpg"));
	JLabel apartamentoM = new JLabel(new ImageIcon("resources/imagens/Apartamento_m.jpg"));
	JLabel comercioM = new JLabel(new ImageIcon("resources/imagens/Comercio_m.jpg"));
	JLabel fazendaM = new JLabel(new ImageIcon("resources/imagens/Fazenda_m.jpg"));
	JLabel acoes = new JLabel(new ImageIcon("resources/imagens/Acoes.jpg"));
	JLabel fimob = new JLabel(new ImageIcon("resources/imagens/FundoImobiliario.jpg"));
	JLabel frenda = new JLabel(new ImageIcon("resources/imagens/FundoRendaFixa.jpg"));
	JLabel poupan = new JLabel(new ImageIcon("resources/imagens/Poupanca.jpg"));

	JLabel logo = new JLabel(new ImageIcon("resources/imagens/MiniLogo.jpg"));
	JLabel ben = new JLabel();

	String nomedoBem = "";

	Principal() {
		// criação ou atualizaçao da conta
		o.CriarConta(Global.USUARIO, "");
		o.ConectarDB("");
		if (o.leDB("Usuario").equals(Global.USUARIO)) {
			// encontrei o nome gravado no banco, entao carrego os dados
			Double s = o.leDBValor(Global.USUARIO + "-s");
			o.gravaSaldoConta(s);
			Double l = o.leDBValor(Global.USUARIO + "-l");
			o.gravaLimiteConta(l);
		} else {
			// ops, é usuario novo, gravo os dados iniciais
			o.GravarDB("Usuario", Global.USUARIO);
			o.GravarDBValor(Global.USUARIO + "-s", o.saldoDaConta());
			o.GravarDBValor(Global.USUARIO + "-l", o.limiteDaConta());
		}

		setSize(800, 600);
		setLayout(null);
		setVisible(true);
		setTitle(Global.TITULO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		// cria os componentes

		sub1 = new JLabel("Bens de Patrimonio");
		sub1.setFont(new Font("Serif", Font.BOLD, 20));
		sub2 = new JLabel("Aplicações");
		sub2.setFont(new Font("Serif", Font.BOLD, 20));

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

		// Panel1
		panel1.setLayout(new FlowLayout());
		panel1.setBorder(BorderFactory.createTitledBorder("Investidor"));
		panel1.setBounds(0, 0, 300, 80);
		panel1.setBackground(Color.WHITE);
		investidor = new JLabel(Global.USUARIO);
		// investidor.setAlignmentX(Component.CENTER_ALIGNMENT);
		investidor.setFont(new Font("Serif", Font.BOLD, 30));
		investidor.setAlignmentX(3);
		panel1.add(investidor);

		// panel2
		panel2.setBorder(BorderFactory.createTitledBorder("Saldo da Conta"));
		panel2.setBounds(301, 0, 480, 80);
		panel2.setBackground(Color.WHITE);
		saldo = new JLabel();
		saldo.setAlignmentX(3);
		saldo.setFont(new Font("Serif", Font.BOLD, 20));
		saldo.setText("Saldo R$ " + f.cMB(o.saldoDaConta()));
		patrimonio = new JLabel();
		patrimonio.setAlignmentX(3);
		patrimonio.setFont(new Font("Serif", Font.BOLD, 20));
		patrimonio.setText(" |  Patrimonio R$ " + f.cMB(o.limiteDaConta()));
		limite = new JLabel();
		limite.setAlignmentX(3);
		limite.setFont(new Font("Serif", Font.BOLD, 15));
		limite.setText("Limite R$ " + f.cMB(o.limiteDaConta()));
		limite.setForeground(Color.BLUE);
		panel2.add(saldo);
		panel2.add(patrimonio);
		panel2.add(limite);

		// panel3
		panel3.setLayout(null);
		panel3.setBorder(BorderFactory.createTitledBorder("Negociações"));
		panel3.setBounds(0, 82, 400, 300);
		panel3.setBackground(Color.WHITE);
		casa.setBounds(0, 40, 100, 100);
		apartamento.setBounds(90, 40, 100, 100);
		comercio.setBounds(175, 40, 100, 100);
		fazenda.setBounds(275, 40, 120, 100);
		sub1.setBounds(120, 15, 300, 25);
		sub2.setBounds(160, 150, 300, 25);
		acoes.setBounds(0, 180, 100, 100);
		fimob.setBounds(101, 180, 100, 100);
		frenda.setBounds(200, 180, 100, 100);
		poupan.setBounds(295, 180, 100, 100);
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

		// panel4
		JLabel lblCasa, lblComercio, lblApartamento, lblFazenda;
		panel4.setLayout(null);
		panel4.setBorder(BorderFactory.createTitledBorder("Meu Patrimônio"));
		panel4.setBounds(401, 82, 380, 200);
		panel4.setBackground(Color.WHITE);
		casaM.setBounds(15, 15, 50, 50);
		apartamentoM.setBounds(8, 55, 60, 60);
		comercioM.setBounds(14, 105, 50, 50);
		fazendaM.setBounds(5, 135, 80, 80);
		lblCasa = new JLabel();
		lblCasa.setBounds(75, 33, 400, 20);
		lblCasa.setFont(new Font("Serif", Font.BOLD, 15));
		lblCasa.setText("Você ainda não adquiriu essa propriedade");
		lblCasa.setForeground(Color.GRAY);
		lblApartamento = new JLabel();
		lblApartamento.setBounds(75, 75, 400, 20);
		lblApartamento.setFont(new Font("Serif", Font.BOLD, 15));
		lblApartamento.setText("Você ainda não adquiriu essa propriedade");
		lblApartamento.setForeground(Color.GRAY);
		lblComercio = new JLabel();
		lblComercio.setBounds(75, 120, 400, 20);
		lblComercio.setFont(new Font("Serif", Font.BOLD, 15));
		lblComercio.setText("Você ainda não adquiriu essa propriedade");
		lblComercio.setForeground(Color.GRAY);
		lblFazenda = new JLabel();
		lblFazenda.setBounds(75, 165, 400, 20);
		lblFazenda.setFont(new Font("Serif", Font.BOLD, 15));
		lblFazenda.setText("Você ainda não adquiriu essa propriedade");
		lblFazenda.setForeground(Color.GRAY);
		panel4.add(casaM);
		panel4.add(lblCasa);
		panel4.add(comercioM);
		panel4.add(lblComercio);
		panel4.add(apartamentoM);
		panel4.add(lblApartamento);
		panel4.add(fazendaM);
		panel4.add(lblFazenda);

		// panel5
		panel5.setLayout(new BorderLayout());
		panel5.setBorder(BorderFactory.createTitledBorder("Minhas Aplicações"));
		panel5.setBounds(401, 282, 380, 200);
		panel5.setBackground(Color.WHITE);

		// panel6
		panel6.setLayout(null);
		panel6.setBorder(BorderFactory.createTitledBorder("Mensagem"));
		panel6.setBounds(0, 380, 400, 180);
		panel6.setBackground(Color.WHITE);
		// panel6.add(text, BorderLayout.CENTER);

		logo.setBounds(490, 520, 400, 40);

		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
		add(logo);

		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comprar) {
			Global.MSGOK = true;
			Global.MSG = "Parabéns!! Você acaba de adquirir um novo imovel!";
			FactoryMethodInterface.getModel("Mensagem");
		}

		if (e.getSource() == vender) {
			Global.MSGOK = false;
			Global.MSG = "Acho que não foi dessa vez, falta pouco!";
			FactoryMethodInterface.getModel("Mensagem");
		}
		if (e.getSource() == investir) {

		}
		repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			panel6.remove(ben);
			panelBen.remove(compra);
			panelBen.remove(venda);
			panelBen.remove(despesa);
			panelBen.remove(receita);
			panel6.remove(panelBen);
			panelBen.remove(comprar);
			panelBen.remove(vender);
		} catch (Exception componenteAindaNaoCriado) {
			// Se caiu aqui é porque nao tem criando esse componente aida.
		}

		if (e.getSource() == casa) {
			ben = new JLabel(new ImageIcon("resources/imagens/Casa.jpg"));
			nomedoBem = "Casa";
		} else if (e.getSource() == apartamento) {
			ben = new JLabel(new ImageIcon("resources/imagens/Apartamento.jpg"));
			nomedoBem = "Apartamento";
		} else if (e.getSource() == comercio) {
			ben = new JLabel(new ImageIcon("resources/imagens/Comercio.jpg"));
			nomedoBem = "Comercio";
		} else if (e.getSource() == fazenda) {
			ben = new JLabel(new ImageIcon("resources/imagens/Fazenda.jpg"));
			nomedoBem = "Fazenda";
		}
		Global.IMOVEL = nomedoBem;
		ben.setBounds(5, 35, 120, 120);
		panel6.add(ben);
		panelBen.setLayout(null);
		panelBen.setBorder(BorderFactory.createTitledBorder(nomedoBem));
		panelBen.setBackground(Color.WHITE);
		panelBen.setBounds(130, 15, 260, 150);
		compra = new JLabel();
		venda = new JLabel();
		despesa = new JLabel();
		receita = new JLabel();
		compra.setText("Valor Compra  R$" + f.cMB(o.valorCompraBem(nomedoBem)));
		venda.setText("Valor Venda   R$" + f.cMB(o.valorVendaBem(nomedoBem)));
		despesa.setText("Valor Despesa R$" + f.cMB(o.despesaDoBem(nomedoBem)));
		receita.setText("Valor Retorno R$" + f.cMB(o.retornoDoBem(nomedoBem)));
		compra.setBounds(10, 20, 250, 20);
		venda.setBounds(10, 40, 250, 20);
		despesa.setBounds(10, 60, 250, 20);
		receita.setBounds(10, 80, 250, 20);
		compra.setFont(new Font("Courier New", Font.BOLD, 15));
		venda.setFont(new Font("Courier New", Font.BOLD, 15));
		despesa.setFont(new Font("Courier New", Font.BOLD, 15));
		receita.setFont(new Font("Courier New", Font.BOLD, 15));
		comprar = new JButton("Comprar");
		comprar.setBounds(15, 110, 100, 30);
		comprar.addActionListener(this);
		vender = new JButton("Vender");
		vender.setBounds(140, 110, 100, 30);
		vender.addActionListener(this);
		panelBen.add(compra);
		panelBen.add(venda);
		panelBen.add(despesa);
		panelBen.add(receita);
		panelBen.add(comprar);
		panelBen.add(vender);
		panel6.add(panelBen);
		repaint();
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
