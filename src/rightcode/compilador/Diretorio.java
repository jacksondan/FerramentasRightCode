package rightcode.compilador;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;


public class Diretorio {
	public static void main(String[] args){
		
		String caminho = "C:/Users/Jackson/Copy/Compartilhamento Faculdade/ArquivosTeste RightCode/workspaceteste";
		
		setDir(caminho);
		
	}
	
	public static void setDir(String caminho){
		
		File diretorio = new File(caminho);
		ArrayList <String> dir = new ArrayList<String>();
		dir.addAll(Arrays.asList(diretorio.list()));
		
		if(dir.contains(".project")){
			
			
			
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
