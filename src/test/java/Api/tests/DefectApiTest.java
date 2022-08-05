package Api.tests;

import Api.base.BaseApiTest;
import Api.dto.defect.Defect;
import Api.dto.defect.UpdateDefect;
import org.testng.Assert;
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
                actualResult(DEFECT_ACTUAL_RESULT).
                severity(DEFECT_SEVERITY).
                build();

        defectApi.createDefect(defect, DEFECT_CODE);
        Assert.assertEquals(defect.getTitle(), DEFECT_TITLE);
    }

    /**
     * Checking the retrieve of a specific defect by code and ID
     */
    @Test(priority = 2)
    public void getSpecificDefectTest() {
        var result = defectApi.getSpecificDefect(DEFECT_CODE, DEFECT_ID);

        Assert.assertEquals(result.getResult().getId(), DEFECT_ID);
    }

    /**
     * Checking the retrieve of all defects by code
     */
    @Test
    public void getAllDefectTest() {
        var results = defectApi.getAllDefectTest(DEFECT_CODE);

        Assert.assertTrue(results.isStatus());
    }

    /**
     * Checking the updating of a defect in selected project
     */
    @Test(priority = 3)
    public void updateDefectTest() {
        UpdateDefect updateDefect = UpdateDefect.
                builder().
                actualResult(DEFECT_NEW_ACTUAL_RESULT).
                build();

        defectApi.updateDefect(updateDefect, DEFECT_CODE, DEFECT_ID);
        Assert.assertEquals(updateDefect.getActualResult(), DEFECT_NEW_ACTUAL_RESULT);
    }
}