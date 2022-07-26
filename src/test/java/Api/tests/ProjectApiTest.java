package Api.tests;

import Api.base.BaseApiTest;
import Api.dto.project.Project;
import org.testng.annotations.Test;
import utils.TestConstants;

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
    }

    /**
     * Checking the retrieve of a specific project by code
     */
    @Test(priority = 2)
    public void getProjectByCodeTest() {
        projectApi.getProjectByCode(PROJECT_CODE);
    }

    /**
     * Checking the deletion of a specific project by code
     */
    @Test(priority = 3)
    public void deleteProjectByCodeTest() {
        projectApi.deleteProject(PROJECT_CODE);
    }
}
