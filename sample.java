import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class sample {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.browserstack.com/users/sign_in");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(35000));


//        WebElement login = driver.findElement(By.xpath("//a[@data-oauth-type='google']")); // login > Click
        WebElement email = driver.findElement(By.id("user_email_login")); // email > SendKeys >> 
        WebElement pass = driver.findElement(By.id("user_password")); // email > SendKeys >>
        WebElement submit_btn = driver.findElement(By.id("user_submit")); // Submit > click

//        login.click();
        email.sendKeys("Zubdsdsaf@gmail.com");
        pass.sendKeys("yasddggaiw");
        submit_btn.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3500));



// Create an instance of the Actions class.
        Actions actions = new Actions(driver);
        List<WebElement> Brand_Name = driver.findElements(By.className("vendors-list__name"));     // Brand Name > Click

        for (WebElement element : Brand_Name) {


            element.click();
            System.out.println(element.getText());

            List<WebElement> Android_Phones = driver.findElements(By.cssSelector("div.real-device-item")); // Android Phone Name > Mouse Hover

            for (WebElement element1 : Android_Phones) {
                element1.click();

                System.out.println(element1.getText());

                WebElement Chrome_Browser = driver.findElement(By.cssSelector("div.real-device-item__browser-container > div:nth-child(1)")); // Chrome > Click

                // Perform the mouse hover action on the element.
                actions.moveToElement(Chrome_Browser).perform();

                Chrome_Browser.click();
                System.out.println(element1.getText());

                WebElement device_info = driver.findElement(By.id("device-info")); // device_info > Click

                device_info.click();

                WebElement device_name = driver.findElement(By.id("device-info-head")); // device_name > collect information
                String device_name_str = device_name.getText();

                WebElement device_full_info = driver.findElement(By.id("device-info-body")); // device_full_info > collect information
                String device_full_info_str = device_full_info.getText();



                // Print the text to the console
                System.out.println("device_name_str: " + device_name_str);

                System.out.println(">>>>>> ");

                System.out.println("device_full_info_str: " + device_full_info_str);
            }
        }

        driver.quit();


    }
}
