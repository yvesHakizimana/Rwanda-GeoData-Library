# Rwanda GeoData Library

The **Rwanda GeoData Library** is a powerful tool for managing Rwanda's geographical structure. It provides an efficient way to retrieve and validate provinces, districts, sectors, cells, and villages, making it easier for developers to build solutions without the need for a separate database for geographical data.

---

## Features

- **Validation**: Use annotations to validate geographical names directly in your application.
- **Data Retrieval**: Access Rwanda's complete geo-structure programmatically.
- **Seamless Integration**: Easily integrate with backend and frontend systems.
- **Performance-Oriented**: Eliminate redundant database queries, ensuring optimized performance.

---

## Installation

Add the library to your Maven project using the following dependency:

```xml
<dependency>
    <groupId>io.github.yveshakizimana</groupId>
    <artifactId>rwanda-geodata-utils</artifactId>
    <version>1.0.0</version>
</dependency>
```

---

## Usage

### 1. **Validation Using Annotations**

This library provides annotation-based validation to ensure that geographic data conforms to Rwanda's structure.

#### Example: Validating a User Profile

```java
package com.example.services;

import rwandageodata.constraints.*;

public record UserProfile(
        RwandaLocation rwandaLocation,

        @ValidRwandaProvince(message = "Invalid Rwandan province.")
        String provinceName,

        @ValidRwandaDistrict(message = "Invalid Rwandan district.")
        String districtName,

        @ValidRwandaSector(message = "Invalid Rwandan sector.")
        String sectorName,

        @ValidRwandaCell(message = "Invalid Rwandan cell.")
        String cellName,

        @ValidRwandaVillage(message = "Invalid Rwandan village.")
        String villageName
) {}
```

### 2. **Validation of an Entire Location**

You can validate a complete location object by using the `@ValidRwandaLocation` annotation.

```java
package com.example.services;

import rwandageodata.constraints.ValidRwandaLocation;

@ValidRwandaLocation
public record RwandaLocation(
        String provinceName,
        String districtName,
        String sectorName,
        String cellName,
        String villageName
) {}
```

---

### 3. **Retrieving Geographical Data**

For developers needing to retrieve Rwanda's geo-structure without relying on external databases, the library offers utility methods.

#### Example: Using the `RwandaGeoData` Service

```java
package com.example.services;

import rwandageodata.RwandaGeoData;
import rwandageodata.RwandaGeoDataFactory;

import java.util.List;
import java.util.Set;

public class RwandaService {

    private final RwandaGeoData rwandaGeoData;

    // Initialize the RwandaGeoData instance
    public RwandaService() {
        rwandaGeoData = RwandaGeoDataFactory.create();
    }

    // Retrieve all provinces
    public Set<String> getAllProvinces() {
        return rwandaGeoData.getAllProvinces();
    }

    // Retrieve districts for a specific province
    public Set<String> getAllDistricts(String provinceName) {
        return rwandaGeoData.getAllDistricts(provinceName);
    }

    // Retrieve sectors for a specific district
    public List<String> getAllSectors(String districtName) {
        return rwandaGeoData.getAllSectors(districtName);
    }

    // Retrieve cells for a specific sector
    public List<String> getAllCells(String sectorName) {
        return rwandaGeoData.getAllCells(sectorName);
    }

    // Retrieve villages for a specific cell
    public List<String> getAllVillages(String cellName) {
        return rwandaGeoData.getAllVillages(cellName);
    }
}
```

---

## Why Use This Library?

- **Backend-Frontend Integration**: Query and validate geographic data between backend and frontend seamlessly.
- **Eliminate Database Dependencies**: No need to maintain a separate database for Rwanda's geo-structure.
- **Ready to Use**: Simplifies development with ready-to-use annotations and data retrieval methods.
- **Optimized Performance**: Efficient data handling minimizes performance impacts.

---

## Contributing

Contributions are welcome! Fork the repository, make your changes, and submit a pull request. If you encounter any issues or have suggestions, feel free to open an issue.

---

## License

This project is licensed under the Apache License. See the [LICENSE](LICENSE) file for details.

---

## Contact

For questions or feedback, reach out to:

- **Author**: Yves Hakizimana
- **GitHub**: [@yveshakizimana](https://github.com/yveshakizimana)

---

Start building powerful applications with the **Rwanda GeoData Library** today! 🎉
