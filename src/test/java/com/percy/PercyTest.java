package com.percy;

import io.percy.selenium.Percy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PercyTest {

    private static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    private static final String ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    private static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    private WebDriver driver;
    private static Percy percy;
    List<Integer> width = Arrays.asList(375, 480, 720, 1280, 1440, 1920);



    @BeforeTest(alwaysRun = true)
    public void setup() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        percy = new Percy(driver);
    }

    @Test
    public void testSearchBrowserStack() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost:3000/");
        Thread.sleep(8000);
        wait.until(elementToBeClickable(By.id("signin")));
        percy.snapshot("Landing Page");
        wait.until(elementToBeClickable(By.id("signin"))).click();
        wait.until(elementToBeClickable(By.cssSelector("#username input"))).sendKeys("fav_user" + Keys.TAB);
        percy.snapshot("Login");
        driver.findElement(By.cssSelector("#password input")).sendKeys("testingisfun99" + Keys.TAB);
        driver.findElement(By.id("login-btn")).click();
        String username = wait.until(presenceOfElementLocated(By.className("username"))).getText();
        Assert.assertEquals(username, "fav_user", "Incorrect username");
        Thread.sleep(8000);
        percy.snapshot("Home");
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }

}
