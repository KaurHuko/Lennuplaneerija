package io.github.kaurhuko.lennuplaneerija.lennud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LendController {

    private final LendRepository repository;

    public LendController(LendRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/lennud")
    List<Lend> all(@RequestParam(required = false) String valjumisKoht,
                   @RequestParam(required = false) String saabumisKoht,
                   @RequestParam(required = false) Double minHindEur,
                   @RequestParam(required = false) Double maxHindEur) {
        return repository.findWithFilters(valjumisKoht, saabumisKoht, minHindEur, maxHindEur);
    }

}
