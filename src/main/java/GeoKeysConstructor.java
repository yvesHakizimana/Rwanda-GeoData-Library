public class GeoKeysConstructor {
    public static String generateCellKey(Location location) {
        return location.provinceName() +
                "|"
                + location.districtName() +
                "|"
                + location.sectorName() +
                "|"
                + location.cellName();
    }

    public static String generateSectorKey(Location location) {
        return location.provinceName() +
                "|"
                + location.districtName() +
                "|"
                + location.sectorName();
    }

    public static String generateDistrictKey(Location location) {
        return location.provinceName() +
                "|"
                + location.districtName();
    }

    public static String generateProvinceKey(Location location) {
        return  location.provinceName();
    }


}
