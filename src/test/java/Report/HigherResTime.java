package Report;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HigherResTime {
	
	static List<String> trans_ = new ArrayList<String>();
	static String cvsSplitBy = ",";
	static Integer tcount=0;
	static String csvString = "";
	static String csvString_err = "";
	
	public static void readHighresTime() throws NumberFormatException, IOException{
		String fileName = ConfigPropertyReader.getProperty("filePath") + "Aggregate.csv";
		
		Integer SLA_resTime = Integer.parseInt(ConfigPropertyReader.getProperty("resTime_inSLA"));
		Double SLA_errRate = Double.parseDouble(ConfigPropertyReader.getProperty("errRate_inSLA"));

		BufferedReader br = null;
		String line = "";
		br = new BufferedReader(new FileReader(fileName));
		
		BufferedWriter bw2 = null;
		bw2 = new BufferedWriter(new FileWriter(ConfigPropertyReader.getProperty("filePath") + "HigherResTime.csv"));
	
		BufferedWriter bw1 = null;
		bw1 = new BufferedWriter(new FileWriter(ConfigPropertyReader.getProperty("filePath") + "HighererrRate.csv"));
		
		bw2.write("Transaction" + "," + "Res. Time" + "\n");
		bw1.write("Transaction" + "," + "Error Rate" + "\n");
		
		while ((line = br.readLine()) != null) {
			
			String[] data = line.split(cvsSplitBy);
			if ((!(data[2]).equalsIgnoreCase("Average")) && Integer.parseInt(data[2])>SLA_resTime && (!data[0].equalsIgnoreCase("Total"))){
				bw2.append(data[0] + "," + data[2] + "\n");
			}
			if ((!(data[7]).equalsIgnoreCase("aggregate_report_error%")) && Double.parseDouble(data[7].replaceAll("%", ""))>SLA_errRate && (!data[0].equalsIgnoreCase("Total"))){
				bw1.append(data[0] + "," + data[7] + "\n");
			}
		}
		br.close();
		bw2.close();
		bw1.close();
	}
	
	public static void readcsvString() throws IOException{
		String fileName1 = ConfigPropertyReader.getProperty("filePath") + "HigherResTime.csv";
		String fileName2 = ConfigPropertyReader.getProperty("filePath") + "HighererrRate.csv";
		BufferedReader br = null;
		String line = "";
		br = new BufferedReader(new FileReader(fileName1));
		
		while ((line = br.readLine()) != null) {
			csvString = csvString.concat(line) + "-csv-";
		}
		br.close();
		
		BufferedReader br1 = null;
		String line1 = "";
		br1 = new BufferedReader(new FileReader(fileName2));
		
		while ((line1 = br1.readLine()) != null) {
			csvString_err = csvString_err.concat(line1) + "-csv-";
		}
		br1.close();
	}
}
