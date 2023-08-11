package FullProject.properties;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    public static ExtentReports extent;
    
    public synchronized static ExtentReports getReports() {
        if (extent == null) {
            String pattern = "yyyyMMddHHmmss";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            String dateName = LocalDateTime.now().format(formatter);
            String reportPath = System.getProperty("user.dir") + "/Reports/Report" + dateName + ".html";
            
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("Web Automation Result");
            reporter.config().setDocumentTitle("Test Result");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "HariHaran");
            extent.setSystemInfo("Environment", "Automation Testing");
        }
        return extent;
    }
}
