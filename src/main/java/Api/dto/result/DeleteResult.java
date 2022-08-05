package Api.dto.result;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class DeleteResult {
    @Expose
    String hash;
}
