

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class practice1_4 {

	public static void main(String[] args) {		
		
		while (true) {
        Scanner scanner = new Scanner(System.in);
        
        String str1 = scanner.nextLine().toLowerCase();
        String str2 = scanner.nextLine().toLowerCase();
        
        if(str1.equals(str2)) {
        	System.out.println(65536);
        }
        else {
        	ArrayList<String> str1mat = new ArrayList<String>();
            ArrayList<String> str2mat = new ArrayList<String>();
            
            Pattern p = Pattern.compile("[a-z][a-z]");
            		
            for(int i = 0; i<str1.length()-1; i++) {
            	Matcher m = p.matcher(str1.substring(i,i+2));
            	if(m.matches()){
            		str1mat.add(str1.substring(i,i+2));
            	}
            }
            
            for(int i = 0; i<str2.length()-1; i++) {
            	Matcher m = p.matcher(str2.substring(i,i+2));
            	if(m.matches()){
            		str2mat.add(str2.substring(i,i+2));		
            	}
            }
            
            if(str1mat.size()>str2mat.size()) {
            	ArrayList<String> temp = new ArrayList<String>();
            	temp = str2mat;
            	str2mat = str1mat;
            	str1mat = temp;
            }
            
            double union = str2mat.size();
            double intersection = 0;
            
            for(String temp : str1mat) {
            	if(str2mat.contains(temp)) {
            		intersection++;
            	}else union++;
            }
            
            int jaccard = (int)(intersection/union*65536);
            System.out.println(jaccard);
        }
	}
}
}
