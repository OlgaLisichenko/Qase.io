package Api.dto.run;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Run {
    @Expose
    String title;
    @Expose
    String description;
    @Expose
    @SerializedName("include_all_cases")
    Boolean includeAllCases;
}
