package rwandageodata;

/**
 * Factory class for creating the instances of {@link RwandaGeoData}.
 * This class provides a centralized way to construct and initialize {@link RwandaGeoData} objects.
 */
public final class RwandaGeoDataFactory {
    /**
     * Private Constructor to prevent instantiation of the factory class.
     * This ensures that the class is used only as utility class.
     */
    private RwandaGeoDataFactory() {
    }

    /**
     * Creates a new instance of {@link RwandaGeoData}
     * @return a new {@link RwandaGeoData} object.
     */
    public static RwandaGeoData create() {
        return new RwandaGeoData();
    }
}
