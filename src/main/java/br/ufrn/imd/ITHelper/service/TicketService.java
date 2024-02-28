package br.ufrn.imd.ITHelper.service;

import br.ufrn.imd.ITHelper.dto.TicketDTO;
import br.ufrn.imd.ITHelper.exception.TicketNotFoundException;
import br.ufrn.imd.ITHelper.exception.UserNotFoundException;
import br.ufrn.imd.ITHelper.model.Ticket;
import br.ufrn.imd.ITHelper.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<TicketDTO> obterTicketsAbertos() {
        List<Ticket> ticketAbertos = ticketRepository.findByStatusChamado('P');

        if(!ticketAbertos.isEmpty()) {
            return ticketAbertos.stream().map(ticket -> {
                TicketDTO ticketDTO = new TicketDTO();

                ticketDTO.setIdChamado(ticket.getIdChamado());
                ticketDTO.setNomeUsuario(ticket.getFuncionario().getUsuario().getNomeUsuario());
                ticketDTO.setDescricaoChamado(ticket.getDescricaoChamado());
                ticketDTO.setDataHoraAbertura(ticket.getDataHoraAbertura());
                ticketDTO.setPrioridade(ticket.getPrioridade());
                ticketDTO.setStatusChamado(ticket.getStatusChamado());
                ticketDTO.setDataHoraFechamento(ticket.getDataHoraFechamento());
                if (ticket.getFuncionario().getDepartamento() != null) {
                    ticketDTO.setNomeDepartamento(ticket.getFuncionario().getDepartamento().getNomeDepartamento());
                } else {
                    ticketDTO.setNomeDepartamento("vazio");
                }
                return ticketDTO;

            }).collect(Collectors.toList());
        }
        return null;
    }

    public List<Ticket> obterTicketsVinculados(Long idFuncionario) {
        return ticketRepository.findByFuncionario_IdFuncionario(idFuncionario);
    }

    public List<Ticket> listarTickets() {
        return ticketRepository.findAll();
    }

    // Adicione outros métodos conforme necessário, como atualizar e excluir tickets
}

