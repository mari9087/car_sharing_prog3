package uni.parthenope.carsharing.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "utenti")
public class Utente {

    //ATTRIBUTI

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_tessera")
    private String tessera;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "codice_fiscale", nullable = false, unique = true, length = 10)
    private String codiceFiscale;

    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "data_scadenza")
    @Temporal(TemporalType.DATE)
    private Date dataScadenza;

    @Column(name = "quota_annuale")
    private double quotaAnnuale;


    public Utente() {

    }

    //GETTER E SETTER


    public String getTessera() {
        return tessera;
    }

    public void setTessera(String tessera) {
        this.tessera = tessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public double getQuotaAnnuale() {
        return quotaAnnuale;
    }

    public void setQuotaAnnuale(double quotaAnnuale) {
        this.quotaAnnuale = quotaAnnuale;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
