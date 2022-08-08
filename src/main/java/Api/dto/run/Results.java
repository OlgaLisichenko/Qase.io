package Api.dto.run;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Results {
    @Expose
    int total;
    @Expose
    int filtered;
    @Expose
    int count;
}
