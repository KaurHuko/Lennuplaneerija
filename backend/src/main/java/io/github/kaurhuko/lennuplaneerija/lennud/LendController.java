package io.github.kaurhuko.lennuplaneerija.lennud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LendController {

    private final LendRepository repository;

    public LendController(LendRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    List<Lend> all() {
        return repository.findAll();
    }

}
