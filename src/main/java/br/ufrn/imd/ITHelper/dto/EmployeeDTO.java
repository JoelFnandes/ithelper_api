package br.ufrn.imd.ITHelper.dto;

import br.ufrn.imd.ITHelper.config.Views;
import br.ufrn.imd.ITHelper.model.Department;
import br.ufrn.imd.ITHelper.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class EmployeeDTO {
    @JsonView(Views.Public.class)
    private Long idFuncionario;

    @JsonView(Views.Public.class)
    private String cargoFuncionario;

    @JsonView(Views.Public.class)
    private long idDepartamento;

    @JsonView(Views.Public.class)
    private long idUsuario;

    @JsonView(Views.Public.class)
    private String nomeDepartamento;



    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }
}
