package br.ufrn.imd.ITHelper.model;


import jakarta.persistence.*;
@Entity
@Table(name = "chamado", schema = "public")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idchamado")
    private Long idTicket;

    @Column(name = "descricaochamado")
    private String descricaoTicket;

    @ManyToOne
    @JoinColumn(name = "idfuncionario", nullable = false)
    private Employee employee;


    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public String getDescricaoTicket() {
        return descricaoTicket;
    }

    public void setDescricaoTicket(String descricaoTicket) {
        this.descricaoTicket = descricaoTicket;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}


