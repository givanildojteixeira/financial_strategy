package bancoDados.dbPropertiesFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileMovimento extends FileChain {

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
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            // enquanto houver mais linhas
            while (br.ready()) {
                // lê a proxima linha
                String linha = br.readLine();
                // faz algo com a linha
                System.out.println(linha);
            }
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}