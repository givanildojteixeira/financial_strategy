package dominio.Investimentos;

import dominio.Investimentos.Aplicacoes.Acoes;
import dominio.Investimentos.Aplicacoes.FundoImobiliario;
import dominio.Investimentos.Aplicacoes.FundoRendaFixa;
import dominio.Investimentos.Aplicacoes.Poupanca;

public class FactoryAplicacoes {

    public static int ACOES = 1;
    public static int FUNDOIMOBILIARIO = 2;
    public static int FUNDORENDAFIXA = 3;
    public static int POUPANCA = 4;


	public static FacAplicacoes getModel(int especie) {
		
		
		switch (especie) {
		case 1:
			return new Acoes();
		case 2:
			return new FundoImobiliario();
		case 3:
			return new FundoRendaFixa();
		case 4:
			return new Poupanca();
		default:
			return new Poupanca();
		}

	}



}
