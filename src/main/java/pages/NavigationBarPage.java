package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBarPage {

    private WebDriver driver;

    // Constructor
    public NavigationBarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btnMyCoursesList")
    private WebElement myCoursesList;

    public void clickMyCoursesListBtn() {
        myCoursesList.click();
    }
}
