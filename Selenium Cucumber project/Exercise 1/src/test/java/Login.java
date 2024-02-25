import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class Login extends env_target{
    @Test
    public void loginSuccess (){
        //Set driverLocation path
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //Maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Set url
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        //Untuk mendeklarasikan expected result dari testcase yang dilakukan
        //Dalam hal ini, saat membuka link website, maka akan muncul button login (By.xpath("//*[@id='user-name']")
        wait.until(       
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user-name']"))
        );
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        //untuk expected result nya akan menampilakam wording "Produts" maka dari itu, digunakan xpath class title, karena xpath class title teralu umum,
        //maka dibikin contains text wording apa yang akan muncul, dalam hal ini adalah wording 'Products'
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title'][contains(text(),'Products')]"))
        );
        driver.quit();
    }

    @Test
    //login with invalid username
    public void loginFailedIn (){
        //Set driverLocation path
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //Maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Set url
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        //Untuk mendeklarasikan expected result dari testcase yang dilakukan
        //Dalam hal ini, saat membuka link website, maka akan muncul button login (By.xpath("//*[@id='user-name']")
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user-name']"))
        );
        driver.findElement(By.name("user-name")).sendKeys("standard_sauce");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        //untuk expected result nya akan menampilakam wording "Produts" maka dari itu, digunakan xpath class title, karena xpath class title teralu umum,
        //maka dibikin contains text wording apa yang akan muncul, dalam hal ini adalah wording 'Products'
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3/button"))
        );
        driver.quit();
    }
}
