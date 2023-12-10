package br.ufrn.imd.ITHelper.repository;

import br.ufrn.imd.ITHelper.model.TicketAttribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketAttributionRepository extends JpaRepository<TicketAttribution, Long> {
    // Add custom methods if needed
}
