package com.photel.data.BDL.ddbb;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.photel.commonServices.opencsv.CSVReader;
import com.photel.interfaces.data.BDL.IBdlLanguages;

public class HelperCSV {
	private String importPath;
	private HelperHibernateDDBBGen data;
	private Logger  log = Logger.getRootLogger();
	private Hashtable<String,String> languajes;
	
	public HelperCSV(HelperHibernateDDBBGen ddbb){
		super();
		this.data=ddbb;
		this.importPath=data.getPatam("importPath");
		setlanguages();
	}
	private void setlanguages(){
		ArrayList<IBdlLanguages> lan = data.getLanguages();
		this.languajes=new Hashtable<String,String>();
		for(int i=0;i<lan.size();i++){
			this.languajes.put(lan.get(i).getId(),lan.get(i).getBdlDescription());
		}
	}
	public void loadCountries() throws IOException{
		String file=this.importPath+"CountryIDs.csv";
		CSVReader reader = new CSVReader(new FileReader(file), '|');
		int i=0;
		String[] line=new String[0];
		////data.truncate("BdlCountries");
		
		while (line!=null){
			line = reader.readNext();
			if (line!=null){
				if (this.languajes.get(line[1].trim())!=null){
					data.setCountry(line[0].trim(), line[1].trim(),line[2].trim());
					i++;
				}
			}
		}
		reader.close();
		log.info(i+" countries loaded from " + file);
	}
	
	public void loadDestinations() throws IOException{
		String file=this.importPath+"DestinationIDs.csv";
		CSVReader reader = new CSVReader(new FileReader(file), '|');
		int i=0;
		String[] line=new String[0];
		//data.truncate("BdlDestinations");
		
		while (line!=null){
			line = reader.readNext();
			if (line!=null){
				if (this.languajes.get(line[1].trim())!=null){
					data.setDestination(line[0].trim(), line[1].trim(),line[2].trim());
					i++;
				}
			}
		}
		reader.close();
		log.info(i+" countries loaded from " + file);
	}
	public void loadHotelDestinations() throws IOException{
		String file=this.importPath+"HotelDestinations.csv";
		CSVReader reader = new CSVReader(new FileReader(file), '|');
		int i=0;
		String[] line=new String[0];
		//data.truncate("BdlHotelDestinations");
		
		while (line!=null){
			line = reader.readNext();
			if (line!=null){
				data.setHotelDestination(line[0].trim(), line[1].trim());
				i++;
			}
		}
		reader.close();
		log.info(i+" countries loaded from " + file);
	}
	public void loadHotelDescriptions() throws IOException{
		String file=this.importPath+"HotelDescriptions.csv";
		CSVReader reader = new CSVReader(new FileReader(file), '|');
		int i=0;
		String[] line=new String[0];
		//data.truncate("BdlHotelDescriptions");
		
		while (line!=null){
			line = reader.readNext();
			if (line!=null){
				if (this.languajes.get(line[1].trim())!=null){
					data.setHotelDescription(line[0].trim(), line[1].trim(),line[2].trim());
					i++;
				}
			}
		}
		reader.close();
		log.info(i+" countries loaded from " + file);
	}
	
	public void loadHotels() throws IOException{
		String file=this.importPath+"Hotels.csv";
		CSVReader reader = new CSVReader(new FileReader(file), '|');
		int i=0;
		String[] line=new String[0];
		//data.truncate("BdlHotels");
		
		while (line!=null){
			line = reader.readNext();
			if (line!=null){
					data.setHotel(line[0].trim(), line[1].trim(),line[2].trim(),line[3].trim(),line[4].trim(),line[5].trim(),line[6].trim(),line[7].trim(),line[8].trim());
					i++;
			}
		}
		reader.close();
		log.info(i+" countries loaded from " + file);
	}
}
