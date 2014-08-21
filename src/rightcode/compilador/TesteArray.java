package rightcode.compilador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TesteArray {
	 public static void main(String... args) {
	     List<String> a1 = Arrays.asList("public" ,"static", "void", "main", "(", "String", "[", "]","args", ")");
	     Set<String>  a2 = new HashSet<String>(Arrays.asList("public","static","void","args"));

	     ArrayList<Integer> a3 = new ArrayList<Integer>();                

	     for (String a : a1)
	         a3.add(a2.contains(a) ? 1 : 0);

	     System.out.println(a3);
	 }

}

