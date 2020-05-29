package mandatory.test;// Generated by Selenium IDE
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.*;

public class SeleniumTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;


  @Before
  public void setUp() {
    //driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    DesiredCapabilities dc = new DesiredCapabilities();
    dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
    driver = new ChromeDriver(dc);
  }


  @After
  public void tearDown() {
    driver.quit();
  }


  // case 1 - Test Description: Verify on entering valid amount of players, the user can start the life counter game board

  @Test
  public void validPlayers() throws InterruptedException {


    ArrayList<Integer> validAmountOfPlayers = new ArrayList<Integer>( Arrays.asList(2, 3, 4, 5, 6));


    for (int i = 0; i < validAmountOfPlayers.size(); i++) {

      // Test name: case1
      // Step # | name | target | value
      // 1 | open | / |
      driver.get("http://localhost:9000/");
      // 2 | setWindowSize | 1440x877 |
      driver.manage().window().setSize(new Dimension(1440, 877));
      // 3 | click | id=players |
      driver.findElement(By.id("players")).click();
      // 4 | select | id=players | label=3
      {
        WebElement dropdown = driver.findElement(By.id("players"));
        dropdown.findElement(By.xpath("//option[. ='" + validAmountOfPlayers.get(i) + "']")).click();
      }
      // 5 | click | id=lifePoint |
      driver.findElement(By.id("lifePoint")).click();
      // 6 | type | id=lifePoint | 50
      driver.findElement(By.id("lifePoint")).sendKeys("50");
      // 7 | click | id=startButton |
      driver.findElement(By.id("startButton")).click();
      Thread.sleep(2000);

    }

  }

  // case 2 - Test Description: Verify on entering valid start life, the user can start the life counter game board

  @Test
  public void validStartLife() throws InterruptedException {

    ArrayList<Integer> validStartingLife = new ArrayList<Integer>( Arrays.asList(1, 50));

    for (int i = 0; i < validStartingLife.size(); i++) {
      // Test name: case2
      // Step # | name | target | value
      // 1 | open | / |
      driver.get("http://localhost:9000/");
      // 2 | setWindowSize | 1440x877 |
      driver.manage().window().setSize(new Dimension(1440, 877));
      // 3 | click | id=lifePoint |
      driver.findElement(By.id("lifePoint")).click();
      // 4 | type | id=lifePoint | 10
      driver.findElement(By.id("lifePoint")).sendKeys(validStartingLife.get(i).toString());
      // 5 | click | id=startButton |
      driver.findElement(By.id("startButton")).click();
      // 6 | click | id=plusPlayer1 |
      Thread.sleep(2000);
      driver.findElement(By.id("plusPlayer1")).click();
      // 7 | click | css=.column2:nth-child(1) .button |
      driver.findElement(By.cssSelector(".column2:nth-child(1) .button")).click();
      Thread.sleep(2000);

    }
  }

  // case 3 - Test Description: Verify that an alert box pops up when entering invalid start life amount.

  @Test
  public void invalidStartLife() throws InterruptedException {

    ArrayList<Integer> invalidStartingLife = new ArrayList<Integer>(Arrays.asList(-1, 0, 101, 500));

    for (int i = 0; i < invalidStartingLife.size(); i++) {

      // Test name: invalidStartLife
      // Step # | name | target | value
      // 1 | open | / |
      driver.get("http://localhost:9000/");
      // 2 | setWindowSize | 1440x877 |
      driver.manage().window().setSize(new Dimension(1440, 877));
      // 3 | click | id=players |
      driver.findElement(By.id("players")).click();
      // 4 | select | id=players | label=3
      {
        WebElement dropdown = driver.findElement(By.id("players"));
        dropdown.findElement(By.xpath("//option[. = '3']")).click();
      }
      // 5 | click | id=lifePoint |
      driver.findElement(By.id("lifePoint")).click();
      // 6 | type | id=lifePoint | 200
      driver.findElement(By.id("lifePoint")).sendKeys(invalidStartingLife.get(i).toString());
      // 7 | click | id=startButton |

      try {
        driver.findElement(By.id("startButton")).click();
        Thread.sleep(2000);
        String alert = driver.switchTo().alert().getText();
        System.out.println(alert);
      // 8 | assertAlert | The maximum amount of start life is 100. Please choose a smaller number. |
        assertThat(alert, is("Invalid start life\nPlease choose a number between 1-100"));
        driver.switchTo().alert().accept();

      } catch (UnhandledAlertException p) {
        p.printStackTrace();
      }
      // 9 | click | css=.content |
      driver.findElement(By.cssSelector(".content")).click();
    }
  }

  // case 3 - Test Description: Verify on entering valid player name input

  @Test
  public void validNames() throws InterruptedException {

    ArrayList<String> validNames = new ArrayList<String>( Arrays.asList("John Johnson", "Veronique92", "steffen", "P"));

    for (int i = 0; i < validNames.size(); i++) {

      // Test name: LC_3
      // Step # | name | target | value
      // 1 | open | / |
      driver.get("http://localhost:9000/");
      // 2 | setWindowSize | 1440x877 |
      driver.manage().window().setSize(new Dimension(1440, 877));
      // 3 | click | id=players |
      driver.findElement(By.id("players")).click();
      // 4 | select | id=players | label=3
      {
        WebElement dropdown = driver.findElement(By.id("players"));
        dropdown.findElement(By.xpath("//option[. = '3']")).click();
      }
      // 5 | click | id=lifePoint |
      driver.findElement(By.id("lifePoint")).click();
      // 6 | type | id=lifePoint | 60
      driver.findElement(By.id("lifePoint")).sendKeys("60");
      // 7 | click | id=startButton |
      driver.findElement(By.id("startButton")).click();
      Thread.sleep(2000);
      // 8 | click | css=#editBtn1 > .fa |
      driver.findElement(By.cssSelector("#editBtn1 > .fa")).click();
      // 9 | click | css=.column:nth-child(1) > .center:nth-child(1) |
      driver.findElement(By.cssSelector(".column:nth-child(1) > .center:nth-child(1)")).click();
      // 10 | type | id=playerInput1 | John Johnson
      driver.findElement(By.id("playerInput1")).clear();
      driver.findElement(By.id("playerInput1")).sendKeys(validNames.get(i));
      // 11 | click | css=#okBtn1 > .fa |
      driver.findElement(By.cssSelector("#okBtn1 > .fa")).click();
      // 12 | click | css=.column2:nth-child(1) .button |
      driver.findElement(By.cssSelector(".column2:nth-child(1) .button")).click();
    }
  }

  // case 4 - Test Description: Verify that an alert box pop up, when entering an invalid player name

  @Test
  public void invalidNames() throws InterruptedException {

    ArrayList<String> invalidNames = new ArrayList<String>(Arrays.asList("Ka!!?", "", "he**l", "mart..."));

    for (int i = 0; i < invalidNames.size(); i++) {

      // Test name: LC_4
      // Step # | name | target | value
      // 1 | open | / |
      driver.get("http://localhost:9000/");
      // 2 | setWindowSize | 1440x877 |
      driver.manage().window().setSize(new Dimension(1440, 877));
      // 3 | select | id=players | label=3
      {
        WebElement dropdown = driver.findElement(By.id("players"));
        dropdown.findElement(By.xpath("//option[. = '3']")).click();
      }
      // 4 | click | id=lifePoint |
      driver.findElement(By.id("lifePoint")).click();
      // 5 | type | id=lifePoint | 60
      driver.findElement(By.id("lifePoint")).sendKeys("60");
      // 6 | click | id=startButton |
      driver.findElement(By.id("startButton")).click();
      Thread.sleep(2000);
      // 7 | click | css=#editBtn2 > .fa |
      driver.findElement(By.cssSelector("#editBtn2 > .fa")).click();
      // 8 | click | css=.column:nth-child(2) > .center:nth-child(1) |
      driver.findElement(By.cssSelector(".column:nth-child(2) > .center:nth-child(1)")).click();
      // 9 | type | id=playerInput2 | Ka!!?
      driver.findElement(By.id("playerInput2")).clear();
      driver.findElement(By.id("playerInput2")).sendKeys(invalidNames.get(i));
      Thread.sleep(2000);
      // 10 | click | css=#okBtn2 > .fa |
      // 11 | assertAlert | Player name should be at least 1 character, and can't contain special characters.Please choose another name. |
      try {
        driver.findElement(By.cssSelector("#okBtn2 > .fa")).click();
        Thread.sleep(2000);
        String alert = driver.switchTo().alert().getText();
        System.out.println(alert);
        assertThat(alert, is("Player name should be at least 1 character, and can't contain special characters.\n Please choose another name."));
        driver.switchTo().alert().accept();

      } catch (UnhandledAlertException p) {
        p.printStackTrace();
      }
      Thread.sleep(2000);
      // 12 | click | css=.column:nth-child(2) |
      driver.findElement(By.cssSelector(".column:nth-child(2)")).click();
      // 13 | click | css=.column2:nth-child(1) .button |
      driver.findElement(By.cssSelector(".column2:nth-child(1) .button")).click();

    }
  }

  // case 5 - Test Description: Verify that pressing the minus (-) button reduces the player’s life amount.

  @Test
  public void minusLife() throws InterruptedException {

    ArrayList<Integer> validRemoveLifeInputs = new ArrayList<Integer>( Arrays.asList(6, 50, 100));
    ArrayList<Integer> validRemoveLifeOutputs = new ArrayList<Integer>( Arrays.asList(1, 45, 95));

    for (int i = 0; i < validRemoveLifeInputs.size(); i++) {


      // Test name: LC_7
      // Step # | name | target | value
      // 1 | open | / |
      driver.get("http://localhost:9000/");
      // 2 | setWindowSize | 1440x877 |
      driver.manage().window().setSize(new Dimension(1440, 877));
      // 3 | click | id=players |
      driver.findElement(By.id("players")).click();
      // 4 | select | id=players | label=3
      {
        WebElement dropdown = driver.findElement(By.id("players"));
        dropdown.findElement(By.xpath("//option[. = '3']")).click();
      }
      // 5 | click | id=lifePoint |
      driver.findElement(By.id("lifePoint")).click();
      // 6 | type | id=lifePoint | 60
      driver.findElement(By.id("lifePoint")).sendKeys(validRemoveLifeInputs.get(i).toString());
      // 7 | click | id=startButton |
      driver.findElement(By.id("startButton")).click();
      Thread.sleep(2000);
      // 8 | click | id=minusPlayer1 |
      driver.findElement(By.id("minusPlayer1")).click();
      // 9 | click | id=minusPlayer1 |
      driver.findElement(By.id("minusPlayer1")).click();
      // 10 | click | id=minusPlayer1 |
      driver.findElement(By.id("minusPlayer1")).click();
      // 11 | click | id=minusPlayer1 |
      driver.findElement(By.id("minusPlayer1")).click();
      // 12 | click | id=minusPlayer1 |
      driver.findElement(By.id("minusPlayer1")).click();
      // 13 | checks if life amount is correct |
      String expectedLifeAmount = validRemoveLifeOutputs.get(i).toString();
      String lifeAmount2 = driver.findElement(By.id("lifeAmount1")).getText();
      Assert.assertTrue("Your error message", lifeAmount2.contains(expectedLifeAmount));
      Thread.sleep(1000);
      // 14 | click | css=.column2:nth-child(1) .button |
      driver.findElement(By.cssSelector(".column2:nth-child(1) .button")).click();
    }
  }

  // case 6 - Test Description: Verify that pressing the plus (+) button adds life to the player.

  @Test
  public void plusLife() throws InterruptedException {

    ArrayList<Integer> validAddLifeInputs = new ArrayList<Integer>( Arrays.asList(1, 50, 95));
    ArrayList<Integer> validAddLifeOutputs = new ArrayList<Integer>( Arrays.asList(6, 55, 100));

    for (int i = 0; i < validAddLifeInputs.size(); i++) {

      // Test name: LC_8
      // Step # | name | target | value
      // 1 | open | / |
      driver.get("http://localhost:9000/");
      // 2 | setWindowSize | 1440x877 |
      driver.manage().window().setSize(new Dimension(1440, 877));
      // 3 | click | id=players |
      driver.findElement(By.id("players")).click();
      // 4 | select | id=players | label=3
      {
        WebElement dropdown = driver.findElement(By.id("players"));
        dropdown.findElement(By.xpath("//option[. = '3']")).click();
      }
      // 5 | click | css=.content |
      driver.findElement(By.cssSelector(".content")).click();
      // 6 | click | id=lifePoint |
      driver.findElement(By.id("lifePoint")).click();
      // 7 | type | id=lifePoint | 60
      driver.findElement(By.id("lifePoint")).sendKeys(validAddLifeInputs.get(i).toString());
      // 8 | click | id=startButton |
      driver.findElement(By.id("startButton")).click();
      Thread.sleep(1000);
      // 9 | click | id=plusPlayer2 |
      driver.findElement(By.id("plusPlayer2")).click();
      // 10 | click | id=plusPlayer2 |
      driver.findElement(By.id("plusPlayer2")).click();
      // 11 | click | id=plusPlayer2 |
      driver.findElement(By.id("plusPlayer2")).click();
      // 12 | click | id=plusPlayer2 |
      driver.findElement(By.id("plusPlayer2")).click();
      // 13 | click | id=plusPlayer2 |
      driver.findElement(By.id("plusPlayer2")).click();
      // 14 | checks if life amount is correct |
      String expectedLifeAmount = validAddLifeOutputs.get(i).toString();
      String lifeAmount2 = driver.findElement(By.id("lifeAmount2")).getText();
      Assert.assertTrue("Your error message", lifeAmount2.contains(expectedLifeAmount));
      Thread.sleep(1000);
      // 15 | click | css=.column2:nth-child(1) .button |
      driver.findElement(By.cssSelector(".column2:nth-child(1) .button")).click();
    }
  }

  // case 7 - Test Description: Verify that an alert window pops up, when a players life amount is reduced to 0.

  @Test
  public void playerLost() throws InterruptedException {


    // Test name: LC_9
    // Step # | name | target | value
    // 1 | open | / |
    driver.get("http://localhost:9000/");
    // 2 | setWindowSize | 1440x877 |
    driver.manage().window().setSize(new Dimension(1440, 877));
    // 3 | click | id=players |
    driver.findElement(By.id("players")).click();
    // 4 | select | id=players | label=3
    {
      WebElement dropdown = driver.findElement(By.id("players"));
      dropdown.findElement(By.xpath("//option[. = '3']")).click();
    }
    // 5 | click | id=lifePoint |
    driver.findElement(By.id("lifePoint")).click();
    // 6 | type | id=lifePoint | 10
    driver.findElement(By.id("lifePoint")).sendKeys("10");
    // 7 | click | id=startButton |
    driver.findElement(By.id("startButton")).click();
    Thread.sleep(2000);
    // 8 | click | id=minusPlayer3 |
    driver.findElement(By.id("minusPlayer3")).click();
    // 9 | click | id=minusPlayer3 |
    driver.findElement(By.id("minusPlayer3")).click();
    // 10 | doubleClick | id=minusPlayer3 |
    {
      WebElement element = driver.findElement(By.id("minusPlayer3"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    // 11 | click | id=minusPlayer3 |
    driver.findElement(By.id("minusPlayer3")).click();
    // 12 | click | id=minusPlayer3 |
    driver.findElement(By.id("minusPlayer3")).click();
    // 13 | click | id=minusPlayer3 |
    driver.findElement(By.id("minusPlayer3")).click();
    // 14 | click | id=minusPlayer3 |
    driver.findElement(By.id("minusPlayer3")).click();
    // 15 | click | id=minusPlayer3 |
    driver.findElement(By.id("minusPlayer3")).click();
    // 16 | click | id=minusPlayer3 |
    driver.findElement(By.id("minusPlayer3")).click();
    // 17 | click | id=minusPlayer3 |
    driver.findElement(By.id("minusPlayer3")).click();
    // 18 | click | id=minusPlayer3 |
    driver.findElement(By.id("minusPlayer3")).click();
    Thread.sleep(2000);
    // 19 | assertAlert | Player 3 has lost! |

    try {
      driver.findElement(By.id("minusPlayer3")).click();
      Thread.sleep(2000);
    } catch (UnhandledAlertException f) {
      try {
        String alert = driver.switchTo().alert().getText();
        System.out.println(alert);
        assertThat(alert, is("Player 3 has lost!"));
        driver.switchTo().alert().accept();
      } catch (NoAlertPresentException e) {
        e.printStackTrace();
      }
    }
    // 20 | click | css=.content |
    driver.findElement(By.cssSelector(".content")).click();
    // 21 | click | css=.column2:nth-child(1) .button |
    driver.findElement(By.cssSelector(".column2:nth-child(1) .button")).click();
  }


// case 8 - Test Description: Verify that the reset life button will reset all players life count back to the start life.

  @Test
  public void resetLife() throws InterruptedException {

    ArrayList<Integer> validResetLifeInputs = new ArrayList<Integer>(Arrays.asList(20, 45, 100));
    ArrayList<Integer> validResetLifeOutputs = new ArrayList<Integer>(Arrays.asList(20, 45, 100));

    for (int i = 0; i < validResetLifeInputs.size(); i++) {

      // Test name: LC_10
      // Step # | name | target | value
      // 1 | open | / |
      driver.get("http://localhost:9000/");
      // 2 | setWindowSize | 1440x877 |
      driver.manage().window().setSize(new Dimension(1440, 877));
      // 3 | click | id=players |
      driver.findElement(By.id("players")).click();
      // 4 | select | id=players | label=3
      {
        WebElement dropdown = driver.findElement(By.id("players"));
        dropdown.findElement(By.xpath("//option[. = '3']")).click();
      }
      // 5 | click | id=lifePoint |
      driver.findElement(By.id("lifePoint")).click();
      // 6 | type | id=lifePoint | 40
      driver.findElement(By.id("lifePoint")).sendKeys(validResetLifeInputs.get(i).toString());
      // 7 | click | id=startButton |
      driver.findElement(By.id("startButton")).click();
      Thread.sleep(2000);
      // 8 | click | id=minusPlayer1 |
      driver.findElement(By.id("minusPlayer1")).click();
      // 9 | click | id=minusPlayer1 |
      driver.findElement(By.id("minusPlayer1")).click();
      // 10 | doubleClick | id=minusPlayer1 |
      {
        WebElement element = driver.findElement(By.id("minusPlayer1"));
        Actions builder = new Actions(driver);
        builder.doubleClick(element).perform();
      }
      // 11 | click | id=minusPlayer1 |
      driver.findElement(By.id("minusPlayer1")).click();
      // 12 | click | id=minusPlayer1 |
      driver.findElement(By.id("minusPlayer1")).click();
      // 13 | click | css=.column:nth-child(2) .lifeBox |
      driver.findElement(By.cssSelector(".column:nth-child(2) .lifeBox")).click();
      // 14 | click | id=plusPlayer2 |
      driver.findElement(By.id("plusPlayer2")).click();
      // 15 | click | id=plusPlayer2 |
      driver.findElement(By.id("plusPlayer2")).click();
      // 16 | doubleClick | id=plusPlayer2 |
      {
        WebElement element = driver.findElement(By.id("plusPlayer2"));
        Actions builder = new Actions(driver);
        builder.doubleClick(element).perform();
      }
      // 17 | click | id=plusPlayer2 |
      driver.findElement(By.id("plusPlayer2")).click();
      // 18 | click | id=plusPlayer2 |
      driver.findElement(By.id("plusPlayer2")).click();
      // 19 | click | id=plusPlayer2 |
      driver.findElement(By.id("plusPlayer2")).click();
      // 20 | click | id=plusPlayer2 |
      driver.findElement(By.id("plusPlayer2")).click();
      // 21 | click | id=minusPlayer3 |
      driver.findElement(By.id("minusPlayer3")).click();
      // 22 | click | id=minusPlayer3 |
      driver.findElement(By.id("minusPlayer3")).click();
      // 23 | doubleClick | id=minusPlayer3 |
      {
        WebElement element = driver.findElement(By.id("minusPlayer3"));
        Actions builder = new Actions(driver);
        builder.doubleClick(element).perform();
      }
      // 24 | click | css=.column2:nth-child(2) .button |
      driver.findElement(By.cssSelector(".column2:nth-child(2) .button")).click();
      Thread.sleep(2000);
      String expectedLifeAmount = validResetLifeOutputs.get(i).toString();
      String lifeAmount1 = driver.findElement(By.id("lifeAmount1")).getText();
      String lifeAmount2 = driver.findElement(By.id("lifeAmount2")).getText();
      String lifeAmount3 = driver.findElement(By.id("lifeAmount3")).getText();
      assertTrue("Life doesn't match expected reset life output", lifeAmount1.contains(expectedLifeAmount));
      assertTrue("Life doesn't match expected reset life output", lifeAmount2.contains(expectedLifeAmount));
      assertTrue("Life doesn't match expected reset life output", lifeAmount3.contains(expectedLifeAmount));
      // 25 | click | css=.column2:nth-child(1) .button |
      driver.findElement(By.cssSelector(".column2:nth-child(1) .button")).click();
      Thread.sleep(1000);
    }
  }

  // case 9 - Test Description: Verify that new game button will lead you to the new game page

  @Test
  public void newGame() throws InterruptedException {

    // Test name: LC_11
    // Test Description: Verify that new game button will lead you to the new game page

    // Step # | name | target | value
    // 1 | open | / |
    driver.get("http://localhost:9000/");
    // 2 | setWindowSize | 1440x877 |
    driver.manage().window().setSize(new Dimension(1440, 877));
    // 3 | click | id=players |
    driver.findElement(By.id("players")).click();
    // 4 | click | id=lifePoint |
    driver.findElement(By.id("lifePoint")).click();
    // 5 | type | id=lifePoint | 20
    driver.findElement(By.id("lifePoint")).sendKeys("20");
    // 6 | click | id=startButton |
    driver.findElement(By.id("startButton")).click();
    Thread.sleep(2000);
    // 7 | click | css=.content > .center:nth-child(3) |
    driver.findElement(By.cssSelector(".content > .center:nth-child(3)")).click();
    // 8 | click | css=.column2:nth-child(1) .button |
    driver.findElement(By.cssSelector(".column2:nth-child(1) .button")).click();
    // 9 | click | id=players |
    String expectedIdText = "PLAYERS";
    String text = driver.findElement(By.id("choosePlayer")).getText();
    assertTrue("text doesn't match expected id", text.contains(expectedIdText));
    Thread.sleep(2000);

  }


  @Test
  public void plusLifeToMax() throws InterruptedException {


      // Test name: LC_8
      // Step # | name | target | value
      // 1 | open | / |
      driver.get("http://localhost:9000/");
      // 2 | setWindowSize | 1440x877 |
      driver.manage().window().setSize(new Dimension(1440, 877));
      // 3 | click | id=players |
      driver.findElement(By.id("players")).click();
      // 4 | select | id=players | label=3
      {
        WebElement dropdown = driver.findElement(By.id("players"));
        dropdown.findElement(By.xpath("//option[. = '3']")).click();
      }
      // 5 | click | css=.content |
      driver.findElement(By.cssSelector(".content")).click();
      // 6 | click | id=lifePoint |
      driver.findElement(By.id("lifePoint")).click();
      // 7 | type | id=lifePoint | 60
      driver.findElement(By.id("lifePoint")).sendKeys("100");
      // 8 | click | id=startButton |
      driver.findElement(By.id("startButton")).click();
      Thread.sleep(1000);
      // 9 | click | id=plusPlayer2 |

    for (int i = 0; i < 400; i++) {
      driver.findElement(By.id("plusPlayer2")).click();

    }

    try {
      driver.findElement(By.id("plusPlayer2")).click();
      Thread.sleep(2000);
    } catch (UnhandledAlertException f) {
      try {
        // 10 | AssertThat alert is correct|
        String alert = driver.switchTo().alert().getText();
        System.out.println(alert);
        assertThat(alert, is("Maximum life reached"));
        driver.switchTo().alert().accept();
      } catch (NoAlertPresentException e) {
        e.printStackTrace();
      }
    }

      // 11 | click | css=.column2:nth-child(1) .button |
      driver.findElement(By.cssSelector(".column2:nth-child(1) .button")).click();
  }


   // Roll dice???????
//  @Test
//  public void dice() throws InterruptedException {
//    // Test name: dice
//    // Step # | name | target | value
//    // 1 | open | / |
//    driver.get("http://localhost:9000/");
//    // 2 | setWindowSize | 1440x877 |
//    driver.manage().window().setSize(new Dimension(1440, 877));
//    // 3 | click | id=players |
//    driver.findElement(By.id("players")).click();
//    // 4 | select | id=players | label=3
//    {
//      WebElement dropdown = driver.findElement(By.id("players"));
//      dropdown.findElement(By.xpath("//option[. = '3']")).click();
//    }
//    // 5 | click | id=lifePoint |
//    driver.findElement(By.id("lifePoint")).click();
//    // 6 | type | id=lifePoint | 40
//    driver.findElement(By.id("lifePoint")).sendKeys("40");
//    // 7 | click | id=startButton |
//    driver.findElement(By.id("startButton")).click();
//    Thread.sleep(2000);
//    // 8 | click | css=.center:nth-child(5) > .button |
//    driver.findElement(By.cssSelector(".center:nth-child(5) > .button")).click();
//    // 9 | click | css=.center:nth-child(5) > .button |
//    driver.findElement(By.cssSelector(".center:nth-child(5) > .button")).click();
//    // 10 | click | css=.center:nth-child(5) > .button |
//    driver.findElement(By.cssSelector(".center:nth-child(5) > .button")).click();
//    // 11 | click | css=.center:nth-child(5) > .button |
//    driver.findElement(By.cssSelector(".center:nth-child(5) > .button")).click();
//    // 12 | click | css=.center:nth-child(5) > .button |
//    driver.findElement(By.cssSelector(".center:nth-child(5) > .button")).click();
//    // 13 | click | css=.center:nth-child(5) > .button |
//    driver.findElement(By.cssSelector(".center:nth-child(5) > .button")).click();
//    // 14 | click | css=.column2:nth-child(1) .button |
//    driver.findElement(By.cssSelector(".column2:nth-child(1) .button")).click();
//  }

}
