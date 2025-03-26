package io.github.kaurhuko.lennuplaneerija.lennud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LendRepository extends JpaRepository<Lend, Long> {

    @Query("select l from Lend l where " +
            "(:minHindEur is null or l.hindEur >= :minHindEur) and " +
            "(:maxHindEur is null or l.hindEur <= :maxHindEur) ")
    List<Lend> findWithFilters(@Param("minHindEur") Double minHindEur,
                               @Param("maxHindEur") Double maxHindEur);

}
