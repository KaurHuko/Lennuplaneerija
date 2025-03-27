package io.github.kaurhuko.lennuplaneerija.lennud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;

public interface LendRepository extends JpaRepository<Lend, Long> {

    @Query("select l from Lend l where " +
            "(:valjumisKoht is null or l.valjumisKoht = :valjumisKoht) and " +
            "(:saabumisKoht is null or l.saabumisKoht = :saabumisKoht) and " +
            "(:minValjumisAeg is null or l.valjumisAeg >= :minValjumisAeg) and " +
            "(:maxValjumisAeg is null or l.valjumisAeg <= :maxValjumisAeg) and " +
            "(:minLennuaegMinutid is null or timestampdiff(minute, l.valjumisAeg, l.saabumisAeg) >= :minLennuaegMinutid) and " +
            "(:maxLennuaegMinutid is null or timestampdiff(minute, l.valjumisAeg, l.saabumisAeg) <= :maxLennuaegMinutid) and " +
            "(:minHindEur is null or l.hindEur >= :minHindEur) and " +
            "(:maxHindEur is null or l.hindEur <= :maxHindEur) ")
    List<Lend> findWithFilters(@Param("valjumisKoht") String valjumisKoht,
                               @Param("saabumisKoht") String saabumisKoht,
                               @Param("minValjumisAeg") OffsetDateTime minValjumisAeg,
                               @Param("maxValjumisAeg") OffsetDateTime maxValjumisAeg,
                               @Param("minLennuaegMinutid") Integer minLennuaegMinutid,
                               @Param("maxLennuaegMinutid") Integer maxLennuaegMinutid,
                               @Param("minHindEur") Double minHindEur,
                               @Param("maxHindEur") Double maxHindEur);

}
