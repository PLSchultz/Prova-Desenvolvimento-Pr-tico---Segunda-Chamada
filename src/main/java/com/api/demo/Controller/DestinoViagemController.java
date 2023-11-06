package com.api.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.demo.Model.DestinoViagem;
import com.api.demo.Service.DestinoViagemService;

@RestController
@RequestMapping("/api/destinos")
public class DestinoViagemController {
    @Autowired
    private DestinoViagemService destinoViagemService;

    @GetMapping("/")
    public ResponseEntity<List<DestinoViagem>> listarDestinos() {
        try {
            List<DestinoViagem> destinos = destinoViagemService.listarDestinos();
            return ResponseEntity.ok(destinos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<DestinoViagem> cadastrarDestino(@RequestBody DestinoViagem destino) {
        try {
            DestinoViagem novoDestino = destinoViagemService.cadastrarDestino(destino);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoDestino);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinoViagem> buscarDestinoPorId(@PathVariable Long id) {
        try {
            DestinoViagem destino = destinoViagemService.buscarDestinoPorId(id);
            if (destino != null) {
                return ResponseEntity.ok(destino);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<List<DestinoViagem>> pesquisarDestinos(@RequestParam(name = "termo") String termo) {
        try {
            List<DestinoViagem> destinos = destinoViagemService.pesquisarDestinos(termo);
            return ResponseEntity.ok(destinos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}/avaliar")
    public ResponseEntity<String> avaliarDestino(@PathVariable Long id, @RequestParam(name = "avaliacao") double avaliacao) {
        try {
            boolean sucesso = destinoViagemService.avaliarDestino(id, avaliacao);
            if (sucesso) {
                return ResponseEntity.ok("Destino avaliado com sucesso.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirDestino(@PathVariable Long id) {
        try {
            boolean sucesso = destinoViagemService.excluirDestino(id);
            if (sucesso) {
                return ResponseEntity.ok("Destino excluído com sucesso.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
