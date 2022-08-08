package Api.apiClient;

import Api.base.BaseApi;
import Api.dto.result.DeleteStatus;
import Api.dto.result.RunResult;
import Api.dto.result.Status;
import io.restassured.response.Response;

import static java.net.HttpURLConnection.HTTP_OK;
import static utils.PropertyReader.*;

public class ResultApi extends BaseApi{

    public String createTestRunResult(RunResult runResult, String code, int id) {
        Response response = post(gson.toJson(runResult), getResultApiUri() + code + "/" + id, HTTP_OK);
        return gson.fromJson(response.body().asString(), Status.class).getResult().getHash();
    }

    public Status getSpecificRunResult(String code, String hash) {
        return gson.fromJson(get(getResultApiUri() + code + "/" + hash, HTTP_OK).
                body().asString(), Status.class);
    }

    public DeleteStatus deleteRunResult(String code, int id, String hash) {
        return gson.fromJson(delete(  getResultApiUri() + code + "/" + id + "/" + hash, HTTP_OK).
                body().asString(), DeleteStatus.class);
    }
}