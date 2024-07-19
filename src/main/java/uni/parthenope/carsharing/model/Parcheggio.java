package uni.parthenope.carsharing.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "parcheggi")
public class Parcheggio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "indirizzo", nullable = false)
    private String indirizzo;

    @Column(name = "capacita_auto", nullable = false)
    private int capacitaAuto;

    @Column(name = "orario_apertura", nullable = false)
    private LocalDateTime orarioApertura;

    @Column(name = "orario_chiusura", nullable = false)
    private LocalDateTime orarioChiusura;

    @Column(name = "tariffa_oraria", nullable = false)
    private BigDecimal tariffaOraria;

    @OneToMany(mappedBy = "parcheggio")
    private List<Veicolo> veicoli;

    public Parcheggio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public List<Veicolo> getVeicoli() {
        return veicoli;
    }

    public void setVeicoli(List<Veicolo> veicoli) {
        this.veicoli = veicoli;
    }

    public int getCapacitaAuto() {
        return capacitaAuto;
    }

    public void setCapacitaAuto(int capacitaAuto) {
        this.capacitaAuto = capacitaAuto;
    }

    public LocalDateTime getOrarioApertura() {
        return orarioApertura;
    }

    public void setOrarioApertura(LocalDateTime orarioApertura) {
        this.orarioApertura = orarioApertura;
    }

    public LocalDateTime getOrarioChiusura() {
        return orarioChiusura;
    }

    public void setOrarioChiusura(LocalDateTime orarioChiusura) {
        this.orarioChiusura = orarioChiusura;
    }

    public BigDecimal getTariffaOraria() {
        return tariffaOraria;
    }

    public void setTariffaOraria(BigDecimal tariffaOraria) {
        this.tariffaOraria = tariffaOraria;
    }
}
