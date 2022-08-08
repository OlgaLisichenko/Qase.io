package Api.dto.run;

import lombok.Data;

@Data
public class Error {
    boolean status;
    String errorMessage;
}
