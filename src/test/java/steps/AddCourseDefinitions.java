package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AddCourseDefinitions
{
    static WebDriver driver  = new ChromeDriver();
    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    NavigationBarPage navigationBar = new NavigationBarPage(driver);
    CoursesPage courses =new CoursesPage(driver);
    AddCoursePage add_course= new AddCoursePage(driver);
    String course_title ;

    @Before("@web")
    public void init() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Given("Navigate to winjigo website")
    public void navigate_to_winjigo_website() {
        driver.get("https://www.winjigo.com/");
    }

    @Given("I click the login link")
    public void i_click_the_login_link() {
        home.clickLogin();
    }


    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String email, String password) {
        login.enterEmail(email);
        login.enterPassword(password);
        login.clickLoginButton();

    }

    @And("I open courses Page")
    public void i_open_courses_page() {
        navigationBar.clickMyCoursesListBtn();
        courses.clickOnAddCourseBtn();
    }

    @When("I fill course basic info:")
    public void i_fill_course_basic_info(DataTable dataTable) {
        List<Map<String, String>> data =  dataTable.asMaps();
        course_title = data.get(0).get("Course Name");
        add_course.enterCourseName(course_title);
        add_course.selectCourseSubject(data.get(0).get("Subject"));
        add_course.selectCourseGrade(data.get(0).get("Grade"));
        add_course.addCourseTeacher();
        add_course.selectCourseCriteria(data.get(0).get("Course Criteria"));
        WebElement iframe = driver.findElement(By.cssSelector("#hubspot-conversations-iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@data-test-id='initial-message-close-button']")).click();
        driver.switchTo().defaultContent();
        add_course.clickCreateBtn();
    }

    @And("I Back to courses list page")
    public void click_courses_page() {
        navigationBar.clickMyCoursesListBtn();
    }

    @Then("I should see the course title is displayed")
    public void i_should_see_the_course_title_displayed() {
        Assert.assertTrue("Element is not visible", courses.getAllCourses().findElement(By.xpath("//*[text()='"+course_title+"']")).isDisplayed());

    }

    @After("@web")
    public void tearDown() {
        // Close the browser
            driver.quit();
    }
}
