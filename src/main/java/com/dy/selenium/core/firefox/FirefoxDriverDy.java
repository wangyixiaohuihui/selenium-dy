package com.dy.selenium.core.firefox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class FirefoxDriverDy {


    public static void main(String[] args) {

        WebDriver driver;   //声明WebDriver

        System.setProperty ( "webdriver.firefox.bin" ,
                "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe" );
        System.setProperty("webdriver.firefox.marionette",
                "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        //指定Firefox浏览器的路径
        String Url = "https://www.douyu.com/";   //百度的地址
        driver =new FirefoxDriver();        //new一个FirefoxDriver()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    //设置隐式等待10秒钟
        driver.get(Url);    //打开百度首页
        driver.manage().window().maximize();    //把浏览器窗口最大化

        driver.findElement(By.cssSelector(".u-login.fl")).click();


        WebDriver loginDriver= driver.switchTo().frame("login-passport-frame");

        loginDriver.findElement(By.cssSelector(".scancide-to.js-to-link.js-need-param.fr")).click();

        try {
            Thread.sleep(10000);     //让线程等待3秒钟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();  //退出driver

    }
}
