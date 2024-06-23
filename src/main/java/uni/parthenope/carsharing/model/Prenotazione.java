package uni.parthenope.carsharing.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "tessera_cliente", referencedColumnName = "numero_tessera")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "veicolo_id", referencedColumnName = "id")
    private Veicolo veicolo;

    @ManyToOne
    @JoinColumn(name = "parcheggio_id", referencedColumnName = "id")
    private Parcheggio parcheggio;

    @Column(name = "data_prenotazione", nullable = false)
    private LocalDateTime data;

    @Column(name = "data_inizio", nullable = false)
    private LocalDateTime dataInizio;

    @Column(name = "data_fine", nullable = false)
    private LocalDateTime dataFine;

    @Column(name = "stato_prenotazione", nullable = false) //"Confermata" o "Annullata"
    private String stato;

    public Prenotazione() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Parcheggio getParcheggio() {
        return parcheggio;
    }

    public void setParcheggio(Parcheggio parcheggio) {
        this.parcheggio = parcheggio;
    }

    public LocalDateTime getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDateTime dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDateTime getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDateTime dataFine) {
        this.dataFine = dataFine;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
}
