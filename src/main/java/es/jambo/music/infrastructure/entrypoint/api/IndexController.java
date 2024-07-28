package es.jambo.music.infrastructure.entrypoint.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
final class IndexController {
    @GetMapping("/")
    public String index() {
        return "Welcome to Jambo Architecture";
    }
}
