package com.cybertek.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Gmail {
    WebDriver driver;

    @BeforeMethod
    public void setUP(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://mail.google.com/mail/u/6/#inbox");
        
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        
        driver.findElement(By.id("identifierId")).sendKeys("testfortestcase@gmail.com", Keys.ENTER);
        
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        
        password.sendKeys("159357.Emre",Keys.ENTER);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void mailSend(){
       

        //click compose
        driver.findElement(By.cssSelector(".T-I.T-I-KE.L3")).click();

        //type to receiver
        driver.findElement(By.className("vO")).sendKeys("yunusozudogru34@gmail.com");
        //type to subject
        driver.findElement(By.className("aoT")).sendKeys("this is a test Mail");
        //type to message
        driver.findElement(By.className("Am")).sendKeys("This is my first Automation Mail");
        //Send to mail
        driver.findElement(By.className("aoO")).click();


    }

}
