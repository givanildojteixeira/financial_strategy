package console;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Ferramentas{
    public String cMB(Double v) {
		NumberFormat nf = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
		return String.format("%10.10s", nf.format(v));
	}

	public String converteNroIdenticador(int v) {
		NumberFormat nf = new DecimalFormat("0000");
		return (nf.format(v));
	}

	public void limpaConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        // System.out.printlnSTART >============================================== " + dtf.format(LocalDateTime.now()));
    }
}
