package Api.requests;

import Api.base.BaseApi;
import Api.dto.run.ListRuns;
import Api.dto.run.Run;
import utils.DataConstants;

import static utils.PropertyReader.getRunApiUri;

public class RunApi extends BaseApi implements DataConstants {
    public void createRun(Run run, String code) {
        post(gson.toJson(run), getRunApiUri() + code, CODE_OK);
    }

    public ListRuns getAllRuns(String code) {
        return gson.fromJson(get(getRunApiUri() + code, CODE_OK, RUNS_FIELD, RUNS_VALUE).asString(), ListRuns.class);
    }

    public Error deleteRunWithError(String code, String id) {
        return gson.fromJson(delete(getRunApiUri() + code + id, CODE_NOT_FOUND).asString(), Error.class);
    }
}
