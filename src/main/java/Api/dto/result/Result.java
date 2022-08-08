package Api.dto.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Result {
    @Expose
    String hash;
    @Expose
    String comment;
    @Expose
    String stacktrace;
    @Expose
    @SerializedName("run_id")
    int runId;
}
