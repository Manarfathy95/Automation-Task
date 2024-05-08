package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCoursePage {
    private  WebDriver driver;

    // Constructor
    public AddCoursePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "txtCourseName")
    private WebElement courseName;

    @FindBy(id = "courseSubject")
    private WebElement courseSubject;

    @FindBy(id = "courseGrade")
    private WebElement courseGrade;

    @FindBy(id = "teacherOnBehalf")
    private WebElement courseTeacher;

    @FindBy(id = "ui-select-choices-row-0-0")
    private WebElement displayedTeacher;

    @FindBy(xpath = "//div[@id='divCompletionCriteria']//div[@class='col-xs-12 col-md-12 lms-text-align-start']")
    private WebElement courseCriteria;

    @FindBy(id = "btnSaveAsDraftCourse")
    private WebElement createbtn;

    public void clickCreateBtn() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(createbtn));
//        createbtn.click();

        driver.findElement(By.cssSelector("#btnSaveAsDraftCourse")).click();

    }

    public void enterCourseName(String  name)
    {
        courseName.sendKeys(name);
    }
    public void selectCourseSubject(String  subject) {
        Select dropdown = new Select(courseSubject);
        dropdown.selectByVisibleText(subject);
    }

    public void selectCourseGrade(String  grade) {
        Select dropdown = new Select(courseGrade);
        dropdown.selectByVisibleText(grade);
    }

    public void addCourseTeacher() {
        courseTeacher.click();
        displayedTeacher.click();
    }
    public void selectCourseCriteria (String criteria_name){
        courseCriteria.findElement((By.xpath("//*[text()='"+criteria_name+"']"))).click();

    }


}
