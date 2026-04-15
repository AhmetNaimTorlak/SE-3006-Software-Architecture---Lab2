package tr.edu.mu.se3006.catalog;

// PUBLIC Factory: Assembles the internal components and exposes ONLY the interface.
public class CatalogFactory {
    public static CatalogService create() {
        ProductRepository productRepository = new ProductRepository();
        CatalogServiceImpl catalogService = new CatalogServiceImpl(productRepository);
        return catalogService;
    }
}
