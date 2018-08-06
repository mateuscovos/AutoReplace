
package replace;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Replace {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        boolean continuar = true;
        List<String> linhas = null;
            
        while (continuar) {
            System.err.print("Entre com o local do arquivo");
            String local = in.next();
            System.err.print("Entre com o nome do arquivo *e sua extensão: ");
            String arquivo = in.next();

            Path path = Paths.get(local, arquivo);
            Charset charset = Charset.forName("ISO-8859-1");

            try {
                linhas = Files.readAllLines(path, charset);
                continuar = false;
            } catch (IOException ex) {
                System.out.println("Arquivo não encontrado");
                continue;
            }
        }
        StringBuilder linha = new StringBuilder();

        ArrayList<ReplaceArquivo> repl = new ArrayList<ReplaceArquivo>();
        repl.add(new ReplaceArquivo("-1", "00"));
        repl.add(new ReplaceArquivo("AS0M", ""));

        int a = 0;

        System.err.println("INICIANDO..");
        for (String li : linhas) {
            a++;

            for (ReplaceArquivo ra : repl) {
                li = li.replace(ra.getAntigo(), ra.getNovo());
            }

            linha.append(li);
            linha.append(System.getProperty("line.separator"));
        }

        System.err.println(a + " LINHAS LIDAS\n\n");

        System.err.print("Diretorio para salvar: ");
        String caminhoSave = in.next();

        System.err.print("Nome do arquivo *sem extensão: ");
        caminhoSave += in.next() + ".txt";

        System.err.println("O arquivo será salvo em: " + caminhoSave + "\n\n");

        FileWriter fw = new FileWriter(caminhoSave);

        System.err.println("INICIANDO GRAVAÇÃO");

        fw.write(linha.toString());

        System.err.println("ARQUIVO SALVO!");
    }

}

class ReplaceArquivo {

    private String antigo;
    private String novo;

    public ReplaceArquivo(String antigo, String novo) {
        this.antigo = antigo;
        this.novo = novo;
    }

    public String getAntigo() {
        return antigo;
    }

    public void setAntigo(String antigo) {
        this.antigo = antigo;
    }

    public String getNovo() {
        return novo;
    }

    public void setNovo(String novo) {
        this.novo = novo;
    }

}
