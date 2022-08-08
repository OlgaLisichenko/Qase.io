package Api.dto.project;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Response {
    @Expose
    boolean status;
    @Expose
    Result result;
}
