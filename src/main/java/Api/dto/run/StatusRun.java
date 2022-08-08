package Api.dto.run;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class StatusRun {
    @Expose
    boolean status;
    @Expose
    Result result;
}
