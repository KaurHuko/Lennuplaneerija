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

}
