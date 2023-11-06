package com.api.demo.Service;

import org.springframework.stereotype.Service;

import com.api.demo.Model.DestinoViagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DestinoViagemServiceImpl implements DestinoViagemService {
    private List<DestinoViagem> destinos = new ArrayList<>();

    @Override
    public List<DestinoViagem> listarDestinos() {
        return destinos;
    }

    @Override
    public DestinoViagem cadastrarDestino(DestinoViagem destino) {
        destino.setId((long) (destinos.size() + 1));
        destinos.add(destino);
        return destino;
    }

    @Override
    public DestinoViagem buscarDestinoPorId(Long id) {
        Optional<DestinoViagem> destinoOptional = destinos.stream().filter(d -> d.getId().equals(id)).findFirst();
        return destinoOptional.orElse(null);
    }

    @Override
    public List<DestinoViagem> pesquisarDestinos(String termo) {
        List<DestinoViagem> resultados = new ArrayList<>();
        for (DestinoViagem destino : destinos) {
            if (destino.getNome().toLowerCase().contains(termo.toLowerCase()) ||
                destino.getLocalizacao().toLowerCase().contains(termo.toLowerCase())) {
                resultados.add(destino);
            }
        }
        return resultados;
    }

    @Override
    public boolean avaliarDestino(Long id, double avaliacao) {
        Optional<DestinoViagem> destinoOptional = destinos.stream().filter(d -> d.getId().equals(id)).findFirst();
        if (destinoOptional.isPresent()) {
            DestinoViagem destino = destinoOptional.get();
            destino.setAvaliacao(avaliacao);
            return true;
        }
        return false;
    }

    @Override
    public boolean excluirDestino(Long id) {
        Optional<DestinoViagem> destinoOptional = destinos.stream().filter(d -> d.getId().equals(id)).findFirst();
        if (destinoOptional.isPresent()) {
            destinos.remove(destinoOptional.get());
            return true;
        }
        return false;
    }
}
