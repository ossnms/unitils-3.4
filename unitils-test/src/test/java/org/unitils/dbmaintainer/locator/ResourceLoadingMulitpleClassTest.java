package org.unitils.dbmaintainer.locator;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.core.Unitils;
import org.unitils.database.DatabaseModule;
import org.unitils.database.SQLUnitils;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;

/**
 * Unit test for simple App.
 * 
 * @author tdr
 * 
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@DataSet({
    "/org/unitils/testdata/exampleResourceData.xml", "/org/unitils/testdata/exampleResourceData.xml"
})
public class ResourceLoadingMulitpleClassTest {

    @BeforeClass
    public static void setUp() {
        DatabaseModule databaseModule = Unitils.getInstance().getModulesRepository().getModuleOfType(DatabaseModule.class);
        SQLUnitils.executeUpdate("CREATE TABLE dossier (id varchar(50), name varchar(50), Start_date date)", databaseModule.getWrapper("").getDataSource());
    }
    
    /** */
    @Test
    @ExpectedDataSet("/org/unitils/testdata/exampleResourceData.xml")
    public void testLoadingResource() {
        Assert.assertTrue(true);
    }
    
    @AfterClass
    public static void afterClass() {
        DatabaseModule databaseModule = Unitils.getInstance().getModulesRepository().getModuleOfType(DatabaseModule.class);
        SQLUnitils.executeUpdate("drop table dossier",databaseModule.getWrapper("").getDataSource());
    }
}
