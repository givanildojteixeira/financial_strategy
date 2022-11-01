package bancoDados.dbPropertiesFiles;

public abstract class FileChain {

    protected FileChain next;
    protected IdFiles identificadorDoBanco;

    protected abstract void createConnection();
    protected abstract void gravar(String chave, String valor);
    protected abstract String ler(String chave);

    public FileChain(IdFiles id) {
        next = null;
        identificadorDoBanco = id;
    }

    public void setNext(FileChain forma) {
        if (next == null) {
            next = forma;
        } else {
            next.setNext(forma);
        }
    }

    private boolean podeEfetuar(IdFiles id) {
        if (identificadorDoBanco == id) {
            return true;
        }
        return false;
    }

    public void createConnection(IdFiles id) {
        if (podeEfetuar(id)) {
            createConnection();
        } else {
            next.createConnection(id);
        }
    }

    public void grava(String chave, String valor, IdFiles id) {
        if (podeEfetuar(id)) {
            gravar(chave, valor);
        } else {
            next.grava(chave, valor, id);
        }
    }

    public String le(String chave, IdFiles id) {
        if (podeEfetuar(id)) {
            return ler(chave);
        } else {
            return next.ler(chave);
        }

    }

}
