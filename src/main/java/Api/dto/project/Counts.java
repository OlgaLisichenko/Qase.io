package Api.dto.project;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Counts {
    @Expose
    int cases;
    @Expose
    int suites;
    @Expose
    int milestones;
    @Expose
    Runs runs;
    @Expose
    Defects defects;
}
