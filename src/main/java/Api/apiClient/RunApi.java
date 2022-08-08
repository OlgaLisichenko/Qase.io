package Api.apiClient;

import Api.base.BaseApi;
import Api.dto.run.Error;
import Api.dto.run.ListRuns;
import Api.dto.run.Run;
import Api.dto.run.StatusRun;
import io.restassured.response.Response;

import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;
import static utils.PropertyReader.*;

public class RunApi extends BaseApi {

    public int createRun(Run run, String code) {
        Response response = post(gson.toJson(run), getRunApiUri() + code, HTTP_OK);
        return gson.fromJson(response.body().asString(), StatusRun.class).getResult().getId();
    }

    public StatusRun getSpecificRun(String code, int id) {
        return gson.fromJson(get(getRunApiUri() + code + "/" + id, HTTP_OK).
                body().asString(), StatusRun.class);
    }

    public void deleteRun(String code, int id) {
        delete(  getRunApiUri() + code + "/" + id, HTTP_OK);
    }

    public ListRuns getAllRuns(String code) {
        return gson.fromJson(get(getRunApiUri() + code, HTTP_OK).
                body().asString(), ListRuns.class);
    }

    public Error deleteRunWithError(String code, int id) {
        return gson.fromJson(delete(getRunApiUri() + code + "/" + id, HTTP_NOT_FOUND).
                asString(), Error.class);
    }
}
