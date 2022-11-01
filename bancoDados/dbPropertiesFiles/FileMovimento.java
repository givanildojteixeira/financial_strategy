package bancoDados.dbPropertiesFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import console.Ferramentas;

public class FileMovimento extends FileChain {

    Ferramentas f = new Ferramentas();

    public FileMovimento() {
        super(IdFiles.FileMovimento);
    }

    private String arquivo = "resources/movimento.txt";

    @Override
    public void createConnection() {
        // verifica se o arquivo existe

        File a = new File(arquivo);
        try {
            if (!a.exists())
                a.createNewFile();
        } catch (IOException e) {
            // exceção
        }
    }

    @Override
    public void gravar(String chave, String valor) {

        try (FileWriter fw = new FileWriter(arquivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(chave + "|" + valor);
        } catch (IOException e) {
            // exceção
        }

    }

    @Override
    public String ler(String chave) {
        try {
            String s = "";
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            // enquanto houver mais linhas
            while (br.ready()) {
                // lê a proxima linha
                String linha = br.readLine();
                // faz algo com a linha
                if (f.mid(linha, 1, chave.length()).equals(chave))
                    s += f.mid(linha, chave.length()+1, linha.length()+1 - chave.length()) + "\n";
            }
            br.close();
            fr.close();
            return s;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}