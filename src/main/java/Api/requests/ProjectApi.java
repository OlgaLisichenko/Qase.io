package Api.requests;

import Api.base.BaseApi;
import Api.dto.project.Project;
import utils.DataConstants;

import static utils.PropertyReader.getProjectApiUri;

public class ProjectApi extends BaseApi implements DataConstants {

    public void createProject(Project project) {
        post(gson.toJson(project), getProjectApiUri(), CODE_OK);
    }

    public Project getProjectByCode(String code) {
        return gson.fromJson(get(getProjectApiUri() + code, CODE_OK, PROJECT_FIELD, PROJECT_VALUE).
                path("result").toString(), Project.class);
    }

    public void deleteProject(String code) {
        delete(  getProjectApiUri() + code, CODE_OK);
    }
}
