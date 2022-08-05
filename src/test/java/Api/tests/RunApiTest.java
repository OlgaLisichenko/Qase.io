package Api.tests;

import Api.base.BaseApiTest;
import Api.dto.run.Run;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestConstants;

public class RunApiTest extends BaseApiTest implements TestConstants {

    /**
     * Checking the scenario with the creation of the run in selected project,
     * retrieve, deletion the run from the repository by ID
     */
    @Test(priority = 1)
    public void createRunScenarioTest() {
        Run run = Run.builder().
                title(RUN_TITLE).
                description(RUN_DESCRIPTION).
                includeAllCases(RUN_CASES).
                build();

        int runId = runApi.createRun(run, RUN_CODE);
        Assert.assertEquals(run.getTitle(), RUN_TITLE);

        var result = runApi.getSpecificRun(RUN_CODE, runId);
        Assert.assertEquals(result.getResult().getDescription(), RUN_DESCRIPTION);

        runApi.deleteRun(RUN_CODE, runId);
    }

    /**
     * Checking the retrieve of all runs stored in selected project
     */
    @Test(priority = 2)
    public void getAllRunsTest() {
        var results = runApi.getAllRuns(RUN_CODE);

        Assert.assertEquals(results.getResults().getCount(), RUN_COUNT);
    }

    /**
     * Checking the deletion a run from repository with incorrect ID Identifier
     */
    @Test
    public void deleteRunTestWithError() {
        runApi.deleteRunWithError(RUN_CODE, RUN_ID);
    }
}
