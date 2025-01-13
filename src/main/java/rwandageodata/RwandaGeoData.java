package rwandageodata;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * RwandaGeoData Class implements {@link IRwandaGeoDataService}
 *
 * @author Yves HAKIZIMANA
 */
public class RwandaGeoData implements IRwandaGeoDataService {

    /**
     * Ensure the data is loaded once and used when it is necessary.
     */
    public RwandaGeoData() {
        ensureDataIsLoaded();
    }

    private static final String dataFileName = "rwanda-administrative-structure-data.csv";
    private static final LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, List<String>>>>> provinceMap = new LinkedHashMap<>();
    private static final LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, List<String>>>> districtMap = new LinkedHashMap<>();
    private static final LinkedHashMap<String, LinkedHashMap<String, List<String>>> sectorMap = new LinkedHashMap<>();
    private static final LinkedHashMap<String, List<String>> cellMap = new LinkedHashMap<>();
    private static final LinkedHashMap<String, String> villageMap = new LinkedHashMap<>();
    private static boolean isDataLoaded = false;


    @Override
    public  Set<String> getAllProvinces() {
        return provinceMap.keySet();
    }

    @Override
    public Set<String> getAllDistricts() {
        return districtMap.keySet().stream().map(key -> key.split("\\|")[1]).collect(Collectors.toSet());
    }

    @Override
    public  List<String> getAllSectors() {
        return sectorMap.keySet().stream().map(key -> key.split("\\|")[2]).collect(Collectors.toList());
    }

    @Override
    public  List<String> getAllCells() {
        return cellMap.keySet().stream().map(key -> key.split("\\|")[3]).collect(Collectors.toList());
    }

    @Override
    public  List<String> getAllVillages() {
        return villageMap.keySet().stream().map(key -> key.split("\\|")[4]).collect(Collectors.toList());
    }

    @Override
    public Set<String> getAllDistricts(String provinceName) {

        return provinceMap
                .keySet()
                .stream()
                .filter(province -> province.equalsIgnoreCase(provinceName))
                .flatMap(province -> provinceMap.get(province).keySet().stream().map(key -> key.split("\\|")[1]))
                .collect(Collectors.toSet());
    }

    @Override
    public List<String> getAllSectors(String districtName) {

        return districtMap
                .keySet()
                .stream()
                .filter(district -> district.split("\\|")[1].equalsIgnoreCase(districtName))
                .flatMap(district -> districtMap.get(district).keySet().stream().map(key -> key.split("\\|")[2]))
                .toList();
    }

    @Override
    public List<String> getAllSectors(String provinceName, String districtName) {
        var districtKey = provinceName + "|" + districtName;

         return districtMap
                .keySet()
                .stream()
                .filter(district -> district.equalsIgnoreCase(districtKey))
                .flatMap(district -> districtMap.get(district).keySet().stream().map(key -> key.split("\\|")[2]))
                .toList();
    }

    @Override
    public List<String> getAllCells(String sectorName) {

        return sectorMap
                .keySet()
                .stream()
                .filter(sector -> sector.split("\\|")[2].equalsIgnoreCase(sectorName))
                .flatMap(sector -> sectorMap.get(sector).keySet().stream().map(key -> key.split("\\|")[3]))
                .toList();
    }

    @Override
    public List<String> getAllCells(String provinceName, String districtName, String sectorName) {
        String sectorKey = provinceName + "|" + districtName + "|" + sectorName;

        return sectorMap
                .keySet()
                .stream()
                .filter(sector -> sector.equalsIgnoreCase(sectorKey))
                .flatMap(sector -> sectorMap.get(sector).keySet().stream().map(key -> key.split("\\|")[3]))
                .toList();
    }

    @Override
    public List<String> getAllCells(String provinceName, String districtName) {
        String districtKey = provinceName + "|" + districtName;


        return districtMap
                .keySet()
                .stream()
                .filter(district -> district.equalsIgnoreCase(districtKey))
                .flatMap(district ->  districtMap.get(district).keySet().stream()) // Arrays of KeySets of each district.
                .flatMap(sectorKey -> sectorMap.get(sectorKey).keySet().stream())
                .map(cell -> cell.split("\\|")[3])
                .toList();

    }

    @Override
    public List<String> getAllVillages(String districtName, String sectorName) {


        return sectorMap
                .keySet()
                .stream()
                .filter(key -> key.split("\\|")[1].equalsIgnoreCase(districtName) && key.split("\\|")[2].equalsIgnoreCase(sectorName))
                .flatMap(sectorKeyFiltered -> sectorMap.get(sectorKeyFiltered).keySet().stream())
                .flatMap(cellKey -> cellMap.get(cellKey).stream())
                .toList();
    }

    @Override
    public List<String> getAllVillages(String cellName) {

        return
                cellMap
                        .keySet()
                        .stream()
                        .filter(cellKey -> cellKey.split("\\|")[3].equalsIgnoreCase(cellName))
                        .flatMap(cellKeyFiltered -> cellMap.get(cellKeyFiltered).stream())
                        .toList();
    }

    @Override
    public boolean locationExists(Location location) {
        ensureDataIsLoaded();
        String fromLocationVillageKey = RwandaGeoKeysConstructor.generateVillageKey(location);
        return villageMap.keySet()
                .stream()
                .anyMatch(village -> village.equalsIgnoreCase(fromLocationVillageKey));
    }

    private static synchronized void ensureDataIsLoaded(){
        if(!isDataLoaded){
            loadRwandaGeoData();
            isDataLoaded = true;
        }
    }

    private static void loadRwandaGeoData() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(RwandaGeoData.class.getClassLoader().getResourceAsStream(dataFileName)))
        )) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String provinceName = data[0];
                String districtName = data[1];
                String sectorName = data[2];
                String cellName = data[3];
                String villageName = data[4];

                // Insert the data into maps, similar to the method before.
                insertDataIntoMaps(new Location(provinceName, districtName, sectorName, cellName, villageName));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading dataset", e);
        }
    }

    private static void insertDataIntoMaps(Location location) {

        String villageKey = RwandaGeoKeysConstructor.generateVillageKey(location);
        String cellKey = RwandaGeoKeysConstructor.generateCellKey(location);
        String sectorKey = RwandaGeoKeysConstructor.generateSectorKey(location);
        String districtKey = RwandaGeoKeysConstructor.generateDistrictKey(location);
        String provinceKey = RwandaGeoKeysConstructor.generateProvinceKey(location);

        // Storing the villages.
        villageMap.putIfAbsent(villageKey, "");
        villageMap.put(villageKey, location.villageName());


        // Add the village to the cellMap
        cellMap.putIfAbsent(cellKey, new ArrayList<>());
        cellMap.get(cellKey).add(location.villageName());

        // Add the cell to the sectorMap
        sectorMap.putIfAbsent(sectorKey, new LinkedHashMap<>());
        sectorMap.get(sectorKey).putIfAbsent(cellKey, new ArrayList<>());
        sectorMap.get(sectorKey).get(cellKey).add(location.villageName());

        // Add the sector to the districtMap
        districtMap.putIfAbsent(districtKey, new LinkedHashMap<>());
        districtMap.get(districtKey).putIfAbsent(sectorKey, new LinkedHashMap<>());
        districtMap.get(districtKey).get(sectorKey).putIfAbsent(cellKey, new ArrayList<>());
        districtMap.get(districtKey).get(sectorKey).get(cellKey).add(location.villageName());

        // Add also the districtMap to provinceMap
        provinceMap.putIfAbsent(provinceKey, new LinkedHashMap<>());
        provinceMap.get(provinceKey).putIfAbsent(districtKey, new LinkedHashMap<>());
        provinceMap.get(provinceKey).get(districtKey).put(sectorKey, new LinkedHashMap<>());
        provinceMap.get(provinceKey).get(districtKey).get(sectorKey).putIfAbsent(cellKey, new ArrayList<>());
        provinceMap.get(provinceKey).get(districtKey).get(sectorKey).get(cellKey).add(location.villageName());

    }

//    public static void main(String[] args) {
//        // Testing to use of flatMap to understand it better.
//        ensureDataIsLoaded();
////        var map = provinceMap
////                .keySet()
////                .stream()
////                .map(province ->
////                        Map.entry(province, provinceMap.get(province).keySet().stream()
////                                .map(key -> key.split("\\|")[1])
////                                .collect(Collectors.toSet())
////                ))
////                .collect(Collectors.toList());
////        System.out.println(map);
//
//
//        var districtsWithSectors = districtMap
//                .keySet()
//                .stream()
//                .collect(Collectors.toMap(
//                        district -> district.split("\\|")[1],
//                        district ->
//                                districtMap.get(district).keySet().stream().map(key -> key.split("\\|")[2]).collect(Collectors.toList())
//                ));
//
////        System.out.println(districtsWithSectors);
//
//        var sectorsWithCells = sectorMap
//                .keySet()
//                .stream()
//                .map(sector -> Map.entry(
//                        sector.split("\\|")[2],
//                        sectorMap.get(sector).keySet().stream().map(key -> key.split("\\|")[3]).collect(Collectors.toList())
//                ))
//                .collect(Collectors.toSet());
//
//        System.out.println(sectorsWithCells.size());
//    }
}
