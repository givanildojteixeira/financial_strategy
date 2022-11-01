package dominio.Investimentos;

import java.util.Hashtable;

import dominio.Investimentos.Aplicacoes.Acoes;
import dominio.Investimentos.Aplicacoes.FundoImobiliario;
import dominio.Investimentos.Aplicacoes.FundoRendaFixa;
import dominio.Investimentos.Aplicacoes.Poupanca;
import dominio.Investimentos.Bens.*;

public class BensCache {

	private static Hashtable<String, BensPrototype> forms = new Hashtable<String, BensPrototype>();

	public static BensPrototype getForm(String id) {
		BensPrototype form = forms.get(id);
		return form.cloneBens();
	}

	public static void loadForms() {
		// aplicações
		forms.put(BensPrototype.ACOES, new Acoes());
		forms.put(BensPrototype.FUNDOIMOBILIARIO, new FundoImobiliario());
		forms.put(BensPrototype.FUNDORENDAFIXA, new FundoRendaFixa());
		forms.put(BensPrototype.POUPANCA, new Poupanca());
		// bens
		forms.put(BensPrototype.APARTAMENTO, new Apartamento());
		forms.put(BensPrototype.FAZENDA, new Fazenda());
		forms.put(BensPrototype.CASA, new Casa());
		forms.put(BensPrototype.COMERCIO, new Comercio());

	}

	public static void loadBens(String key, BensPrototype value) {
		forms.put(key, value);
	}

}
