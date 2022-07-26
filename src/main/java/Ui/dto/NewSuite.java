package Ui.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewSuite {
    private String suiteName;
    private String description;
    private String preconditions;
}
