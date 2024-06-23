package uni.parthenope.carsharing.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "veicoli")
public class Veicolo implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "marca", nullable = false)
        private String marca;

        @Column(name = "modello", nullable = false)
        private String modello;

        @Column(name = "anno", nullable = false)
        private int anno;

        @Column(name = "targa", unique = true, nullable = false)
        private String targa;

        @Column(name = "colore")
        private String colore;

        @Column(name = "tipo_carburante")
        private String tipoCarburante;

        @Column(name = "chilometraggio")
        private int chilometraggio;

        @Column(name = "data_ultima_manutenzione")
        private Date dataUltimaManutenzione;

        @Column(name = "disponibilita")
        private boolean disponibilita;


        @ManyToOne
        @JoinColumn(name = "parcheggio_id", nullable = false)
        private Parcheggio parcheggio;

        // Esempio di relazione uno-a-molti con altre entità (ad es. Prenotazioni)
        @OneToMany(mappedBy = "veicolo")
        private List<Prenotazione> prenotazioni;


    public Veicolo() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }
}
