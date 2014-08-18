package rightcode.compilador;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PesAquivo {
	public static void main(String[] arg) throws IOException{
		String caminho = "C:/Users/Jackson/Dropbox/workspaces/workspacetupan/TesteCompilador2/src/Inicial.java";
		String pesMain = "^.*public static void main.String...*"; //[{|*{|\n{]*$ (String[] args)   public static void.*.String..
		String arquivoCompleto = "";
		String linha;
		Charset utf8 = StandardCharsets.UTF_8;
		
		
		
		
		Path path2 = Paths.get(caminho);;
		BufferedReader r2 = Files.newBufferedReader(path2, utf8);
		while((linha = r2.readLine())!= null){
			linha = linha.trim();
			if(!linha.equals(""))
				arquivoCompleto += linha+" ";
		}
		arquivoCompleto = arquivoCompleto.trim();
                System.out.println(arquivoCompleto); //Linha temporaria
                
        if (arquivoCompleto.matches(pesMain)){
        	System.out.println("main encontrado");
        }else{
        	System.out.println("main não encontrado");
        }
                
		
	}

}
