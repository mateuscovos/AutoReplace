
package replace;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Replace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Scanner in = new Scanner(System.in);
        
        System.err.print("Entre com o local do arquivo");
        String local = in.next();
        System.err.print("Entre com o nome do arquivo *e sua extensão: ");
        String arquivo = in.next();
        
        Path path = Paths.get(local, arquivo);
        Charset charset = Charset.forName("ISO-8859-1");
                
        List<String> linhas = Files.readAllLines(path,charset);
        
        StringBuilder linha = new StringBuilder();
        
        int a = 0;
            
        System.err.println("INICIANDO..");
        for(String li : linhas){
            a++;            
            linha.append(li.replace("-1","00"));
            linha.append(System.getProperty("line.separator"));
        }
        
        
      
        //System.out.println(linha);
       System.err.println(a+" LINHAS LIDAS\n\n");
       
       System.err.print("Local para salvar: ");
       String caminhoSave = in.next();
       
       System.err.print("Nome do arquivo *sem extensão: ");
       caminhoSave += in.next()+".txt";
       
       System.err.println("O arquivo será salvo em: "+caminhoSave+"\n\n");
       
       FileWriter fw = new FileWriter(caminhoSave);
       
       System.err.println("INICIANDO GRAVAÇÃO");  
       
       fw.write(linha.toString());
       
       System.err.println("ARQUIVO SALVO!");
    }
    
}
       
