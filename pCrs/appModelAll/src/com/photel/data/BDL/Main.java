package com.photel.data.BDL;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.photel.commonServices.opencsv.CSVReader;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CSVReader reader = new CSVReader(new FileReader("C:\\dev\\BDL\\newExportCSV\\Extended\\Extended\\Imported\\Languages.csv"), '|');
		String[] line=new String[0];
		while (line!=null){
			line = reader.readNext();
			if (line!=null){
				System.out.println(line[0]+"-"+line[1]);
			}
		}
		
	}

}
