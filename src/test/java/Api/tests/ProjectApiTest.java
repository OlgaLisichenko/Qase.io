package Api.tests;

import Api.base.BaseApiTest;
import Api.dto.project.Project;
import Api.dto.project.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestConstants;

import java.io.FileNotFoundException;

public class ProjectApiTest extends BaseApiTest implements TestConstants {

    /**
     * Checking the creating of a new project through API
     */
    @Test(priority = 1)
    public void createProjectTest() {
        Project project = Project.
                builder().
                title(PROJECT_TITLE).
                code(PROJECT_CODE).
                description(PROJECT_DESCRIPTION).
                build();

        projectApi.createProject(project);
        Assert.assertEquals(project.getCode(), PROJECT_CODE);
    }

    /**
     * Checking the retrieve of a specific project by code
     */
    @Test(priority = 2)
    public void getProjectByCodeTest() throws FileNotFoundException {
        var project = projectApi.getProjectByCode(PROJECT_CODE);
        Assert.assertEquals(project, projectApi.expectedProject);
    }

    /**
     * Checking the deletion of a specific project by code
     */
    @Test(priority = 3)
    public void deleteProjectByCodeTest() {
        Response response = projectApi.deleteProject(PROJECT_CODE);
        Assert.assertTrue(response.isStatus());
    }
}
