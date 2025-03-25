package io.github.kaurhuko.lennuplaneerija.lennud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Lend {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lennuNumber;
    private String lennuFirma;
    private String valjumisKoht;
    private String saabumisKoht;
    private LocalDateTime valjumisAeg;
    private LocalDateTime saabumisAeg;
    private Double hindEur;


    protected Lend() {}

    public Lend(String lennuNumber, String lennuFirma, String valjumisKoht, String saabumisKoht, LocalDateTime valjumisAeg, LocalDateTime saabumisAeg, Double hindEur) {
        this.lennuNumber = lennuNumber;
        this.lennuFirma = lennuFirma;
        this.valjumisKoht = valjumisKoht;
        this.saabumisKoht = saabumisKoht;
        this.valjumisAeg = valjumisAeg;
        this.saabumisAeg = saabumisAeg;
        this.hindEur = hindEur;
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

    public Double getHindEur() {
        return hindEur;
    }

    public void setHindEur(Double hind) {
        this.hindEur = hind;
    }
}
