package utilities;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import testcases.BaseClass;


public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
	public void onStart(ITestContext testContext){
		
		String repName = "Test-Report-"+BaseClass.timeStamp+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/output/reports/"+repName);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environement", "QA");
		extent.setSystemInfo("user", "Carolyn");
		
		htmlReporter.config().setDocumentTitle("Shopping Test Project");
		htmlReporter.config().setReportName("UI Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);	
	}
	
	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String f = LastFilePath.getLastFilePath("D:\\eclipse-workspace\\ShoppingTestProject\\output\\reports");

//		String screenshotPath=System.getProperty("user.dir")+"/output/screenshots/"+this.getClass().getSimpleName()+BaseClass.timeStamp+".png";
//		File f = new File(screenshotPath);

		try {
			logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(f));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
	}
	
	public void onTestSkipped(ITestResult tr) {
		
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.BROWN)); 
	}
	
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
	}
	
	

}
