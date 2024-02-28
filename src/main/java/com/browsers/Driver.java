package com.browsers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public interface Driver<T> {

    T options(); // driver options

    WebDriver driver(); // actual driver creation

    default WebDriver init() { // driver initialization

        WebDriver driver = driver();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(0));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(0));

        return driver;
    }
}