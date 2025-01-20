package rwandageodata;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RwandaGeoDataTest {

    @Test
    public void testGetAllProvinces() {
        var allProvinces = RwandaGeoDataFactory.create().getAllProvinces();


        assertNotNull(allProvinces, "Provinces should not be null");
        assertEquals(allProvinces.size(), 5, "Provinces should not be empty");
        assertTrue(allProvinces.contains("SOUTH"), "Southern Province should exist");
    }

    @Test
    public void testGetAllDistricts() {
        var allDistricts = RwandaGeoDataFactory.create().getAllDistricts();


        assertNotNull(allDistricts, "Districts should not be null.");
        assertEquals(allDistricts.size(), 30, "Districts should not be empty.");
        assertTrue(allDistricts.contains("Muhanga"), "Muhanga District should exist.");
        assertTrue(allDistricts.contains("Rwamagana"), "Rwamagana District should exist.");
        assertTrue(allDistricts.contains("Musanze"), "Musanze District should exist.");
        assertTrue(allDistricts.contains("Rubavu"), "Rubavu District should exist.");
        assertTrue(allDistricts.contains("Nyarugenge"), "Nyarugenge District should exist.");

    }

    @Test
    public void testGetAllSectors() {
        var allSectors = RwandaGeoDataFactory.create().getAllSectors();


        assertNotNull(allSectors, "Sectors  should not be null.");
        assertEquals(allSectors.size(), 416, "Sectors should be 416 in size.");
        assertTrue(allSectors.contains("Nyamabuye"), " Nyamabuye Sector should exist.");
    }

    @Test
    public void testGetAllCells() {
        var allCells = RwandaGeoDataFactory.create().getAllCells();


        assertNotNull(allCells, "Cells   should not be null.");
        assertEquals(allCells.size(), 2148, "Cells should be 2148 in size.");
        assertTrue(allCells.contains("Gahogo"), " Gahogo cell should exist.");
    }

    @Test
    public void testGetAllVillages() {
        var allVillages = RwandaGeoDataFactory.create().getAllVillages();


        assertNotNull(allVillages, "Villages should not be null.");
        assertEquals(allVillages.size(), 14837, "Villages should be 14837 in size.");
        assertTrue(allVillages.contains("Ruvumera"), "Ruvumera village  should exist.");
    }

    @Test
    public void testTestGetAllDistricts() {
        System.out.println("Testing getting all districts.");
    }

    @Test
    public void testTestGetAllSectors() {
        System.out.println("Testing getting all sectors.");
    }

    @Test
    public void testTestGetAllSectors1() {
        System.out.println("Testing getting all sectors.");
    }

    @Test
    public void testTestGetAllCells() {
        System.out.println("Testing getting all cells.");
    }

    @Test
    public void testTestGetAllCells1() {
        System.out.println("Testing getting all cells.");
    }

    @Test
    public void testTestGetAllCells2() {
    }

    @Test
    public void testTestGetAllVillages() {
    }

    @Test
    public void testTestGetAllVillages1() {
    }

    @Test
    public void testLocationExists() {
    }
}