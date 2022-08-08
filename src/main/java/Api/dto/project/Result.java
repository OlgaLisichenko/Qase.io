package Api.dto.project;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Result {
    @Expose
    String title;
    @Expose
    String code;
    @Expose
    Counts counts;
}
