package rwandageodata;

import java.util.List;
import java.util.Set;

/**
 * Interface for accessing and retrieving Rwanda's geographical data, including provinces,
 * districts, sectors, cells, and villages.
 */
public interface IRwandaGeoDataService {

    /**
     * Retrieves all provinces in Rwanda.
     *
     * @return a set of province names.
     */
    Set<String> getAllProvinces();

    /**
     * Retrieves all districts in Rwanda.
     *
     * @return a set of district names.
     */
    Set<String> getAllDistricts();

    /**
     * Retrieves all sectors in Rwanda.
     *
     * @return a list of sector names.
     */
    List<String> getAllSectors();

    /**
     * Retrieves all cells in Rwanda.
     *
     * @return a list of cell names.
     */
    List<String> getAllCells();

    /**
     * Retrieves all villages in Rwanda.
     *
     * @return a list of village names.
     */
    List<String> getAllVillages();

    /**
     * Retrieves all districts within a specific province.
     *
     * @param provinceName the name of the province.
     * @return a set of district names in the specified province.
     */
    Set<String> getAllDistricts(String provinceName);

    /**
     * Retrieves all sectors within a specific district.
     *
     * @param districtName the name of the district.
     * @return a list of sector names in the specified district.
     */
    List<String> getAllSectors(String districtName);

    /**
     * Retrieves all sectors within a specific province and district.
     *
     * @param provinceName the name of the province.
     * @param districtName the name of the district.
     * @return a list of sector names in the specified province and district.
     */
    List<String> getAllSectors(String provinceName, String districtName);

    /**
     * Retrieves all cells within a specific sector
     *
     * @param sectorName the name of the sector.
     * @return a list of cell names in the specified sector.
     */
    List<String> getAllCells(String sectorName);

    /**
     * Retrieves all cells within a specific province, district and sector.
     *
     * @param provinceName  the name of the province.
     * @param districtName the name of the district.
     * @param sectorName the name of the sector.
     * @return a list of cell names in the specified province, district and sector.
     */
    List<String> getAllCells(String provinceName, String districtName, String sectorName);

    /**
     * Retrieves all cells within a specific province and district
     *
     *
     * @param provinceName the name of the province.
     * @param districtName the name of the sector.
     * @return a list of cell names in the specified province and district.
     */
    List<String> getAllCells(String provinceName, String districtName);



    boolean locationExists(Location location);
}
