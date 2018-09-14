import java.util.Scanner;

public class practice1_2 {

	public static void main(String[] args) {		
		
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.next();
        Scanner scoreScan = new Scanner(input);
        
        Scanner calcScore = scoreScan.useDelimiter("[0-9]*");
        
        String[][] calcMap = new String[][]{{"",""},{"",""},{"",""}};
        
        
        int count = -1;
        while (calcScore.hasNext()){
        	String temp = calcScore.next().toString();
        	if(temp.equals("S")|| temp.equals("D")|| temp.equals("T")) {
        		count++;
        		calcMap[count][0] = temp;
        	}
        	else if(temp.equals("*")||temp.equals("#")){
        		calcMap[count][1] = temp;
        	}
        }
        
        
        String[] firstScore = input.split("[A-Z](#)*[*]*");
        
        int[] score = new int[3];
        
        for(int i = 0; i<3; i++){
        	score[i] = Integer.parseInt(firstScore[i]);
        	
        	for(int j = 0; j<2; j++) {
        		switch(calcMap[i][j]) {
        		case "S":
        			score[i] = (int)Math.pow(score[i], 1);
        			break;
        		case "D":
        			score[i] = (int)Math.pow(score[i], 2);
        			break;
        		case "T":
        			score[i] = (int)Math.pow(score[i], 3);
        			break;
        		case "*":
        			if (i == 0) score[i] = score[i]*2;
        			else {
        				score[i-1] = score[i-1]*2;
        				score[i] = score[i]*2;
        			}
        			break;
        		case "#":
        			score[i] = score[i]*-1;
        			break;
        		case "":
        			break;
        		}
        	}
        	
        }   
        
        int totalScore = score[0] + score[1] + score[2];
        System.out.print(totalScore);
	}
}

