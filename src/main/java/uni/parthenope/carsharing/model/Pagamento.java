package uni.parthenope.carsharing.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagamenti")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pagamento_id")
    private Long pagamentoId;

    @ManyToOne
    @JoinColumn(name = "prenotazione_id", referencedColumnName = "id")
    private Prenotazione prenotazioneId;

    @Column(name = "data_pagamento", nullable = false)
    private LocalDate dataPagamento;

    @Column(name = "importo", nullable = false)
    private BigDecimal importo;

    @Column(name = "metodo_pagamento", nullable = false, length = 50)
    private String metodoPagamento;

    // Costruttore vuoto necessario per JPA
    public Pagamento() {
    }

    // Getter e Setter per pagamentoId
    public Long getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(Long pagamentoId) {
        this.pagamentoId = pagamentoId;
    }


    // Getter e Setter per dataPagamento
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    // Getter e Setter per importo
    public BigDecimal getImporto() {
        return importo;
    }

    public void setImporto(BigDecimal importo) {
        this.importo = importo;
    }

    // Getter e Setter per metodoPagamento
    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
