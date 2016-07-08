package Report;

import org.testng.annotations.Test;

import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Environment;

import java.io.IOException;

public class GenerateReport_Test {

	static long finaltime = System.currentTimeMillis() / 1000L;

	@Test
	public static void loadTestReport() throws IOException {
		
		DownloadStatusAfterTest.statusPagesafterTest();
		Delta.sspDelta();
		GenerateReport_Test ts = new GenerateReport_Test();
		try{
			Report.createHTML();
			System.out.println("Please see the test results at: "+ConfigPropertyReader.getProperty("filePath")+"FinalReport.html");
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
}
