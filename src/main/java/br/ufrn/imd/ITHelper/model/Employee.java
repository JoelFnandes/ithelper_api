package br.ufrn.imd.ITHelper.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Funcionario", schema = "public")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfuncionario")
    private Long idFuncionario;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idusuario", nullable = false)
    private User usuario;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "iddepartamento", nullable = false)
    private Department departamento;

    @Column(name = "cargofuncionario")
    private String cargoFuncionario;

    // Outros atributos e métodos

    // Getters e Setters
    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Department getDepartamento() {
        return departamento;
    }



    public void setDepartamento(Department departamento) {
        this.departamento = departamento;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }
}

