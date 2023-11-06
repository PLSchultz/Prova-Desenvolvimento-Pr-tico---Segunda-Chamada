package com.api.demo.Service;

import java.util.List;

import com.api.demo.Model.DestinoViagem;

public interface DestinoViagemService {
    List<DestinoViagem> listarDestinos();
    DestinoViagem cadastrarDestino(DestinoViagem destino);
    DestinoViagem buscarDestinoPorId(Long id);
    List<DestinoViagem> pesquisarDestinos(String termo);
    boolean avaliarDestino(Long id, double avaliacao);
    boolean excluirDestino(Long id);
}
