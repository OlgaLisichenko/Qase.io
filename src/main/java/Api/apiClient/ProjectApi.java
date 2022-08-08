package Api.apiClient;

import Api.base.BaseApi;
import Api.dto.project.Project;
import Api.dto.project.Response;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static java.net.HttpURLConnection.HTTP_OK;
import static utils.PropertyReader.getProjectApiUri;

public class ProjectApi extends BaseApi {

    public Response expectedProject;

    public void createProject(Project project) {
        post(gson.toJson(project), getProjectApiUri(), HTTP_OK);
    }

    public Response getProjectByCode(String code) throws FileNotFoundException{
        expectedProject = gson.fromJson
                (new FileReader("src/test/java/utils/expectedProject.json"), Response.class);

        return gson.fromJson(get(getProjectApiUri() + code, HTTP_OK).body().asString(), Response.class);
    }

    public Response deleteProject(String code) {
        return gson.fromJson(delete(getProjectApiUri() + code, HTTP_OK).
                body().asString(), Response.class);
    }
}