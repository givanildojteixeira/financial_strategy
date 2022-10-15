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
  public static String USUARIO = "";
  public static final int CONTA = 0;
  public static double SALDO = 0;
  public static double LIMITE = 0;
  public static String TITULO = "Financial Stategy";

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

}
