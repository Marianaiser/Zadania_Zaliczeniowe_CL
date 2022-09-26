package pl.coderslab;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.model.HotelLoginPage;
import pl.coderslab.model.HotelMainPage;
import pl.coderslab.model.HotelMyAccountPage;
import pl.coderslab.model.TestUser;

import java.time.Duration;
import java.util.Random;

public class AdressChangeTest {
    private final static String PERMANENT_LOGIN = "mytest@cl-test.com";
    private final static String PERMANENT_PASSWORD = "mytestPassword";
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get("https://hotel-testlab.coderslab.pl/en/");


    }

    @Test
    public void logInUser() {
        String email = new Random().nextInt(100000000) + "TEA26@test.com";

        HotelMainPage hotelMainPage = new HotelMainPage(this.driver);
        hotelMainPage.clickSignIn();
        HotelLoginPage hotelLoginPage = new HotelLoginPage(this.driver);
        hotelLoginPage.signInWithCredentials(PERMANENT_LOGIN, PERMANENT_PASSWORD);
        HotelMyAccountPage hotelMyAccountPage = new HotelMyAccountPage(this.driver);
        hotelMyAccountPage.changeAdress();
        hotelMyAccountPage.newAddress();
        TestUser testUser = new TestUser(this.driver);
        testUser.newName("Arkadiusz");
        testUser.newLastName("Testerosielski");
        testUser.newAdress("Testerska 5");
        testUser.newZip("59220");
        testUser.newCity("Legnica");
        testUser.insertHomePhone("11111111");
        testUser.addMobilePhone("+48123455678");
        testUser.addressAssign("xyz");


    }
}