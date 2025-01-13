package rwandageodata;

class RwandaGeoKeysConstructor {
    static String generateVillageKey(Location location) {
        return location.provinceName() +
                "|"
                + location.districtName() +
                "|"
                + location.sectorName() +
                "|"
                + location.cellName() +
                "|"
                + location.villageName();
    }

    static String generateCellKey(Location location) {
        return location.provinceName() +
                "|"
                + location.districtName() +
                "|"
                + location.sectorName() +
                "|"
                + location.cellName();
    }

    static String generateSectorKey(Location location) {
        return location.provinceName() +
                "|"
                + location.districtName() +
                "|"
                + location.sectorName();
    }

    static String generateDistrictKey(Location location) {
        return location.provinceName() +
                "|"
                + location.districtName();
    }

    static String generateProvinceKey(Location location) {
        return  location.provinceName();
    }

}
