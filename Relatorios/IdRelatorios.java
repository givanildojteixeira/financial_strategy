package Relatorios;

public enum IdRelatorios {
    EXTRATO("ExtratoConta"),
    ANALITICO("RelatorioAnalitico"),
    SINTETICO("RelatorioSimples");

    private String idRelatorios;

    private IdRelatorios(String idRelatorios) {
        this.idRelatorios = idRelatorios;
    }

    public String getIdRelatorios() {
        return this.idRelatorios;
    }

    @Override
    public String toString() {
        return this.idRelatorios;
    }
}
