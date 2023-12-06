package br.ufrn.imd.ITHelper.repository;

import br.ufrn.imd.ITHelper.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Adicione métodos personalizados de acesso a dados, se necessário
}

