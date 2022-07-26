package Api.dto.result;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {
    @Expose
    String title;
}
