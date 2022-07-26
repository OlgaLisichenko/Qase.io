package utils;

public interface DataConstants {

    int CODE_OK = 200;
    int CODE_NOT_FOUND = 404;

    String PROJECT_FIELD = "result.code";
    String PROJECT_VALUE = "NP1";

    boolean RUNS_VALUE = true;
    String RUNS_FIELD = "status";

    String DEFECT_FIELD = "result.id";
    int DEFECT_VALUE = 8;

    boolean RESULTS_VALUE = true;
    String RESULTS_FIELD = "status";

    String CASE_STATUS = "Draft";
    String CASE_SEVERITY = "Trivial";
    String CASE_TYPE = "Regression";
    String CASE_PRIORITY = "Low";
    String CASE_LAYER = "E2E";
    String CASE_IS_FLAKY = "No";
    String CASE_BEHAVIOR = "Positive";
    String CASE_AUTOMATION_STATUS = "Automated";
}
