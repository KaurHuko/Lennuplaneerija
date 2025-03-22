package io.github.kaurhuko.lennuplaneerija.lennud;

import java.time.LocalDateTime;

public class LendDTO {

    private String lennuNumber;
    private String lennuFirma;
    private String valjumisKoht;
    private String saabumisKoht;
    private LocalDateTime valjumisAeg;
    private LocalDateTime saabumisAeg;

    public LendDTO(Lend lend) {
        this.lennuNumber = lend.getLennuNumber();
        this.lennuFirma = lend.getLennuFirma();
        this.valjumisKoht = lend.getValjumisKoht();
        this.saabumisKoht = lend.getSaabumisKoht();
        this.valjumisAeg = lend.getValjumisAeg();
        this.saabumisAeg = lend.getSaabumisAeg();
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

}
