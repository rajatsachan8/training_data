package week_4_assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppendToFileExample {

	private static final String FILENAME = "D:\\Hello.txt";

	public static void main(String[] args) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String data;

			File file = new File(FILENAME);

			if (!file.exists()) {
				file.createNewFile();
			}

			
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
               Scanner scan=new Scanner(System.in);
               while(scan.hasNext()){
            	   data=scan.next();
            	   bw.write(data);
            	   bw.write(" ");
               }

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	}

}