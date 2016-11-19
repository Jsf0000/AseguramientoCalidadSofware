
import java.util.regex.Pattern;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PruebaCelinion {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    File file = new File("C:\\geckodriver.exe");
    System.setProperty("webdriver.gecko.driver",file.getAbsolutePath());
    driver = new FirefoxDriver();
    baseUrl = "https://accounts.google.com/ServiceLogin?hl=es&passive=true&continue=https://www.google.es/#identifier";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testPrueba2() throws Exception {
    driver.get(baseUrl + "/ServiceLogin?hl=es&passive=true&continue=https://www.google.es/#identifier");
    for (int second = 0;; second++) {
        if (second >= 60) fail("timeout");
        try { if ("Inicio de sesión - Cuentas de Google".equals(driver.getTitle())) break; } catch (Exception e) {}
        Thread.sleep(1000);
    }

    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("aaa");
    driver.findElement(By.id("next")).click();
    Thread.sleep(4000);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
