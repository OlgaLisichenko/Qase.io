package Api.apiClient;

import Api.base.BaseApi;
import Api.dto.defect.Defect;
import Api.dto.defect.Status;
import Api.dto.defect.UpdateDefect;

import static java.net.HttpURLConnection.HTTP_OK;
import static utils.PropertyReader.getDefectApiUri;

public class DefectApi extends BaseApi {

    public void createDefect(Defect defect, String code) {
        post(gson.toJson(defect), getDefectApiUri() + code, HTTP_OK);
    }

    public Status getSpecificDefect(String code, int id) {
        return gson.fromJson(get(getDefectApiUri() + code + "/" + id, HTTP_OK).
                body().asString(), Status.class);
    }

    public Status getAllDefectTest(String code) {
        return gson.fromJson(get(getDefectApiUri() + code, HTTP_OK).
                body().asString(), Status.class);
    }

    public void updateDefect(UpdateDefect updateDefect, String code, int id) {
        patch(gson.toJson(updateDefect), getDefectApiUri() + code + "/" + id, HTTP_OK);
    }
}
