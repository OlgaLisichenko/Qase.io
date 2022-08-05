package Api.tests;

import Api.base.BaseApiTest;
import Api.dto.result.Case;
import Api.dto.result.DeleteStatus;
import Api.dto.result.RunResult;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestConstants;

public class ResultApiTest extends BaseApiTest implements TestConstants {

    /**
     * Checking the scenario with the creation of the test run result in selected project,
     * retrieve, deletion the run result from the repository by ID
     */
    @Test
    public void createRunResultScenarioTest() {

        RunResult runResult = RunResult.
                builder().
                myCase(Case.
                        builder().
                        title(RESULT_TITLE).
                        build()).
                status(RESULT_STATUS).
                build();

        String resultHash = resultApi.createTestRunResult(runResult, RESULT_CODE, RESULT_ID);
        Assert.assertEquals(runResult.getMyCase().getTitle(), RESULT_TITLE);

        var result = resultApi.getSpecificRunResult(RESULT_CODE, resultHash);
        Assert.assertEquals(result.getResult().getRunId(), RESULT_ID);

        DeleteStatus deleteStatus = resultApi.deleteRunResult(RESULT_CODE, RESULT_ID, resultHash);
        Assert.assertTrue(deleteStatus.isStatus());
    }
}
