package com.web.test;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SnoopTest {

    private static final String USERNAME = "USERNAME";
    private static final String ACCESS_KEY = "ACCESSKEY";
    private static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("project", "BrowserStack");
        caps.setCapability("build", "Demo");
        caps.setCapability("name", "Single Test - ios");
        caps.setCapability("os_version", "14");
        caps.setCapability("device", "iPad Pro 12.9 2021");
        caps.setCapability("real_mobile", "true");
        caps.setCapability("deviceOrientation", "landscape");

       // caps.setCapability("os", "OS X");
      //  caps.setCapability("os_version", "Big Sur");
      //  caps.setCapability("browser", "Safari");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("browserstack.geoLocation", "GB");
        caps.setCapability("browserstack.debug", "true");

        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @Test
    public void testSearchBrowserStack() throws InterruptedException {
        driver.get("https://test.snoop.app/webapp/auth/login");
//        driver.manage().window().setSize(new Dimension(1440, 831));
        driver.findElement(By.id("mobilePhone")).click();
        driver.findElement(By.id("mobilePhone")).sendKeys("07989695949");
        driver.findElement(By.id("pin")).click();
        driver.findElement(By.id("pin")).sendKeys("98765");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("code")).click();
        driver.findElement(By.id("code")).sendKeys("000000");
        driver.findElement(By.cssSelector("span:nth-child(1)")).click();
        Thread.sleep(15000);
        driver.findElement(By.xpath("//div[contains(text(),'Transactions')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'Categories')]")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[contains(text(),'Your Bills')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'This month')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'All payments')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'Your Bills')]")).click();
        Thread.sleep(10000);
    }

    @AfterTest(alwaysRun = true)

    public void teardown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"BStackDemo login passed\"}}");
        driver.quit();
    }

}
