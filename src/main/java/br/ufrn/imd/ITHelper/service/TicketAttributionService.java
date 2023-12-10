package br.ufrn.imd.ITHelper.service;

import br.ufrn.imd.ITHelper.model.TicketAttribution;
import br.ufrn.imd.ITHelper.repository.TicketAttributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketAttributionService {

    @Autowired
    private TicketAttributionRepository ticketAttributionRepository;

    public TicketAttribution criarAtribuicaoChamado(TicketAttribution ticketAttribution) {
        // Add business logic if needed
        return ticketAttributionRepository.save(ticketAttribution);
    }

    // Add other service methods if needed
}

