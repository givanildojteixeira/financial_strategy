package console;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import front.javax.regra2;

public class Ferramentas {
	public String cMB(Double v) {
		NumberFormat nf = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
		return String.format("%10.15s", nf.format(v));
	}

	public String converteNroIdenticador(int v) {
		NumberFormat nf = new DecimalFormat("0000");
		return (nf.format(v));
	}

	public void limpaConsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		// System.out.printlnSTART >============================================== " +
		// dtf.format(LocalDateTime.now()));
	}

	public String calcularDiferencaHoras(String horaInicial, String horaFinal) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		try {
			LocalDateTime dt1 = LocalDateTime.parse(horaInicial, f);
			LocalDateTime dt2 = LocalDateTime.parse(horaFinal, f);

			// long diferencaMili = Duration.between(dt1, dt2).toMillis();
			long ds = Duration.between(dt1, dt2).getSeconds() - (Duration.between(dt1, dt2).toMinutes() * 60);
			long dm = Duration.between(dt1, dt2).toMinutes();
			long dh = Duration.between(dt1, dt2).toHours();
			return String.format("%02d:%02d:%02d", dh, dm, ds);

		} catch (Exception ex) {
			return ("");
		}
	}
	public String mid(String str, int start, int len){
		// Make sure start and len are within proper bounds
		String r="";
		start = start -1;
		if (start < 0 || len < 0) {
			return "";
		}
	
		int iEnd = 0;
		int iLen = str.length();
	
		if (start + len > iLen)
			iEnd = iLen;
		else
			iEnd = start + len;
	
		r= str.substring(start,iEnd);
			return r ;
	}
}
