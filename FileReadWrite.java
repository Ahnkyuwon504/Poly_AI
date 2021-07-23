package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {

	public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        File f = new File("C:\\Users\\user\\Desktop\\IMDB Dataset.csv\\MovieReview\\ratings_test.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        
        File f1 = new File("C:\\Users\\user\\Desktop\\IMDB Dataset.csv\\ratings_test_min.csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f1));
        
        String readtxt;
        int cnt = 1000000;
        
        String firstLine = "id\tdocument\tlabel";
        
        bw.write(firstLine.toString());
        bw.newLine();
        
        while ((readtxt = br.readLine()) != null) {
        	if ((readtxt.split("\t")).length > 2) continue;
        	
        	StringBuffer s = new StringBuffer();
        	String[] field = readtxt.split("\t");
        	
        	System.out.println(cnt + "and now string is : " + field[0]);
        	
        	for (int i = 0; i < field.length; i++) {
        		if (i == 0) {
        			s.append(cnt).append("\t");
        			s.append(field[0]).append("\t");
        			continue;
        		}
        		
        		if ((field[i].charAt(0) == '0' || field[i].charAt(0) == '1') && field[i].length() == 1) {
        			s.append(field[i]);
        		}
        	}
        	
        	if (cnt > 1003300) {
        	} else {
        		bw.write(s.toString());
        		bw.newLine();
        	}
        	
        	cnt++;
        }
        
        br.close();
        bw.close();
    }
}
