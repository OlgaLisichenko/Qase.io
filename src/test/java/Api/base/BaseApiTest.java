package Api.base;

import Api.requests.DefectApi;
import Api.requests.ProjectApi;
import Api.requests.ResultApi;
import Api.requests.RunApi;
import utils.TestListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseApiTest {
    public ProjectApi projectApi;
    public RunApi runApi;
    public DefectApi defectApi;
    public ResultApi resultApi;

    @BeforeMethod
    public void setup() {
        projectApi = new ProjectApi();
        runApi = new RunApi();
        defectApi = new DefectApi();
        resultApi = new ResultApi();
    }
}
