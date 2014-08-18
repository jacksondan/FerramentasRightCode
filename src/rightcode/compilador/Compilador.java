package rightcode.compilador;


import java.io.File;
import java.io.IOException;

import javax.tools.JavaCompiler;  
import javax.tools.ToolProvider;  
  
public class Compilador {  
  
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
            System.out.println("Arquivos compilados com sucesso!");  
        } else {  
            System.out.println("Erro ao compilar arquivo!");
            System.out.println(caminho);
        }  
    } // fim do metodo compilaArquivo
    
    public void setDiretorio(String caminho){
    	
    	boolean srcAndBin = false;
		
		File diretorio = new File(caminho);
		
		String[] lista = diretorio.list();
		
				
		for(String arq : lista){
			
			File dir = new File(caminho+"/"+arq);
			if (dir.isDirectory())
				this.setDiretorio(caminho+"/"+arq);
			
			boolean resultado = (diretorio.getAbsolutePath()+"/"+arq).endsWith(".java");
			
			/*if(resultado == true){
				if(setArquivo(diretorio.getAbsolutePath()+"/"+arq)){
					nenhumaClasseCompilada = false;
				}
			}*/
		}
		
	}
  
    public static void main(String[] args) {  
        /*String caminho = System.getProperty("user.dir");
        String path = System.getProperty("java.class.path");
        String pacote = "/src/br/com/fafica/main";  
        String arquivo = "Main2.java";  
        String caminhoArquivo = caminho + pacote + "/" +  arquivo;
        
        System.out.println("Caminho: "+caminho);
        System.out.println("Path: "+path);
        System.out.println("Pacote: "+pacote);
        System.out.println("Arquivo: "+arquivo);
        System.out.println("caminhoArquivo: "+caminhoArquivo);
  
        Compilador compilerTeste = new Compilador();  
        compilerTeste.compilaArquivo(path, caminhoArquivo);*/
    	
    	Compilador compDir = new Compilador();
    	compDir.setDiretorio("");
    }  
} // fim da classe Compilador
