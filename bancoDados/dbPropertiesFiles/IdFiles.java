package bancoDados.dbPropertiesFiles;

public enum IdFiles {
    FileConfig("resources/config.properties"),
    FileMovimento("resources/movimento.txt");

    private String idFiles;

    private IdFiles(String idFiles) {
        this.idFiles = idFiles;
    }

    public String getArquivo() {
        return this.idFiles;
    }

    @Override
    public String toString() {
        return this.idFiles;
    }
}