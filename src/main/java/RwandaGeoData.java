import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class RwandaGeoData {

    private static LinkedHashMap<String,LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, List<String>>>>> provinceMap = new LinkedHashMap<>();
    private static LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, List<String>>>> districtMap = new LinkedHashMap<>();
    private static LinkedHashMap<String, LinkedHashMap<String, List<String>>> sectorMap = new LinkedHashMap<>();
    private static LinkedHashMap<String, List<String>> cellMap = new LinkedHashMap<>();
    private static List<String> villages = new ArrayList<>();

    public static void loadFirstFile(String fileName) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String provinceName = data[0];
                String districtName = data[1];
                String sectorName = data[2];
                String cellName = data[3];
                String villageName = data[4];

                // Insert the data into maps, similar to the method before.
                insertDataIntoMaps(new Location(provinceName,districtName,sectorName,cellName,villageName));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading dataset", e);
        }
    }

    private static void insertDataIntoMaps(Location location){

        String cellKey = GeoKeysConstructor.generateCellKey(location);
        String sectorKey = GeoKeysConstructor.generateSectorKey(location);
        String districtKey = GeoKeysConstructor.generateDistrictKey(location);
        String provinceKey = GeoKeysConstructor.generateProvinceKey(location);

        villages.add(location.villageName());

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

    public static Set<String> getAllProvinces(){
        return provinceMap.keySet();
    }

    public static Set<String> getAllDistricts(){
        return districtMap.keySet().stream().map(key -> key.split("\\|")[1]).collect(Collectors.toSet());
    }

    public static List<String> getAllSectors(){
        return sectorMap.keySet().stream().map(key -> key.split("\\|")[2]).collect(Collectors.toList());
    }

    public static List<String> getAllCells(){
        return cellMap.keySet().stream().map(key -> key.split("\\|")[3]).collect(Collectors.toList());
    }

    public static List<String> getAllVillages(){
        return villages;
    }

    public static  void main(String[] args) throws FileNotFoundException {
        loadFirstFile("rwanda-administrative-structure-data.csv");

        System.out.println(provinceMap.keySet());
        districtMap
                .keySet()
                .stream().map(key -> key.split("\\|")[1])
                .forEach(System.out::println);
        System.out.println(sectorMap.size());
        System.out.println(cellMap.size());
        System.out.println(villages.size());
    }
}
