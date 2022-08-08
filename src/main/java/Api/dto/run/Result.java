package Api.dto.run;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Result {
    @Expose
    int id;
    @Expose
    String title;
    @Expose
    String description;
}
