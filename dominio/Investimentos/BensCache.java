package dominio.Investimentos;

import java.util.Hashtable;

import dominio.Investimentos.Bens.*;

public class BensCache {
	private static Hashtable<String, BensPrototype> forms = new Hashtable<String, BensPrototype>();

	public static BensPrototype getForm(String id) {
		BensPrototype form = forms.get(id);
		return form.cloneBens();
	}

	public static void loadForms() {

		forms.put(BensPrototype.APARTAMENTO, new Apartamento());
		forms.put(BensPrototype.FAZENDA, new Fazenda());
		forms.put(BensPrototype.CASA, new Casa());
		forms.put(BensPrototype.COMERCIO, new Comercio());
	}

	public static void loadBens(String key, BensPrototype value) {
		forms.put(key, value);
	}
}
