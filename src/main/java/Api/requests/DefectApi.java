package Api.requests;

import Api.base.BaseApi;
import Api.dto.defect.Defect;
import Api.dto.defect.UpdateDefect;
import utils.DataConstants;

import static utils.PropertyReader.getDefectApiUri;

public class DefectApi extends BaseApi implements DataConstants {

    public void createDefect(Defect defect, String code) {
        post(gson.toJson(defect), getDefectApiUri() + code, CODE_OK);
    }

    public Defect getSpecificDefect(String code, String id) {
        return gson.fromJson(get(getDefectApiUri() + code + id, CODE_OK, DEFECT_FIELD, DEFECT_VALUE).
                asString(), Defect.class);
    }

    public void updateDefect(UpdateDefect updateDefect, String code, String id) {
        patch(gson.toJson(updateDefect), getDefectApiUri() + code + id, CODE_OK);
    }
}
