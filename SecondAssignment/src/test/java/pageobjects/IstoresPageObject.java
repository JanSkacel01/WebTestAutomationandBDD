package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IstoresPageObject {

    WebDriver driver;
    private WebElement firstProduct;
    private String firstProductText;

    public IstoresPageObject(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void goToCategory(String category) {
        driver.findElement(By.xpath("//a[text() = '" + category + " ']")).click();
    }

    public boolean numOfProductsBiggerThan(int num) {
        WebElement resultElement = driver.findElement(By.xpath("//span[@class='fw-bold']"));
        String result = resultElement.getText().replaceAll("\\D", "");;
        return Integer.parseInt(result) > num;
    }
    public boolean searchingNumOfProductsBiggerThan(int num) {
        WebElement resultElement = driver.findElement(By.xpath("//span[@class='fw-normal']"));
        String result = resultElement.getText().replaceAll("\\D", "");;
        return Integer.parseInt(result) > num;
    }

    public void clickOnFirstProduct() {
        firstProduct = driver.findElement(By.xpath("//a[@data-cy='product-card-title-link']"));
        saveFirstProductText();
        firstProduct.sendKeys(Keys.ENTER);
    }

    private void saveFirstProductText() {
        firstProductText = firstProduct.getText();
    }

    public String returnProductText() {
        return firstProductText;
    }

    public void searchForProduct(String product) {
        WebElement search = driver.findElement(By.id("q"));
        search.sendKeys(product);
        search.sendKeys(Keys.ENTER);
    }
}
