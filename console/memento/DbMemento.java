package console.memento;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import bancoDados.dbPropertiesFiles.IdFiles;

public class DbMemento extends Memento {
    protected int t = 0;
    protected ArrayList<String> momentos;

    String dirMomentos = "resources/momentos/";
    IdFiles s = IdFiles.FileConfig;

    public DbMemento() {
        momentos = new ArrayList<String>();
        limpaMomentos();
    }

    private static void copyFile(File src, File dest) throws IOException {
        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    @Override
    public void adicionarMomento() throws IOException {
        //adiciona uma capa do momento na tabela
        momentos.add("" + t);
        
        //cria os arquivos de conf. necessarios na pasta de momentos
        //nomeados com uso da capa
        copyFile(new File(s.getArquivo()), new File(dirMomentos + ".tmp." + t));
        
        //altera contador
        t++;
    }

    @Override
    public String desfazUltimoMomento() throws IOException {
        //controle de bug
        if (momentos.size() <= 0)
            return "";

        //remove ultima capa
        momentos.remove(momentos.size() - 1);

        //recupera arquivo com base no nome
        copyFile(new File(dirMomentos + ".tmp." + momentos.get(momentos.size() - 1)), new File(s.getArquivo()));
        
        //atualiza o sistema com as novas informações
        
        
        return momentos.get(momentos.size() - 1);
    }

    @Override
    public String mostraMomentos() {
        return momentos.toString();
    }

    @Override
    protected void limpaMomentos() {
        File folder = new File(dirMomentos);
        if (folder.isDirectory()) {
            File[] sun = folder.listFiles();
            for (File toDelete : sun) {
                toDelete.delete();
            }
        }

    }

}
