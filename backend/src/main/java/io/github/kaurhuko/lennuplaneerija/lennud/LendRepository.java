package io.github.kaurhuko.lennuplaneerija.lennud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface LendRepository extends JpaRepository<Lend, Long> {

    @Query("select l from Lend l where " +
            "(:valjumisKoht is null or l.valjumisKoht = :valjumisKoht) and " +
            "(:saabumisKoht is null or l.saabumisKoht = :saabumisKoht) and " +
            "(:minValjumisAeg is null or l.valjumisAeg >= :minValjumisAeg) and " +
            "(:maxValjumisAeg is null or l.valjumisAeg <= :maxValjumisAeg) and " +
            "(:minLennuaegMinutid is null or l.lennuaegMinutid >= :minLennuaegMinutid) and " +
            "(:maxLennuaegMinutid is null or l.lennuaegMinutid <= :maxLennuaegMinutid) and " +
            "(:minHindEur is null or l.hindEur >= :minHindEur) and " +
            "(:maxHindEur is null or l.hindEur <= :maxHindEur) ")
    List<Lend> findWithFilters(@Param("valjumisKoht") String valjumisKoht,
                               @Param("saabumisKoht") String saabumisKoht,
                               @Param("minValjumisAeg") LocalDateTime minValjumisAeg,
                               @Param("maxValjumisAeg") LocalDateTime maxValjumisAeg,
                               @Param("minLennuaegMinutid") Integer minLennuaegMinutid,
                               @Param("maxLennuaegMinutid") Integer maxLennuaegMinutid,
                               @Param("minHindEur") Double minHindEur,
                               @Param("maxHindEur") Double maxHindEur);

}
