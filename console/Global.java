package console;

/* Exemplo Singleton
  Aplicado para variaveis que podem ser alteradas por todos ou por alguns
  objetos na aplicação, dessa maneira, são instanciados e manipulados
  de uma maneira descomplicada e com poucos codigos, tornando facil a 
  sua manutenção.

  Na movimentação da conta corrente é instanciado o nro da operacao, que
  se trata de um numerador do banco para identificar operacoes que podem
  ser entrada, saida ou transferencia, usada em qualquer momento e diferente
  para qualquer conta e operação no banco. Sendo uma variavel que pode ser 
  alterada em tempo de execução por qualquer objeto.
*/
public class Global {

  public static final String TITULO = "Financial Stategy";
  public static final int TEMPOCICLO = 5;
  public static int jogadasPreliminares = 3;
  public static final double SALARIOMENSAL = 300;
  public static final double VALORVENCEDOR = 1000000;
  public static final int GRAUDEDIFICULDADE = 3;
  public static String USUARIO = "";
  public static Boolean MSGOK;
  public static String IMOVEL;
  public static String MSG;
  public static String MSG2;
  public static String TIMEINICIAL;
  public static int CASA;
  public static int APARTAMENTO;
  public static int COMERCIO;
  public static int FAZENDA;
  public static int ACOES;
  public static int FUNDOIMOBILIARIO;
  public static int FUNDORENDAFIXA;
  public static int POUPANCA;


  public static class IdentificadorConta {
    private static final IdentificadorConta nroIdCta = new IdentificadorConta();
    private int NroIdCta = 0;

    private IdentificadorConta() {
    }

    public static IdentificadorConta getInstance() {
      return nroIdCta;
    }

    public int novo() {
      return NroIdCta += 1;
    }
  }

  public static class IdentificadorOperacao {
    private static final IdentificadorOperacao identificador = new IdentificadorOperacao();
    private int NroIdentificador = 0;

    private IdentificadorOperacao() {
    }

    public static IdentificadorOperacao getInstance() {
      return identificador;
    }

    public int novo() {
      return NroIdentificador += 1;
    }
  }

  public static class Patrimonio {
    private static final Patrimonio patrimonio = new Patrimonio();
    private double valorPatrimonio = 0;

    private Patrimonio() {
    }

    public static Patrimonio getInstance() {
      return patrimonio;
    }

    public double deposita(double valor) {
      return valorPatrimonio += valor;
    }

    public double saca(double valor) {
      return valorPatrimonio -= valor;
    }
  }

}
