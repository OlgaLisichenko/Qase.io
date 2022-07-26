package Api.dto.run;

import Api.dto.project.Result;
import lombok.Data;

@Data
public class ListRuns {
    boolean status;
    Result result;
}
