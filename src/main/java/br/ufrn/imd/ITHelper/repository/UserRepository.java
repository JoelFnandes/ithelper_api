package br.ufrn.imd.ITHelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ufrn.imd.ITHelper.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByLogin(String login);

}
