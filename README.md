# Rwanda Geo Data Library

The **Rwanda Geo Data Library** is a Java library designed for accessing, managing, and validating Rwanda's hierarchical geographical data. This library provides a structured way to retrieve information about provinces, districts, sectors, cells, and villages, enabling developers to work with Rwanda's geo-structure efficiently.

## Features

- **Hierarchical Data Access**: Retrieve geographical entities at all levels, from provinces to villages.
- **Flexible Queries**: Retrieve data using parent-child relationships (e.g., districts within a province, sectors within a district).
- **Validation**: Validate geographical locations to ensure consistency and correctness.
- **Efficient Data Loading**: The library supports preloading of geo-data for optimized querying.

## Core Functionalities

The library provides the following key methods:

### Province-Level Operations
- `getAllProvinces()`: Retrieve a set of all provinces in Rwanda.

### District-Level Operations
- `getAllDistricts()`: Retrieve a set of all districts in Rwanda.
- `getAllDistricts(String provinceName)`: Retrieve all districts within a specific province.

### Sector-Level Operations
- `getAllSectors()`: Retrieve a list of all sectors in Rwanda.
- `getAllSectors(String districtName)`: Retrieve all sectors within a specific district.
- `getAllSectors(String provinceName, String districtName)`: Retrieve all sectors within a specific province and district.

### Cell-Level Operations
- `getAllCells()`: Retrieve a list of all cells in Rwanda.
- `getAllCells(String sectorName)`: Retrieve all cells within a specific sector.
- `getAllCells(String provinceName, String districtName, String sectorName)`: Retrieve all cells within a specific province, district, and sector.
- `getAllCells(String provinceName, String districtName)`: Retrieve all cells within a specific province and district.

### Village-Level Operations
- `getAllVillages()`: Retrieve a list of all villages in Rwanda.
- `getAllVillages(String districtName, String sectorName)`: Retrieve all villages within a specific district and sector.
- `getAllVillages(String cellName)`: Retrieve all villages within a specific cell.

### Location Validation
- `locationExists(Location location)`: Validate a complete location sequence (province, district, sector, cell, and village).

## Data Loading

The library uses a preloaded data source to provide fast and efficient access to Rwanda’s geo-structure. Ensure that the data is correctly loaded and structured for optimal performance.

## Installation

To use the **Rwanda Geo Data Library** in your Java project:

1. Download the `rwandageodata.jar` file from the repository.
2. Include the `.jar` file in your project's classpath.

## Usage

Here is an example of how to use the library:

```java
import rwandageodata.IRwandaGeoDataService;
import rwandageodata.Location;
import rwandageodata.RwandaGeoDataFactory;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IRwandaGeoDataService geoDataService = RwandaGeoDataFactory.create();

        // Retrieve all provinces
        System.out.println("Provinces: " + geoDataService.getAllProvinces());

        // Retrieve districts in a province
        System.out.println("Districts in Kigali: " + geoDataService.getAllDistricts("Kigali"));

        // Validate a location
        Location location = new Location("Kigali", "Nyarugenge", "Kiyovu", "Kiyovu Cell", "Village 1");
        boolean isValid = geoDataService.locationExists(location);
        System.out.println("Is location valid? " + isValid);
    }
}
```

## Contribution

We welcome contributions! To contribute:

1. Fork and clone the repository:
   ```sh
   git clone https://github.com/yvesHakizimana/Rwanda-GeoData-Library
   ```
2. Create a new branch for your feature:
   ```sh
   git checkout -b feature-name
   ```
3. Commit your changes and push to your fork.
4. Submit a pull request for review.

## License

This library is licensed under the [Apache](LICENSE).


For more information, documentation, or support, please contact Yves HAKIZIMANA.

