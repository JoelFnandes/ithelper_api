package br.ufrn.imd.ITHelper.repository;

import br.ufrn.imd.ITHelper.model.Ticket;
import br.ufrn.imd.ITHelper.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Adicione métodos personalizados de acesso a dados, se necessário

}

