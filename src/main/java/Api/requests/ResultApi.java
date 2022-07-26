package Api.requests;

import Api.base.BaseApi;
import Api.dto.result.ListResults;
import Api.dto.result.RunResult;
import utils.DataConstants;

import static utils.PropertyReader.*;

public class ResultApi extends BaseApi implements DataConstants {

    public ListResults getAllResults(String code) {
        return gson.fromJson(get(getResultApiUri() + code, CODE_OK, RESULTS_FIELD, RESULTS_VALUE).asString(),
                ListResults.class);
    }

    public void createTestRunResult(RunResult runResult, String code, String id) {
        post(gson.toJson(runResult), getResultApiUri() + code + id, CODE_OK);
    }
}