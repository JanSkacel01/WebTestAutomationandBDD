package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.IstoresPageObject;

public class IStoresSteps {

    WebDriver driver;
    IstoresPageObject iStores;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/jenik/Downloads/webtesting/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }


    @Given("I am a user of the website")
    public void iAmAUserOfTheWebsite() {
        iStores = new IstoresPageObject(driver);
    }

    @When("I visit the news website")
    public void iVisitTheNewsWebsite() {
        driver.get("https://www.istores.cz/");
    }

    @And("I click on the {string} category")
    public void iClickOnTheCategory(String arg0) {
        iStores.goToCategory(arg0);
    }

    @Then("I should be taken to {string} category")
    public void iShouldBeTakenToCategory(String arg0) {
        Assertions.assertEquals(arg0 +" | iStores - Apple Premium Reseller - iPhone, iPad, Mac, iPod", driver.getTitle());
    }

    @And("the category should show at least {int} products")
    public void theCategoryShouldShowAtLeastNumProductsProducts(int arg0) {
        Assertions.assertTrue(iStores.numOfProductsBiggerThan(arg0));
    }

    @When("I click on the first product in the results")
    public void iClickOnTheFirstProductInTheResults() {
        iStores.clickOnFirstProduct();
    }

    @Then("I should be taken to the details page for that product")
    public void iShouldBeTakenToTheDetailsPageForThatProduct() {
        String result = iStores.returnProductText();
        String title = driver.getTitle();
        Assertions.assertEquals(result + " | iStores - Apple Premium Reseller - iPhone, iPad, Mac, iPod", title);
    }

    @When("I search for a product using the term {string}")
    public void iSearchForAProductUsingTheTerm(String arg0) {
        driver.get("https://www.istores.cz/");
        iStores.searchForProduct(arg0);
    }

    @Then("I should see the search results")
    public void iShouldSeeTheSearchResults() {
        String title = driver.getTitle();
        Assertions.assertEquals("Vyhledávání | iStores - Apple Premium Reseller - iPhone, iPad, Mac, iPod",title);
    }

    @And("there should be at least {int} products in the search results")
    public void thereShouldBeAtLeastProductsInTheSearchResults(int arg0) {
        Assertions.assertTrue(iStores.searchingNumOfProductsBiggerThan(arg0));
    }
}
