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
    static Set<String> getAllProvinces() {
        return Set.of("");
    }

    /**
     * Retrieves all districts in Rwanda.
     *
     * @return a set of district names.
     */
    static Set<String> getAllDistricts() {
        return Set.of("");
    }

    /**
     * Retrieves all sectors in Rwanda.
     *
     * @return a list of sector names.
     */
    static List<String> getAllSectors() {
        return List.of("");
    }

    /**
     * Retrieves all cells in Rwanda.
     *
     * @return a list of cell names.
     */
    static List<String> getAllCells() {
        return List.of("");
    }

    /**
     * Retrieves all villages in Rwanda.
     *
     * @return a list of village names.
     */
    static List<String> getAllVillages() {
        return List.of("");
    }

    /**
     * Retrieves all districts within a specific province.
     *
     * @param provinceName the name of the province.
     * @return a set of district names in the specified province.
     */
    static Set<String> getAllDistricts(String provinceName) {
        return Set.of("");
    }

    /**
     * Retrieves all sectors within a specific district.
     *
     * @param districtName the name of the district.
     * @return a list of sector names in the specified district.
     */
    static List<String> getAllSectors(String districtName) {
        return List.of("");
    }

    /**
     * Retrieves all sectors within a specific province and district.
     *
     * @param provinceName the name of the province.
     * @param districtName the name of the district.
     * @return a list of sector names in the specified province and district.
     */
    static List<String> getAllSectors(String provinceName, String districtName) {
        return List.of("");
    }
}
