package rightcode.compilador;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;


public class Diretorio {
	public static void main(String[] args){
		
		String caminho = "C:/Jackson/Copy/Compartilhamento Faculdade/ArquivosTeste RightCode/workspaceteste";
		
		Diretorio teste = new Diretorio();
		
		
		try {
			teste.setDir(caminho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("*********$***%********Erro Jackson*********$**%**********8");
		}
		
	}
	
	public void setDir(String caminho) throws IOException{
		
		File diretorio = new File(caminho);
		ArrayList <String> dir = new ArrayList<String>();
		dir.addAll(Arrays.asList(diretorio.list()));
		
		if(dir.contains(".project")){
			String caminhoBin = caminho+"/bin";
			String caminhoArquivo = buscaMain(caminho+"/src");
			
			if(caminhoArquivo == null){
				System.err.println("@#$ Caminho Arquivo é Igual a NULL");
			}else{
				compilaArquivo(caminhoBin, caminhoArquivo);
			}
			
		}else{
		
			for(String nomeDir: dir){
				File fileDir = new File(caminho+"/"+nomeDir);
			
				if (fileDir.isDirectory())
					setDir(caminho+"/"+nomeDir);
			}
		}
		
		
		//System.out.println(dir.size());
		System.out.println(dir.toString());
	}
	
	public String buscaMain(String caminhoSrc) throws IOException{
		File diretorio = new File(caminhoSrc);
		String retorno = null;
		ArrayList <String> dir = new ArrayList<String>();
		dir.addAll(Arrays.asList(diretorio.list()));
		
		//dir.contains(String.endsWith(".java"));
		
		for(String conteudo : dir){
			File file = new File(caminhoSrc+"/"+conteudo);
			
			if(file.isDirectory()){
				retorno = buscaMain(caminhoSrc+"/"+conteudo);
			}else if(conteudo.endsWith(".java")){
				String pesMain = "^.*public static void main.String...*"; //[{|*{|\n{]*$ (String[] args)   public static void.*.String..
				String arquivoCompleto = "";
				String linha;
				Charset utf8 = StandardCharsets.UTF_8;
				
				Path path2 = Paths.get(caminhoSrc+"/"+conteudo);;
				BufferedReader r2 = Files.newBufferedReader(path2, utf8);
				while((linha = r2.readLine())!= null){
					linha = linha.trim();
					if(!linha.equals(""))
						arquivoCompleto += linha+" ";
				}
				arquivoCompleto = arquivoCompleto.trim();
		                System.out.println(arquivoCompleto); //Linha temporaria
		                
		        if (arquivoCompleto.matches(pesMain)){
		        	retorno = caminhoSrc+"/"+conteudo;
		        	System.out.println("main encontrado");
		        }else{
		        	retorno = null;
		        	System.out.println("main não encontrado");
		        }
			}
			
		}
		
		return retorno;
	}
	
    public void compilaArquivo(String caminho, String caminhoArquivo) {  
    	  
    	String teste = "C:\\Program Files\\Java\\jdk"+System.getProperty("java.runtime.version").replaceAll("-b[0-9]{2}",""); 
    	String sistema = System.getProperty("os.name");
    	
    	System.out.println("JAVA: "+teste);
    	System.out.println("Sistema: "+sistema);
    	    
    	if(!sistema.equals("Linux")){
    		System.setProperty("java.home", teste);
    	}
    	
    	JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();  
       
        int result = compiler.run(null, null, null, "-cp", caminho, caminhoArquivo);  
        if (result == 0) {  
            System.out.println("Projeto compilados com sucesso!");  
        } else {  
            System.out.println("Erro ao compilar Projeto!");
            System.out.println(caminho);
        }  
    }
	
	
	
	
	
	
	/*System.out.println(dir.contains(".project"));
	if (dir.contains("src") && dir.contains("bin")){
		System.out.println("Encontrou os dois");
	*/	
		
		
	
	/*File diretorio = new File(caminho);
	ArrayList <String> dir;// = new ArrayList<String>();
	dir = (ArrayList<String>) Arrays.asList(diretorio.list());
	//ArrayList <String> tes = diretorio.list(); 
	//for()
	System.out.println(dir.size());*/
	
}
