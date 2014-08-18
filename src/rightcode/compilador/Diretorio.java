package rightcode.compilador;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


public class Diretorio {
	public static void main(String[] args){
		
		String caminho = "C:/Jackson/Copy/Compartilhamento Faculdade/ArquivosTeste RightCode/workspaceteste";
		
		setDir(caminho);
		
	}
	
	public static void setDir(String caminho){
		
		boolean srcANDbin = false;
		File diretorio = new File(caminho);
		ArrayList <String> dir = new ArrayList<String>();
		dir.addAll(Arrays.asList(diretorio.list()));
		
		for(String nomeDir: dir){
			File fileDir = new File(caminho+"/"+nomeDir);
			if (fileDir.isDirectory())
				setDir(caminho+"/"+nomeDir);
		}
		
		
		System.out.println(dir.size());
		System.out.println(dir.toString());
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
