package rwandageodata;

/**
 * Bundles the Location details consisting a province, district, sector, cell and also village
 *
 * @param provinceName name of the Rwandan province, and it can be {EAST, WEST, SOUTH, NORTH, or KIGALI}
 * @param districtName name of the Rwandan district
 * @param sectorName name of the Rwandan sector
 * @param cellName name of the Rwandan cell
 * @param villageName name of the Rwandan village
 */
public record Location(
        String provinceName,
        String districtName,
        String sectorName,
        String cellName,
        String villageName
) {
}
