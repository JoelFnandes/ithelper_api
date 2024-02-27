package br.ufrn.imd.ITHelper.service;

import br.ufrn.imd.ITHelper.model.Ticket;
import br.ufrn.imd.ITHelper.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket criarTicket(Ticket ticket) {
        // Adicione aqui a lógica necessária antes de salvar o ticket, se aplicável
        return ticketRepository.save(ticket);
    }

    public Ticket obterTicketPorId(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public List<Ticket> obterTicketsAbertos() {
        return ticketRepository.findByStatusChamado('P'); // Supondo que 'A' represente o status de "aberto"
    }

    public List<Ticket> obterTicketsVinculados(Long idFuncionario) {
        return ticketRepository.findByFuncionario_IdFuncionario(idFuncionario);
    }

    public List<Ticket> listarTickets() {
        return ticketRepository.findAll();
    }

    // Adicione outros métodos conforme necessário, como atualizar e excluir tickets
}

