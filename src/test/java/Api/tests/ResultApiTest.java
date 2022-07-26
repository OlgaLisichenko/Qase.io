package Api.tests;

import Api.base.BaseApiTest;
import Api.dto.result.Case;
import Api.dto.result.RunResult;
import org.testng.annotations.Test;
import utils.TestConstants;

public class ResultApiTest extends BaseApiTest implements TestConstants {

    /**
     * Checking the retrieve of all test run results stored in selected project
     */
    @Test
    public void getAllResultsTest() {
        resultApi.getAllResults(RESULT_CODE);
    }

    /**
     * Checking the creation of a test run result in selected project
     */
    @Test
    public void createRunResultTest() {
        RunResult runResult = RunResult.
                builder().
                myCase(Case.
                        builder().
                        title(RESULT_TITLE).
                        build()).
                status(RESULT_STATUS).
                build();

        resultApi.createTestRunResult(runResult, RESULT_CODE, RESULT_ID);
    }
}
