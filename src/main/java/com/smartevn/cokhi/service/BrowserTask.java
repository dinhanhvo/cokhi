package com.smartevn.cokhi.service;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class BrowserTask implements Callable<String> {

    private static final String SEARCHING_TABLE = "TrvOptGrid";
    private static final int TIMEOUT = 700;
    private static final int NUM_THREADS_POOL = 3;
    private static final int POOLING_INTERVAL = 1000;
    
    private String url = null;
    private String html = null;
    
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
    
    public static WebDriver driver = new FirefoxDriver();
    @Override
    public String call() throws Exception {
     // Get the page
        driver.get(url);
        // Define wait
        Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(30, TimeUnit.SECONDS)
            .pollingEvery(1, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class)
            .withMessage("TimeoutException is thrown");

        // Wait for condition. Here you can add different wait conditions.
        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver arg0) {
                System.out.println("Checking for the object!!");
                // WebElement element = arg0.findElement(By.id("dynamicText"));
                List<WebElement> elements = driver.findElements(By.className(
                    SEARCHING_TABLE));
                if (elements.size() > 0) {
                    System.out.println("A new dynamic object is found.");
                    return elements.get(0);
                }
                return null;
            }
        };
        wait.until(function);
        
        return driver.getPageSource();
    }

}
