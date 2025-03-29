package io.github.kaurhuko.lennuplaneerija.lennud;

import io.github.kaurhuko.lennuplaneerija.lennujaam.Airport;
import io.github.kaurhuko.lennuplaneerija.lennujaam.AirportService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class LendDTO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lennuNumber;
    private String lennuFirma;
    private String valjumisKoht;
    private String valjumisLinn;
    private String saabumisKoht;
    private String saabumisLinn;
    private LocalDateTime valjumisAeg;
    private LocalDateTime saabumisAeg;
    private Integer lennuaegMinutid;
    private Double hindEur;

    protected LendDTO() {}

    public LendDTO(Lend lend) {
        this.lennuNumber = lend.getLennuNumber();
        this.lennuFirma = lend.getLennuFirma();
        this.valjumisKoht = lend.getValjumisKoht();
        this.saabumisKoht = lend.getSaabumisKoht();
        this.valjumisAeg = lend.getValjumisAeg();
        this.saabumisAeg = lend.getSaabumisAeg();
        this.lennuaegMinutid = lend.getLennuaegMinutid();
        this.hindEur = lend.getHindEur();

        Airport valjumisJaam = AirportService.getAirport(valjumisKoht);
        this.valjumisLinn =  valjumisJaam != null ? valjumisJaam.getMunicipality() : null;
        Airport saabumisJaam = AirportService.getAirport(saabumisKoht);
        this.saabumisLinn = saabumisJaam != null ? saabumisJaam.getMunicipality() : null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLennuNumber() {
        return lennuNumber;
    }

    public void setLennuNumber(String lennuNumber) {
        this.lennuNumber = lennuNumber;
    }

    public String getLennuFirma() {
        return lennuFirma;
    }

    public void setLennuFirma(String lennuFirma) {
        this.lennuFirma = lennuFirma;
    }

    public String getValjumisKoht() {
        return valjumisKoht;
    }

    public void setValjumisKoht(String valjumisKoht) {
        this.valjumisKoht = valjumisKoht;
    }

    public String getSaabumisKoht() {
        return saabumisKoht;
    }

    public void setSaabumisKoht(String saabumisKoht) {
        this.saabumisKoht = saabumisKoht;
    }

    public LocalDateTime getValjumisAeg() {
        return valjumisAeg;
    }

    public void setValjumisAeg(LocalDateTime valjumisAeg) {
        this.valjumisAeg = valjumisAeg;
    }

    public LocalDateTime getSaabumisAeg() {
        return saabumisAeg;
    }

    public void setSaabumisAeg(LocalDateTime saabumisAeg) {
        this.saabumisAeg = saabumisAeg;
    }

    public Integer getLennuaegMinutid() {
        return lennuaegMinutid;
    }

    public void setLennuaegMinutid(Integer lennuaeg) {
        this.lennuaegMinutid = lennuaeg;
    }

    public Double getHindEur() {
        return hindEur;
    }

    public void setHindEur(Double hind) {
        this.hindEur = hind;
    }

    public String getValjumisLinn() {
        return valjumisLinn;
    }

    public void setValjumisLinn(String valjumisLinn) {
        this.valjumisLinn = valjumisLinn;
    }

    public String getSaabumisLinn() {
        return saabumisLinn;
    }

    public void setSaabumisLinn(String saabumisLinn) {
        this.saabumisLinn = saabumisLinn;
    }

}
