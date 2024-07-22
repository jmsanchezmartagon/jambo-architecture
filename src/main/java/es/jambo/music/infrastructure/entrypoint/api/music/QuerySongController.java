package es.jambo.music.infrastructure.entrypoint.api.music;

import es.jambo.music.infrastructure.shared.EndPoints;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoints.SongEndPoints.SONG)
final class QuerySongController {
/*
    private final SearchCustomer searchCustomer;
    private final SearchCustomerBrand searchCustomerBrand;

    QueryCustomerController(SearchCustomer searchCustomer, SearchCustomerBrand searchCustomerBrand) {
        this.searchCustomer = searchCustomer;
        this.searchCustomerBrand = searchCustomerBrand;
    }

    @Operation(operationId = "getCustomer")
    @GetMapping("/{id}")
    public ViewCustomerDTO get(@PathVariable String id) {
        return searchCustomer.byId(id);
    }

    @Operation(operationId = "byCustomerIdAndBrandId")
    @GetMapping(EndPoints.CustomerEndPoints.GET_BY_BRAND_ID)
    public ViewCustomerDTO byCustomerIdAndBrandId(@PathVariable("id") String customerId, @PathVariable("brandId") String brandId) {
        return this.searchCustomer.searchByIdAndBrand(customerId, brandId);
    }

    @Operation(operationId = "getBrandsByCustomerId", summary = "Devuelve todas las marcas activos con sus clientes de la misma persona dado un cliente")
    @GetMapping(EndPoints.CustomerEndPoints.GET_BRANDS)
    public List<ViewCustomerBrandDTO> getBrandsByCustomerId(@PathVariable("customerId") String customerId) {
        return searchCustomerBrand.byCustomerId(customerId);
    }

    @Operation(operationId = "getPersonCompanyIds")
    @GetMapping(EndPoints.CustomerEndPoints.GET_PERSON_COMPANY_IDS)
    public List<String> getPersonCompanyIds(@PathVariable String id) {
        return searchCustomer.getPersonCompanyIds(id);
    }

 */
}
