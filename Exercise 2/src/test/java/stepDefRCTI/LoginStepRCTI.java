package stepDefRCTI;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepRCTI extends env_target {
    @Given("user is on rcti homepage")
    public void userIsOnRctiHomepage() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(rctiLink);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/nav/a/img"))
        );
    }

    @Then("user click button login")
    public void userClickButtonLogin() {
        driver.findElement(By.xpath("//*[@id='users-login']/a/div/span/img")).click();
    }

    @And("user input email or phone number")
    public void userInputEmailOrPhoneNumber() {
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("bughunters011@gmail.com");
    }

    @And("user input password")
    public void userInputPassword() {
        driver.findElement(By.id("password")).sendKeys("@Testing123");
    }

    @When("user click button login pada form login")
    public void userClickButtonLoginPadaFormLogin() {
        driver.findElement(By.id("btnLogin")).click();
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("*//span[@class='name'][contains(text(),'Testing')]")));
        //untuk lebih aman, maka dipakai contain text, takutnya ada span classname yang digunakan pada titik lain
        driver.quit();
    }

    //case negative1 and negative2
    @Then("button login is disable")
    public void buttonLoginIsDisable() {
        driver.findElement(By.id("btnLogin-ahref"));
        driver.quit();
    }

    //case negative3
    @And("user input invalid email or phone number")
    public void userInputInvalidEmailOrPhoneNumber() {
        driver.findElement(By.id("username")).sendKeys("Testing@cranium.com");
    }
    @When("user click button login on login form")
    public void userClickButtonLoginOnLoginForm() {
        driver.findElement(By.id("btnLogin")).click();
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='regv3']/div[2]/div/div[2]/div/div[1]/h4")));
        driver.quit();
    }

    //case negative4
    @And("user input invalid password")
    public void userInputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("@Yohana123");
    }
}

