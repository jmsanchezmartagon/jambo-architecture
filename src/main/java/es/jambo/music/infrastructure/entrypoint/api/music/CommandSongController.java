package es.jambo.music.infrastructure.entrypoint.api.music;

import es.jambo.music.infrastructure.shared.EndPoints;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoints.SongEndPoints.SONG)
final class CommandSongController {
/*
    private final CreateCustomer createCustomer;

    private final UpdateCustomer updateCustomer;

    private final DeleteCustomer deleteCustomer;

    CommandCustomerController(CreateCustomer createCustomer, UpdateCustomer updateCustomer, DeleteCustomer deleteCustomer) {
        this.createCustomer = createCustomer;
        this.updateCustomer = updateCustomer;
        this.deleteCustomer = deleteCustomer;
    }

    @Operation(operationId = "createCustomer")
    @PostMapping("/")
    public void create(@RequestBody CreateCustomerDTO customerDTO) {
        createCustomer.create(customerDTO);
    }

    @Operation(operationId = "updatePutCustomer")
    @PutMapping("/{id}")
    public Long update(@PathVariable String id, @RequestBody UpdateCustomerDTO customerDTO) {
        customerDTO.setId(id);
        return this.updateCustomer.update(customerDTO);
    }

    @Operation(operationId = "deleteCustomer")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        deleteCustomer.delete(id);
    }

 */
}
