package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Pages.pageBase.shortwait;

public class P03_item {
    WebDriver driver;
    public P03_item(WebDriver driver){
        this.driver = driver;
    }


    private final By inventory_item = By.cssSelector("a[id=\"item_5_title_link\"]>div");
    private final By itempage = By.cssSelector("div[class=\"inventory_details_name large_size\"]");

    public P03_item click_on_item(){
       //  call wait
              try {
                  shortwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.inventory_item));
              }catch (TimeoutException ex) {
                ex.printStackTrace();
            }
              driver.findElement(this.inventory_item).click();
              return this;
    }
   public String return_item_text_inventory (){
           return driver.findElement(this.inventory_item).getText();
       }
    public String return_item_text(){
        return driver.findElement(this.itempage).getText();
    }



}
