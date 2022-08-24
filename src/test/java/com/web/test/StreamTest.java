package com.web.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class StreamTest {

    private static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    private static final String ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    private static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--use-fake-device-for-media-stream");
        options.addArguments("--use-fake-ui-for-media-stream");
        options.addArguments("--allow-file-access-from-files");
        options.addArguments("--disable-gesture-requirement-for-media-playback");
        options.addArguments("--use-file-for-fake-video-capture=C:\\Users\\hello\\Documents\\video\\sample_mjpeg.mjpeg");
        // ChromeOptions for starting chrome in incognito mode

        caps.setCapability(ChromeOptions.CAPABILITY, options);

        caps.setCapability("project", "BrowserStack");
        caps.setCapability("name", "Single Test - Chrome");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("browserstack.debug", "true");
        Date d = new Date();
        caps.setCapability("build","Demo_"+d.getTime());
        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @Test
    public void testSearchBrowserStack() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://streamyard.com/ib96u88pr5");
        Thread.sleep(5000);
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"BStackDemo login passed\"}}");
        driver.quit();
    }

}
