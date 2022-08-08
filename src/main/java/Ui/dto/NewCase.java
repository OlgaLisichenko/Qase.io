package Ui.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewCase {
    protected String title;
    protected String description;
    protected String preconditions;
    protected String postconditions;
    protected String status;
    protected String priority;
    protected String severity;
    protected String type;
    protected String layer;
    protected String isFlaky;
    protected String behavior;
    protected String automationStatus;
}
