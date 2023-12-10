package br.ufrn.imd.ITHelper.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@JsonIgnoreProperties({"employee"})
@Table(name = "Chamado", schema = "public")
public class Ticket {

    @Id
    @Column(name = "idchamado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChamado;


    @ManyToOne
    @JoinColumn(name = "idfuncionario", nullable = false)
    private Employee funcionario;

    @Column(name = "descricaochamado")
    private String descricaoChamado;

    @Column(name = "datahoraabertura", nullable = true)
    private Timestamp dataHoraAbertura;


    @Column(name = "prioridade", nullable = true)
    private char prioridade;


    @Column(name = "statuschamado", nullable = true)
    private char statusChamado;

    @Column(name = "datahorafechamento", nullable = true)
    private Timestamp dataHoraFechamento;

    // getters and setters

    public Long getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(Long idChamado) {
        this.idChamado = idChamado;
    }

    public Employee getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Employee funcionario) {
        this.funcionario = funcionario;
    }

    public String getDescricaoChamado() {
        return descricaoChamado;
    }

    public void setDescricaoChamado(String descricaoChamado) {
        this.descricaoChamado = descricaoChamado;
    }

    public Timestamp getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(Timestamp dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public char getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(char prioridade) {
        this.prioridade = prioridade;
    }

    public char getStatusChamado() {
        return statusChamado;
    }

    public void setStatusChamado(char statusChamado) {
        this.statusChamado = statusChamado;
    }

    public Timestamp getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(Timestamp dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }
}
