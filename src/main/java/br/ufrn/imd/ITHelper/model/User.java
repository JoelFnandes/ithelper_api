package br.ufrn.imd.ITHelper.model;

import br.ufrn.imd.ITHelper.config.Views;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="Usuario", schema = "public")
@JsonPropertyOrder({"id", "nomeCompleto", "email", "dataNascimento", "nomeUsuario", "tipoUsuario"})
public class User implements UserDetails {

    @Id
    @Column(name="idusuario", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40, name = "nomecompleto")
    private String nomeCompleto;

    @Column(length = 30, name = "email")
    private String email;

    @Column(name = "datanascimento")
    private java.sql.Timestamp dataNascimento;


    @Column(length = 25, unique = true, name = "nomeusuario")
    private String nomeUsuario;

    @Column(length = 16, name = "senha")
    private String password;

    @Column(length = 1, name = "tipousuario")
    private String tipoUsuario;

    public User() {

    }

    @JsonView({Views.Public.class})
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonView({Views.Public.class})
    public String getNomeUsuario() {
        // TODO Auto-generated method stub
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        // TODO Auto-generated method stub
        this.nomeUsuario = nomeUsuario;
    }
    public String getPass() {
        return password;
    }

    public void setPass(String encryptedPassword) {
        // TODO Auto-generated method stub
        this.password = encryptedPassword;
    }

    @JsonView({Views.Public.class})
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    @JsonView({Views.Public.class})
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonView({Views.Public.class})
    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @JsonView({Views.Public.class})
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return nomeUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }



}
