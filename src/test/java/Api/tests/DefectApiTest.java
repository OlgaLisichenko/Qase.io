package Api.tests;

import Api.base.BaseApiTest;
import Api.dto.defect.Defect;
import Api.dto.defect.UpdateDefect;
import org.testng.annotations.Test;
import utils.TestConstants;

public class DefectApiTest extends BaseApiTest implements TestConstants {

    /**
     * Checking the creation of a defect in selected project
     */
    @Test(priority = 1)
    public void createDefectTest() {
        Defect defect = Defect.
                builder().
                title(DEFECT_TITLE).
                actual_result(DEFECT_ACTUAL_RESULT).
                severity(DEFECT_SEVERITY).
                build();

        defectApi.createDefect(defect, DEFECT_CODE);
    }

    /**
     * Checking the retrieve of a specific defect by code and ID
     */
    @Test(priority = 2)
    public void getSpecificDefectTest() {
        defectApi.getSpecificDefect(DEFECT_CODE, DEFECT_ID);
    }

    /**
     * Checking the updating of a defect in selected project
     */
    @Test(priority = 3)
    public void updateDefectTest() {
        UpdateDefect updateDefect = UpdateDefect.
                builder().
                actualResult("2").
                build();

        defectApi.updateDefect(updateDefect, DEFECT_CODE, DEFECT_ID);
    }
}
