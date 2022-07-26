package Api.dto.defect;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Defect {
    @Expose
    String actual_result;
    @Expose
    int severity;
    @Expose
    String title;
}
