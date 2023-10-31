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
@JsonPropertyOrder({"id", "username", "password"})
public class User implements UserDetails {

    @Id
    @Column(name="idusuario", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(length = 40, name = "nomecompleto")
    private String nomeCompleto;

    @Column(length = 30, name = "email")
    private String email;

    @Column(name = "datanascimento")
    private java.sql.Timestamp dataNascimento;


    @Column(length = 25, unique = true, name = "nomeusuario")
    private String login;

    @Column(length = 16, name = "senha")
    private String password;

    @Column(length = 1, name = "tipousuario")
    private String tipoUsuario;

    public User() {

    }
    @JsonView(Views.Admin.class)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        // TODO Auto-generated method stub
        return login;
    }

    public void setLogin(String login) {
        // TODO Auto-generated method stub
        this.login= login;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String encryptedPassword) {
        // TODO Auto-generated method stub
        this.password = encryptedPassword;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    @JsonView(Views.Admin.class)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    @JsonView({Views.Public.class, Views.Admin.class})
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }

    @Override
    @JsonView({Views.Public.class, Views.Admin.class})
    public String getUsername() {
        // TODO Auto-generated method stub
        return login;
    }

    @Override
    @JsonView(Views.Admin.class)
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    @JsonView(Views.Admin.class)
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    @JsonView(Views.Admin.class)
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    @JsonView(Views.Admin.class)
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }


}
