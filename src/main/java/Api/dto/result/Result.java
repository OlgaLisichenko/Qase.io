package Api.dto.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Result {
    @SerializedName("case_id")
    int caseId;
    String hash;
}
