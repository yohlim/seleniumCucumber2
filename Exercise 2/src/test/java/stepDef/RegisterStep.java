package stepDef;

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
import java.util.Random;

public class RegisterStep extends env_target {

    @Given("^user is on parabank homepage$")
    public void userIsOnParabankHomepage() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(parabankLink);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rightPanel']/ul[1]/li[1]"))
        );
    }

    @When("^user click register link button$")
    public void userClickRegisterLinkButton() {
        driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a")).click();

    }

    @Then("^user is in register page$")
    public void userIsInRegisterPage() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rightPanel']/h1"))
        );
    }

    @When("^user input name$")
    public void userInputName() {

        driver.findElement(By.id("customer.firstName")).sendKeys("4444");
        driver.findElement(By.id("customer.lastName")).sendKeys("4444");
    }

    @And("^user input address detail$")
    public void userInputAddressDetail() {
        //user input address
        driver.findElement(By.xpath("//*[@id='customer.address.street']")).sendKeys("4444");
        //user input city
        driver.findElement(By.xpath("//*[@class='input'][@id='customer.address.city']")).sendKeys("4444");
        //user input state
        driver.findElement(By.xpath("//*[@id='customer.address.state']")).sendKeys("4444");
        //user input Zipcode
        driver.findElement(By.xpath("//*[@id='customer.address.zipCode']")).sendKeys("4444");
        //user input phone
        driver.findElement(By.xpath("//*[@id='customer.phoneNumber']")).sendKeys("4444");
        //user input SSN
        driver.findElement(By.xpath("//*[@id='customer.ssn']")).sendKeys("4444");
    }

    @And("^user fill valid username and password$")
    public void userFillValidUsernameAndPassword() {
        Random rand = new Random();
        int userRand = rand.nextInt(100000);
        //input username
        driver.findElement(By.id("customer.username")).sendKeys("test" + userRand); //pake '+' karna username terdiri dari 2 kata, dan 'userRand' berfungsi untuk mengcreate angka random setelah kata pertama :)
        //input password
        driver.findElement(By.id("customer.password")).sendKeys("4444");
    }

    @And("^user input password confirmation$")
    public void userInputPasswordConfirmation() {
        driver.findElement(By.id("repeatedPassword")).sendKeys("4444");
    }

    @When("^user click register button$")
    public void userClickRegisterButton() {
        driver.findElement(By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input")).click();
    }

    @Then("^user regist succesfully$")
    public void userRegistSuccesfully() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rightPanel']/p"))
        );
        driver.quit();
    }


    // test step for case negative1
    @And("^user input invalid password confirmation$")
    public void userInputInvalidPasswordConfirmation() {
        driver.findElement(By.xpath("//*[@id='repeatedPassword']")).sendKeys("55555");
    }

    @Then("^user get err password did not match$")
    public void userGetErrPasswordDidNotMatch() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='repeatedPassword.errors']"))
        );
        // public static void closeBrowser(){
        driver.quit();
    }


    // test step for case negative2
    @And("user fill username and password has been registered before")
    public void userFillUsernameAndPasswordHasBeenRegisteredBefore() {
        //input username
        driver.findElement(By.id("customer.username")).sendKeys("0000");// input username yang sudah pernah melakukan register
        //input password
        driver.findElement(By.id("customer.password")).sendKeys("0000");

    }

    @And("user input password confirmation username has been registered")
    public void userInputPasswordConfirmationUsernameHasBeenRegistered() {
        driver.findElement(By.id("repeatedPassword")).sendKeys("0000");
    }

    @Then("user get message This username already exists")
    public void userGetMessageThisUsernameAlreadyExists() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='customer.username.errors']"))
        );
        driver.quit();
    }

    // test step for case negative3
    @Then("user get message required on each field")
    public void userGetMessageRequiredOnEachField() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='footermainPanel']"))
        );
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("customer.lastName.errors"))
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("customer.address.street.errors"))
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='customer.address.city.errors']"))
                );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='customer.address.city.errors']"))
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='customer.address.city.errors']"))
        );
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='customer.address.state.errors']"))
        );
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='customer.address.zipCode.errors']"))
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='customer.ssn.errors']"))
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='customer.username.errors']"))
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='customer.password.errors']"))
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='repeatedPassword.errors']"))

        );


        driver.quit();

    }
    // test step for case negative4
    @And("user input field lastname")
    public void userInputFieldLastName(){

        driver.findElement(By.id("customer.lastName")).sendKeys("4444");
    }

    @Then("user get message First name is required.")
    public void userGetMessageFirstNameIsRequired() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='footermainPanel']"))
        );

        driver.quit();
    }
    // test step for case negative5

    @And("user input field firstname")
    public void userInputFieldFirstname() {
        driver.findElement(By.xpath("//*[@id='customer.firstName']")).sendKeys("namaku");
    }

    @Then("user get message lastname is required.")
    public void userGetMessageLastnameIsRequired() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='customer.lastName.errors']"))
        );

        driver.quit();

    }
    // test step for case negative6

    @And("user input field city,state,zipcode,phone,dan ssn")
    public void userInputFieldCityStateZipcodePhoneDanSsn() {//user input city
        driver.findElement(By.xpath("//*[@class='input'][@id='customer.address.city']")).sendKeys("4444");
        //user input state
        driver.findElement(By.xpath("//*[@id='customer.address.state']")).sendKeys("4444");
        //user input Zipcode
        driver.findElement(By.xpath("//*[@id='customer.address.zipCode']")).sendKeys("4444");
        //user input phone
        driver.findElement(By.xpath("//*[@id='customer.phoneNumber']")).sendKeys("4444");
        //user input SSN
        driver.findElement(By.xpath("//*[@id='customer.ssn']")).sendKeys("4444");
    }

    @Then("user get message address is required.")
    public void userGetMessageAddressIsRequired() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("customer.firstName"))
        );

        driver.quit();

    }

    // test step for case negative7

    @And("user input field address,state,zipcode,phone,dan ssn")
    public void userInputFieldAddressStateZipcodePhoneDanSsn() {
        //user input address
        driver.findElement(By.xpath("//*[@id='customer.address.street']")).sendKeys("4444");
        //user input state
        driver.findElement(By.xpath("//*[@id='customer.address.state']")).sendKeys("4444");
        //user input Zipcode
        driver.findElement(By.xpath("//*[@id='customer.address.zipCode']")).sendKeys("4444");
        //user input phone
        driver.findElement(By.xpath("//*[@id='customer.phoneNumber']")).sendKeys("4444");
        //user input SSN
        driver.findElement(By.xpath("//*[@id='customer.ssn']")).sendKeys("4444");

    }

    @Then("user get message city is required.")
    public void userGetMessageCityIsRequired() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("customer.address.city.errors"))
        );

        driver.quit();

    }

    // test step for case negative8

    @And("user input field address,city,zipcode,phone,dan ssn")
    public void userInputFieldAddressCityZipcodePhoneDanSsn() {
        //user input address
        driver.findElement(By.xpath("//*[@id='customer.address.street']")).sendKeys("4444");
        //user input city
        driver.findElement(By.xpath("//*[@class='input'][@id='customer.address.city']")).sendKeys("4444");
        //user input Zipcode
        driver.findElement(By.xpath("//*[@id='customer.address.zipCode']")).sendKeys("4444");
        //user input phone
        driver.findElement(By.xpath("//*[@id='customer.phoneNumber']")).sendKeys("4444");
        //user input SSN
        driver.findElement(By.xpath("//*[@id='customer.ssn']")).sendKeys("4444");

    }

    @Then("user get message state is required.")
    public void userGetMessageStateIsRequired() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("customer.address.state.errors"))
        );

        driver.quit();
    }

    // test step for case negative9

    @And("user input field address,city,state,phone,dan ssn")
    public void userInputFieldAddressCityStatePhoneDanSsn() {
        //user input address
        driver.findElement(By.xpath("//*[@id='customer.address.street']")).sendKeys("4444");
        //user input city
        driver.findElement(By.xpath("//*[@class='input'][@id='customer.address.city']")).sendKeys("4444");
        //user input state
        driver.findElement(By.xpath("//*[@id='customer.address.state']")).sendKeys("4444");
        //user input phone
        driver.findElement(By.xpath("//*[@id='customer.phoneNumber']")).sendKeys("4444");
        //user input SSN
        driver.findElement(By.xpath("//*[@id='customer.ssn']")).sendKeys("4444");
    }


    @Then("user get message zipcode is required.")
    public void userGetMessageZipcodeIsRequired() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("customer.address.zipCode.errors"))
        );

        driver.quit();
    }

    // test step for case negative10
    @And("user input field address,city,state,zipcode,dan ssn")
    public void userInputFieldAddressCityStateZipcodeDanSsn() {
        //user input address
        driver.findElement(By.xpath("//*[@id='customer.address.street']")).sendKeys("4444");
        //user input city
        driver.findElement(By.xpath("//*[@class='input'][@id='customer.address.city']")).sendKeys("4444");
        //user input state
        driver.findElement(By.xpath("//*[@id='customer.address.state']")).sendKeys("4444");
        //user input Zipcode
        driver.findElement(By.xpath("//*[@id='customer.address.zipCode']")).sendKeys("4444");
        //user input SSN
        driver.findElement(By.xpath("//*[@id='customer.ssn']")).sendKeys("4444");
    }


    // test step for case negative11
    @And("user input field address,city,state,zipcode")
    public void userInputFieldAddressCityStateZipcode() {
        //user input address
        driver.findElement(By.xpath("//*[@id='customer.address.street']")).sendKeys("4444");
        //user input city
        driver.findElement(By.xpath("//*[@class='input'][@id='customer.address.city']")).sendKeys("4444");
        //user input state
        driver.findElement(By.xpath("//*[@id='customer.address.state']")).sendKeys("4444");
        //user input Zipcode
        driver.findElement(By.xpath("//*[@id='customer.address.zipCode']")).sendKeys("4444");
    }

    @Then("user get message Social Security Number is required.")
    public void userGetMessageSocialSecurityNumberIsRequired() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("customer.ssn.errors"))
        );

        driver.quit();
    }

    // test step for case negative12
    @And("user input field address,city,state,zipcode,phone,dan ssn")
    public void userInputFieldAddressCityStateZipcodePhoneDanSsn() {
        //user input address
        driver.findElement(By.xpath("//*[@id='customer.address.street']")).sendKeys("4444");
        //user input city
        driver.findElement(By.xpath("//*[@class='input'][@id='customer.address.city']")).sendKeys("4444");
        //user input state
        driver.findElement(By.xpath("//*[@id='customer.address.state']")).sendKeys("4444");
        //user input Zipcode
        driver.findElement(By.xpath("//*[@id='customer.address.zipCode']")).sendKeys("4444");
        //user input phone
        driver.findElement(By.xpath("//*[@id='customer.phoneNumber']")).sendKeys("4444");
        //user input SSN
        driver.findElement(By.xpath("//*[@id='customer.ssn']")).sendKeys("4444");
    }

    @And("user fill valid password")
    public void userFillValidPassword() {
        Random rand = new Random();
        int userRand = rand.nextInt(100000);
        //input password
        driver.findElement(By.id("customer.password")).sendKeys("4444");
    }

    @Then("user get message username is required.")
    public void userGetMessageUsernameIsRequired() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("customer.username.errors"))
        );

        driver.quit();
    }

    // test step for case negative13
    @And("user input username confirmation")
    public void userInputUsernameConfirmation() {
        Random rand = new Random();
        int userRand = rand.nextInt(100000);
        //input username
        driver.findElement(By.id("customer.username")).sendKeys("test" + userRand); //pake '+' karna username terdiri dari 2 kata, dan 'userRand' berfungsi untuk mengcreate angka random setelah kata pertama :)
    }
    @Then("user get message password is required.")
    public void userGetMessagePasswordIsRequired() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("customer.password.errors"))
        );

        driver.quit();

    }


    // test step for case negative14
    @Then("user get message password confirmation is required.")
    public void userGetMessagePasswordConfirmationIsRequired() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("repeatedPassword.errors"))
        );

        driver.quit();
    }

}