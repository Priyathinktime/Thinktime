package FullProject.TestClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public WebDriver initializer() throws IOException {
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "\\src\\main\\java\\FullProject\\properties\\Globaldata.properties");
        pro.load(fis);
        WebDriver driver = null;
    	String browsername =System.getProperty("browser")!=null? System.getProperty("browser") : pro.getProperty("browser");
        
        if (browsername.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browsername.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        
        // Set the created driver instance to the ThreadLocal
        setDriver(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    @BeforeMethod
    public void launchApp(ITestResult result) throws IOException {
    	  WebDriver driver = initializer();
          result.setAttribute("driver", driver); // Set driver as an attribute
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}


