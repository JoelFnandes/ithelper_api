package br.ufrn.imd.ITHelper.controller;

import br.ufrn.imd.ITHelper.model.Ticket;
import br.ufrn.imd.ITHelper.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamado")
public class TicketContoller {

    private final TicketService ticketService;

    @Autowired
    public TicketContoller(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> criarTicket(@RequestBody Ticket chamado) {
        Ticket novoTicket = ticketService.criarTicket(chamado);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTicket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> obterTicketPorId(@PathVariable Long id) {
        Ticket chamado = ticketService.obterTicketPorId(id);
        if (chamado != null) {
            return ResponseEntity.ok(chamado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Ticket> listarTickets() {
        return ticketService.listarTickets();
    }

    // Adicione outros métodos conforme necessário, como atualizar e excluir chamados
}


