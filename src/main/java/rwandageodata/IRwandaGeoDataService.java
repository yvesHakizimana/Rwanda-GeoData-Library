package rwandageodata;

import java.util.List;
import java.util.Set;

public interface IRwandaGeoDataService {
    static Set<String> getAllProvinces(){
        return Set.of("");
    }

    static Set<String> getAllDistricts(){
        return Set.of("");
    }

    static List<String> getAllSectors(){
        return List.of("");
    }

    static List<String> getAllCells(){
        return List.of("");
    }

    static List<String> getAllVillages(){
        return List.of("");
    }

    static Set<String> getAllDistricts(String provinceName){
        return Set.of("");
    }

    static List<String> getAllSectors(String districtName){
        return List.of("");
    }

    static List<String> getAllSectors(String provinceName, String districtName){
        return List.of("");
    }
}
