package Relatorios;

public enum IdVisualizadores {
    CONSOLE("Console"),
    TELA("Tela");
    

    private String idVisualizadores;

    private IdVisualizadores(String idVisualizadores) {
        this.idVisualizadores = idVisualizadores;
    }

    public String getIdRelatorios() {
        return this.idVisualizadores;
    }

    @Override
    public String toString() {
        return this.idVisualizadores;
    }
}
