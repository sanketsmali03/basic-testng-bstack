package com.app.test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.List;



public class AvaTrade {

        private static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
        private static final String ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
        private static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
        private MobileDriver<MobileElement> driver;


        @BeforeTest(alwaysRun = true)
        public void setup() throws MalformedURLException {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("project", "BrowserStack");
                caps.setCapability("build", "Demo");
                caps.setCapability("name", "Wikipedia Search Function - Google Pixel 3");
                caps.setCapability("browserstack.user", "sanketmali4");
                caps.setCapability("browserstack.key", "Nt7WxbXzjUzT8kfpbEKC");
                // Set URL of the application under test
                caps.setCapability("app", "bs://eb65745602969a298a999c1c0b245a7d6597df7c");
                // Specify device and os_version for testing
                caps.setCapability("device", "Samsung Galaxy S21");
                caps.setCapability("os_version", "11.0");
                caps.setCapability("real_mobile", "true");


                driver = new AndroidDriver<>(new URL(URL), caps);
        }

        @Test
        public void searchWikipedia() throws InterruptedException {
                Wait<MobileDriver<MobileElement>> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofMillis(500))
                        .ignoring(NotFoundException.class);

                MobileElement signUp = wait.until(d -> d.findElementByXPath("//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button[1]"));
                signUp.click();
                Thread.sleep(5000);

                MobileElement emailAdd = wait.until(d -> d.findElementById("user_register_email"));
                Date dd = new Date();
                emailAdd.sendKeys("SuperTest"+dd.getTime()+"@gmail.com");

                MobileElement emailPass = wait.until(d -> d.findElementById("user_register_password"));
                emailPass.sendKeys("September@2021");
                Thread.sleep(3000);

                MobileElement createAccount = wait.until(d -> d.findElementById("create_user_account"));
                createAccount.click();
                Thread.sleep(30000);

                MobileElement name = wait.until(d -> d.findElementByXPath("//android.view.View[2]/android.view.View[1]/android.view.View/android.widget.EditText"));
                name.sendKeys("Test");
                Thread.sleep(3000);

                MobileElement lastname = wait.until(d -> d.findElementByXPath("//android.view.View[3]/android.view.View[1]/android.view.View/android.widget.EditText"));
                lastname.sendKeys("Test");
                Thread.sleep(3000);


                MobileElement nextBtn = wait.until(d -> d.findElementByXPath("//android.widget.Button[contains(@text, 'Next')]"));
                nextBtn.click();
                Thread.sleep(10000);


                MobileElement dateSelect = wait.until(d -> d.findElementByXPath("//android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.widget.Spinner"));
                dateSelect.click();
                Thread.sleep(3000);

                MobileElement set = wait.until(d -> d.findElementByXPath("//android.widget.LinearLayout/android.widget.Button[3]"));
                set.click();
                Thread.sleep(3000);

                MobileElement nextBtn1 = wait.until(d -> d.findElementByXPath("//android.widget.Button[contains(@text, 'Next')]"));
                nextBtn1.click();
                Thread.sleep(10000);

                MobileElement country = wait.until(d -> d.findElementByXPath("//android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText"));
                country.click();
                country.sendKeys("Australia");

                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));

                PageFactory.initElements(new AppiumFieldDecorator(driver), this);

                country.click();
                country.clear();
                country.sendKeys("Australia");

                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));

                PageFactory.initElements(new AppiumFieldDecorator(driver), this);
                country.click();
                country.clear();
                country.sendKeys("Australia");

                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));


               TouchAction touchAction = new TouchAction(driver);
                touchAction.tap(PointOption.point(498, 124)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).perform();
                Thread.sleep(3000);
                touchAction.tap(PointOption.point(498, 124)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).perform();
                Thread.sleep(3000);
                touchAction.tap(PointOption.point(498, 124)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).perform();
                Thread.sleep(3000);
                touchAction.tap(PointOption.point(498, 124)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).perform();
                Thread.sleep(3000);
                driver.getPageSource();
                MobileElement Address = wait.until(d -> d.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText"));
                Address.click();
                Address.sendKeys("Test");

                MobileElement State = wait.until(d -> d.findElementByXPath("//android.view.View[4]/android.view.View[1]/android.view.View/android.widget.EditText"));
                State.click();
                State.sendKeys("Test");

                MobileElement City = wait.until(d -> d.findElementByXPath("//android.view.View[5]/android.view.View[1]/android.view.View/android.widget.EditText"));
                City.click();
                City.sendKeys("Test");


                MobileElement StreetName = wait.until(d -> d.findElementByXPath("//android.view.View[6]/android.view.View[1]/android.view.View/android.widget.EditText"));
                StreetName.click();
                StreetName.sendKeys("Test");

                MobileElement StreetNum = wait.until(d -> d.findElementByXPath("//android.view.View[7]/android.view.View[1]/android.view.View/android.widget.EditText"));
                StreetNum.click();
                StreetNum.sendKeys("Test");

                MobileElement Apartment = wait.until(d -> d.findElementByXPath("//android.view.View[8]/android.view.View[1]/android.view.View/android.widget.EditText"));
                Apartment.click();
                Apartment.sendKeys("Test");

                MobileElement ZipCode = wait.until(d -> d.findElementByXPath("//android.view.View[9]/android.view.View[1]/android.view.View/android.widget.EditText"));
                ZipCode.click();
                ZipCode.sendKeys("Test");

                MobileElement nextBtn2 = wait.until(d -> d.findElementByXPath("//android.widget.Button[contains(@text, 'Next')]"));
                nextBtn2.click();
                Thread.sleep(10000);








        }

        @AfterTest(alwaysRun = true)
        public void tearDown() {
                //  JavascriptExecutor js = (JavascriptExecutor) driver;
                //  js.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Wikipedia search passed\"}}");
                driver.quit();
        }
}