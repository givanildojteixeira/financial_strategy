package front.javax;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Relatorios.BridgeRelatorios;
import Relatorios.IdRelatorios;
import Relatorios.IdVisualizadores;
import bancoDados.dbPropertiesFiles.IdFiles;
import console.Ferramentas;
import console.Global;
import dominio.Operacoes;
import front.CompraBens;
import front.ContextOrder;

public class Principal extends JFrame implements ActionListener, FacInterface, MouseListener {

	javax.swing.Timer timer;

	private ContextOrder corder = new ContextOrder(null);

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();
	JPanel panelBen = new JPanel();
	JPanel panelRelogio = new JPanel();
	JPanel panelCiclo = new JPanel();
	JPanel panelLogo = new JPanel();
	JPanel panelGrAp = new JPanel();
	JPanel panelGrBe = new JPanel();
	JPanel panelRel = new JPanel();

	JLabel ben = new JLabel();
	JLabel horario = new JLabel();
	JLabel cronometro = new JLabel();
	JLabel lblCasa = new JLabel();
	JLabel lblApartamento = new JLabel();
	JLabel lblComercio = new JLabel();
	JLabel lblFazenda = new JLabel();
	JLabel lblacoes = new JLabel();
	JLabel lblfimob = new JLabel();
	JLabel lblfrenda = new JLabel();
	JLabel lblpoupan = new JLabel();

	JProgressBar prbConta = new JProgressBar();

	Operacoes o = new Operacoes();
	Ferramentas f = new Ferramentas();
	// Declara Componentes
	JButton comprar, vender, investir, btnOkRel;
	JLabel investidor, saldo, limite, patrimonio, sub1, sub2, compra, venda, despesa, receita;
	JTextArea text = new JTextArea();
	JLabel casa = new JLabel(new ImageIcon(o.imagemDoBem("Casa")));
	JLabel apartamento = new JLabel(new ImageIcon(o.imagemDoBem("Apartamento")));
	JLabel comercio = new JLabel(new ImageIcon(o.imagemDoBem("Comercio")));
	JLabel fazenda = new JLabel(new ImageIcon(o.imagemDoBem("Fazenda")));
	JLabel casaM = new JLabel(new ImageIcon(o.iconeDoBem("Casa")));
	JLabel apartamentoM = new JLabel(new ImageIcon(o.iconeDoBem("Apartamento")));
	JLabel comercioM = new JLabel(new ImageIcon(o.iconeDoBem("Comercio")));
	JLabel fazendaM = new JLabel(new ImageIcon(o.iconeDoBem("Fazenda")));

	JLabel acoes = new JLabel(new ImageIcon(o.imagemDoBem("Acoes")));
	JLabel fimob = new JLabel(new ImageIcon(o.imagemDoBem("FundoImobiliario")));
	JLabel frenda = new JLabel(new ImageIcon(o.imagemDoBem("FundoRendaFixa")));
	JLabel poupan = new JLabel(new ImageIcon(o.imagemDoBem("Poupanca")));
	JLabel acoesM = new JLabel(new ImageIcon(o.iconeDoBem("Acoes")));
	JLabel fimobM = new JLabel(new ImageIcon(o.iconeDoBem("FundoImobiliario")));
	JLabel frendaM = new JLabel(new ImageIcon(o.iconeDoBem("FundoRendaFixa")));
	JLabel poupanM = new JLabel(new ImageIcon(o.iconeDoBem("Poupanca")));

	JLabel logo = new JLabel(new ImageIcon("resources/imagens/MiniLogo.jpg"));

	String nomedoBem = "", VlrCompra, VlrVenda;
	JComboBox<String> cb;
	JComboBox<String> cbv;

	int v = 1; // para controlar o ciclo

	Principal() {
		/*
		 * Criação ou atualização da conta na entrada do sistema,
		 * gerando a carga inicial ou recuperando informações
		 */

		o.CriarConta(Global.USUARIO, "");
		o.ConectarDB("", IdFiles.FileConfig);
		o.GravarDB("Usuario", Global.USUARIO, IdFiles.FileConfig);
		try {
			// tenta carregar os dados do do usuario
			Double s = o.leDBValor(Global.USUARIO + "-s", IdFiles.FileConfig);
			o.gravaSaldoConta(s);
			Double l = o.leDBValor(Global.USUARIO + "-l", IdFiles.FileConfig);
			o.gravaLimiteConta(l);
			Global.CASA = (int) o.leDBValor(Global.USUARIO + "-Casa-Quant", IdFiles.FileConfig);
			Global.APARTAMENTO = (int) o.leDBValor(Global.USUARIO + "-Apartamento-Quant", IdFiles.FileConfig);
			Global.COMERCIO = (int) o.leDBValor(Global.USUARIO + "-Comercio-Quant", IdFiles.FileConfig);
			Global.FAZENDA = (int) o.leDBValor(Global.USUARIO + "-Fazenda-Quant", IdFiles.FileConfig);
			Global.ACOES = (int) o.leDBValor(Global.USUARIO + "-Acoes-Quant", IdFiles.FileConfig);
			Global.FUNDOIMOBILIARIO = (int) o.leDBValor(Global.USUARIO + "-FundoImobiliario-Quant", IdFiles.FileConfig);
			Global.FUNDORENDAFIXA = (int) o.leDBValor(Global.USUARIO + "-FundoRendaFixa-Quant", IdFiles.FileConfig);
			Global.POUPANCA = (int) o.leDBValor(Global.USUARIO + "-Poupanca-Quant", IdFiles.FileConfig);

		} catch (Exception e) {
			// ops, é usuario novo, gravo os dados iniciais
			o.gravaSaldoConta(o.saldoDaConta());
			o.gravaLimiteConta(o.limiteDaConta());
			// o.GravarDBValor(Global.USUARIO + "-s", o.saldoDaConta());
			// o.GravarDBValor(Global.USUARIO + "-l", o.limiteDaConta());
		}

		setSize(1100, 600);
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

		acoes.addMouseListener(this);
		fimob.addMouseListener(this);
		frenda.addMouseListener(this);
		poupan.addMouseListener(this);

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
		// saldo.setText("Saldo R$ " + f.cMB(o.saldoDaConta()));
		patrimonio = new JLabel();
		patrimonio.setAlignmentX(3);
		patrimonio.setFont(new Font("Serif", Font.BOLD, 20));
		// patrimonio.setText(" | Patrimonio R$ " + f.cMB(o.limiteDaConta()));
		limite = new JLabel();
		limite.setAlignmentX(3);
		limite.setFont(new Font("Serif", Font.BOLD, 15));
		// limite.setText("Limite R$ " + f.cMB(o.limiteDaConta()));
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
		panel4.setLayout(null);
		panel4.setBorder(BorderFactory.createTitledBorder("Meu Patrimônio"));
		panel4.setBounds(401, 82, 380, 200);
		panel4.setBackground(Color.WHITE);
		casaM.setBounds(15, 15, 50, 50);
		apartamentoM.setBounds(8, 55, 60, 60);
		comercioM.setBounds(14, 105, 50, 50);
		fazendaM.setBounds(5, 135, 80, 80);
		lblCasa.setBounds(75, 33, 400, 20);
		lblCasa.setFont(new Font("Serif", Font.BOLD, 15));
		lblCasa.setForeground(Color.GRAY);
		lblApartamento.setBounds(75, 75, 400, 20);
		lblApartamento.setFont(new Font("Serif", Font.BOLD, 15));
		lblApartamento.setForeground(Color.GRAY);
		lblComercio.setBounds(75, 120, 400, 20);
		lblComercio.setFont(new Font("Serif", Font.BOLD, 15));
		lblComercio.setForeground(Color.GRAY);
		lblFazenda.setBounds(75, 165, 400, 20);
		lblFazenda.setFont(new Font("Serif", Font.BOLD, 15));
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
		panel5.setLayout(null);
		panel5.setBorder(BorderFactory.createTitledBorder("Minha Carteira de Ativos"));
		panel5.setBounds(401, 282, 380, 200);
		panel5.setBackground(Color.WHITE);
		acoesM.setBounds(15, 15, 50, 50);
		frendaM.setBounds(8, 55, 60, 60);
		fimobM.setBounds(14, 105, 50, 50);
		poupanM.setBounds(5, 135, 80, 80);
		lblacoes.setBounds(75, 33, 400, 20);
		lblacoes.setFont(new Font("Serif", Font.BOLD, 15));
		lblacoes.setForeground(Color.GRAY);
		lblfimob.setBounds(75, 75, 400, 20);
		lblfimob.setFont(new Font("Serif", Font.BOLD, 15));
		lblfimob.setForeground(Color.GRAY);
		lblfrenda.setBounds(75, 120, 400, 20);
		lblfrenda.setFont(new Font("Serif", Font.BOLD, 15));
		lblfrenda.setForeground(Color.GRAY);
		lblpoupan.setBounds(75, 165, 400, 20);
		lblpoupan.setFont(new Font("Serif", Font.BOLD, 15));
		lblpoupan.setForeground(Color.GRAY);
		panel5.add(acoesM);
		panel5.add(lblacoes);
		panel5.add(fimobM);
		panel5.add(lblfimob);
		panel5.add(frendaM);
		panel5.add(lblfrenda);
		panel5.add(poupanM);
		panel5.add(lblpoupan);

		// panel6
		panel6.setLayout(null);
		panel6.setBorder(BorderFactory.createTitledBorder("Mensagem"));
		panel6.setBounds(0, 380, 400, 180);
		panel6.setBackground(Color.WHITE);
		// panel6.add(text, BorderLayout.CENTER);

		panelCiclo.setLayout(new BorderLayout());
		panelCiclo.setBorder(BorderFactory.createTitledBorder("Ciclo"));
		panelCiclo.setBounds(401, 480, 180, 40);
		panelCiclo.setBackground(Color.WHITE);

		panelRelogio.setLayout(new BorderLayout());
		panelRelogio.setBorder(BorderFactory.createTitledBorder("Tempo de Jogo"));
		panelRelogio.setBounds(401, 520, 180, 40);
		panelRelogio.setBackground(Color.WHITE);
		horario.setFont(new Font("Serif", Font.BOLD, 20));
		horario.setHorizontalAlignment(SwingConstants.CENTER);
		horario.setForeground(Color.GREEN);

		// panelRel.setLayout(new BorderLayout());
		panelRel.setBorder(BorderFactory.createTitledBorder("Selecione o relatorio e a forma de visualização:"));
		panelRel.setBounds(581, 480, 500, 80);
		panelRel.setBackground(Color.WHITE);
		JLabel lbl = new JLabel("Relatório: ");
		lbl.setVisible(true);
		panelRel.add(lbl);
		String[] relatorio = Stream.of(IdRelatorios.values()).map(IdRelatorios::name).toArray(String[]::new);
		cb = new JComboBox<String>(relatorio);
		cb.setVisible(true);
		panelRel.add(cb);
		JLabel lbl2 = new JLabel("Visualizador: ");
		lbl2.setVisible(true);
		panelRel.add(lbl2);
		String[] visual = Stream.of(IdVisualizadores.values()).map(IdVisualizadores::name).toArray(String[]::new);
		cbv = new JComboBox<String>(visual);
		cbv.setVisible(true);
		panelRel.add(cbv);
		btnOkRel = new JButton("OK");
		btnOkRel.addActionListener(this);
		panelRel.add(btnOkRel);

		panelLogo.setLayout(new BorderLayout());
		panelLogo.setBorder(BorderFactory.createTitledBorder(";)"));
		panelLogo.setBounds(781, 0, 300, 80);
		panelLogo.setBackground(Color.WHITE);

		prbConta.setMinimum(0);
		prbConta.setMaximum(Global.TEMPOCICLO + 1);
		prbConta.setStringPainted(true);

		panelGrBe.setLayout(null);
		panelGrBe.setBorder(BorderFactory.createTitledBorder("Mercado Imobiliário"));
		panelGrBe.setBounds(781, 82, 300, 200);
		panelGrBe.setBackground(Color.WHITE);

		panelGrAp.setLayout(null);
		panelGrAp.setBorder(BorderFactory.createTitledBorder("Bolsa de Valores"));
		panelGrAp.setBounds(781, 282, 300, 200);
		panelGrAp.setBackground(Color.WHITE);

		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);

		add(panel5);
		add(panel6);
		add(panelCiclo);
		panelCiclo.add(prbConta, BorderLayout.SOUTH);
		add(panelRelogio);
		panelRelogio.add(horario);

		add(panelLogo);
		panelLogo.add(logo);
		add(panelRel);
		add(panelGrBe);
		add(panelGrAp);
		disparaRelogio();
		atualizaTelaPrincipal();
		repaint();
	}

	public void disparaRelogio() {
		if (timer == null) {
			timer = new javax.swing.Timer(1000, this);
			timer.setInitialDelay(0);
			timer.start();
		} else if (!timer.isRunning()) {
			timer.restart();
		}
	}

	private void atualizaTelaPrincipal() {
		saldo.setText("Saldo R$ " + f.cMB(o.saldoDaConta()));
		patrimonio.setText(" |  Patrimonio R$ " + f.cMB(o.limiteDaConta()));
		limite.setText("Limite R$ " + f.cMB(o.limiteDaConta()));

		lblCasa.setText(o.QualificaBem("Casa"));
		lblApartamento.setText(o.QualificaBem("Apartamento"));
		lblComercio.setText(o.QualificaBem("Comercio"));
		lblFazenda.setText(o.QualificaBem("Fazenda"));

		lblacoes.setText(o.QualificaBem("Acoes"));
		lblfimob.setText(o.QualificaBem("FundoImobiliario"));
		lblfrenda.setText(o.QualificaBem("FundoRendaFixa"));
		lblpoupan.setText(o.QualificaBem("Poupanca"));
		Random random = new Random();
		ColocaGrafico(panelGrBe,"Variações Bens Patrimônio", "Casa", random.nextInt(100),
				"Apto.", random.nextInt(100),
				"Comercio", random.nextInt(100),
				"Fazenda", random.nextInt(100));
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == comprar) {
			o.comprarBens(nomedoBem);
			corder.setOrderState(new CompraBens());
			corder.doWork(true);
			atualizaTelaPrincipal();
			FactoryMethodInterface.getModel("Mensagem");
		}

		if (e.getSource() == vender) {

			Global.MSG2 = "Valor da Venda R$" + VlrVenda;

		}
		if (e.getSource() == investir) {

		}

		if (e.getSource() == btnOkRel) {
			BridgeRelatorios r = new BridgeRelatorios();
			r.GerarRelatorio(cb.getSelectedItem() + "", cbv.getSelectedItem() + "");
		}

		// geral
		Date hora = new Date();
		SimpleDateFormat hora_formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		// atualiza o horario
		// horario.setText( hora_formato.format(hora));
		// atualiza o cronometro
		horario.setText(f.calcularDiferencaHoras(Global.TIMEINICIAL, hora_formato.format(hora)));

		// atualiza a barra de progresso
		prbConta.setValue(v);
		v++;
		if (v > Global.TEMPOCICLO) {
			// inicia um ciclo
			o.ciclo();
			atualizaTelaPrincipal();
			v = 1;
		}
		//
		Random random = new Random();
		ColocaGrafico(panelGrAp,"Variações Aplicações", "Açoes", random.nextInt(100),
				"F.Imobil", random.nextInt(100),
				"F.R.Fixo", random.nextInt(100),
				"Poupança", random.nextInt(100));
		//
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
			Global.IMOVEL = "Casa";
		} else if (e.getSource() == apartamento) {
			Global.IMOVEL = "Apartamento";
		} else if (e.getSource() == comercio) {
			Global.IMOVEL = "Comercio";
		} else if (e.getSource() == fazenda) {
			Global.IMOVEL = "Fazenda";
		} else if (e.getSource() == acoes) {
			Global.IMOVEL = "Acoes";
		} else if (e.getSource() == fimob) {
			Global.IMOVEL = "FundoImobiliario";
		} else if (e.getSource() == frenda) {
			Global.IMOVEL = "FundoRendaFixa";
		} else if (e.getSource() == poupan) {
			Global.IMOVEL = "Poupanca";

		}
		nomedoBem = Global.IMOVEL;
		ben = new JLabel(new ImageIcon(o.imagemDoBem(nomedoBem)));

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
		VlrCompra = f.cMB(o.valorCompraBem(nomedoBem));
		VlrVenda = f.cMB(o.valorVendaBem(nomedoBem));
		compra.setText("Valor Compra  R$" + VlrCompra);
		venda.setText("Valor Venda   R$" + VlrVenda);
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

	public void ColocaGrafico(JPanel p, String titulo,
			String item1, int vItem1,
			String item2, int vItem2,
			String item3, int vItem3,
			String item4, int vItem4) {
		// cria painel para desenhar grafico
		final Graficos desenhando = new Graficos();
		desenhando.setTitulos(titulo, "titulo ",
				"Variação Mercado");
		desenhando.setParametros(vItem1, item1);
		desenhando.setParametros(vItem2, item2);
		desenhando.setParametros(vItem3, item3);
		desenhando.setParametros(vItem4, item4);
		desenhando.setBounds(0, 0, 300, 200);
		p.add(desenhando);
	}

}
