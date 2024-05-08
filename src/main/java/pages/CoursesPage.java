package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CoursesPage {
    private WebDriver driver;

    // Constructor
    public CoursesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btnListAddCourse")
    private WebElement addCourseBtn;

    @FindBy(xpath = "//ul[@class='dd-list lms-flex-equal-height']")
    private WebElement AllCourses;

    public void clickOnAddCourseBtn() {

        addCourseBtn.click();
    }
    public WebElement getAllCourses()
    {
        return AllCourses;
    }
}
