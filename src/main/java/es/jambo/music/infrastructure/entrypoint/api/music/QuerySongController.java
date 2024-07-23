package es.jambo.music.infrastructure.entrypoint.api.music;

import es.jambo.music.infrastructure.shared.EndPoints;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoints.SongEndPoints.SONG)
final class QuerySongController {
/*

    @GetMapping("/{id}")
    public ViewCustomerDTO get(@PathVariable String id) {
        return searchCustomer.byId(id);
    }
 */
}
