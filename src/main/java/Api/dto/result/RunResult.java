package Api.dto.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RunResult {
    @Expose
    @SerializedName("case")
    Case myCase;
    @Expose
    String status;
}
