package Api.dto.run;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ListRuns {
    @Expose
    boolean status;
    @Expose
    @SerializedName("result")
    Results results;
}
