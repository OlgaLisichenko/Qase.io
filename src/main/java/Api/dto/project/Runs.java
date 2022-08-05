package Api.dto.project;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Runs {
    @Expose
    int total;
    @Expose
    int active;
}
