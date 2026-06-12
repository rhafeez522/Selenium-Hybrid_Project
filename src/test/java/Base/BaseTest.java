package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	public FileInputStream fs;

	@BeforeMethod(alwaysRun = true)

	@Parameters({ "Browser" })
	public void SetUp(String BrowserName) throws IOException {
		logger = LogManager.getLogger();

		prop = new Properties();
		fs = new FileInputStream("./src//test//resources//data.properties");
		prop.load(fs);

		switch (BrowserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		case "chromeheadless":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));
			break;

		default:
			System.out.println("Invalid Browser.");

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();

		driver.get(prop.getProperty("baseUrl"));

		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)

	public void tearDown() {
		driver.quit();
	}

	// RandomString+Number logic

	public String getrandomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}

	public String getrandomNumeric() {
		return RandomStringUtils.randomNumeric(10);
	}

	public String getRandomStringNumeric() {
		String RandomString = RandomStringUtils.randomAlphabetic(3);
		String RandomNumeric = RandomStringUtils.randomNumeric(3);

		return (RandomString + RandomNumeric + "@%");
	}

	public String getScreenshot(String methodName) throws IOException {
		String currentTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + methodName + "_" + currentTimeStamp
				+ ".png";
		File targetFile = new File(targetFilePath);
		FileUtils.copyFile(srcFile, targetFile);

		return targetFilePath;

	}

}
