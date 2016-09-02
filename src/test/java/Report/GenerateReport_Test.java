/* LTR_v3.0 */

package Report;

import org.testng.annotations.Test;
import java.io.IOException;

public class GenerateReport_Test {

	static long finaltime = System.currentTimeMillis() / 1000L;

	@Test
	public static void loadTestReport() throws IOException {
		
		DownloadStatusAfterTest.statusPagesafterTest();
		Delta.sspDelta();
		try{
			Report.createHTML();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
}
