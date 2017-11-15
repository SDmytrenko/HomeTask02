import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by girl-hamster on 08.11.2017.
 */
public class LaunchTest {
    public static void main(String[] args){
        //script01();
        script02();
    }
   public static WebDriver initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe" );
        return new ChromeDriver();
   }

   public static void script01(){
       try{
       WebDriver driver = initChromeDriver();
       driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
       WebElement email = driver.findElement(By.id("email"));
       WebElement password = driver.findElement(By.id("passwd"));
       WebElement button = driver.findElement(By.name("submitLogin"));
       email.sendKeys("webinar.test@gmail.com");
       password.sendKeys("Xcg7299bnSmMuRLp9ITw");
       button.click();
       Thread.sleep(1000);
       WebElement icon = driver.findElement(By.id("employee_infos"));
       WebElement logout = driver.findElement(By.id("header_logout"));
       icon.click();
       logout.click();
   }
   catch(Exception  e){

    }}
   public static void script02(){
       try {
           WebDriver driver = initChromeDriver();
           driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
           WebElement email = driver.findElement(By.id("email"));
           WebElement password = driver.findElement(By.id("passwd"));
           WebElement button = driver.findElement(By.name("submitLogin"));
           email.sendKeys("webinar.test@gmail.com");
           password.sendKeys("Xcg7299bnSmMuRLp9ITw");
           button.click();
           Thread.sleep(1000);

           WebElement dashboardLink = driver.findElement(By.cssSelector("a.title"));
           List <WebElement> menuItems = driver.findElements(By.cssSelector("a.has_submenu"));
           menuItems.set(0, dashboardLink);
           List <String> links = new ArrayList<String>();
           for (WebElement i: menuItems){
              links.add(i.getAttribute("href"));
               }

           for (String s: links){
               driver.get(s);
               String title = driver.findElement(By.tagName("h2")).getText();
               System.out.println(title);
               driver.navigate().refresh();
               Thread.sleep(1000);
               if(title.equals(driver.findElement(By.tagName("h2")).getText())){
                   System.out.println("Passed");
               }
               else{
                   System.out.println("Failed");
               }

           }
       
       }
       catch (Exception e){

       }
   }
}
