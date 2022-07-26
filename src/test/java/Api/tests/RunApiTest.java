package Api.tests;

import Api.base.BaseApiTest;
import Api.dto.run.Run;
import org.testng.annotations.Test;
import utils.TestConstants;

public class RunApiTest extends BaseApiTest implements TestConstants {

    /**
     * Checking the creation of a run in selected project
     */
    @Test
    public void createRunTest() {
        Run run = Run.builder().
                title(RUN_TITLE).
                description(RUN_DESCRIPTION).
                includeAllCases(RUN_CASES).
                build();
        runApi.createRun(run, RUN_CODE);
    }

    /**
     * Checking the retrieve of all runs stored in selected project
     */
    @Test
    public void getAllRunsTest() {
        runApi.getAllRuns(RUN_CODE);
    }

    /**
     * Checking the deletion a run from repository with incorrect ID Identifier
     */
    @Test
    public void deleteRunTestWithError() {
        runApi.deleteRunWithError(RUN_CODE, RUN_ID);
    }
}
