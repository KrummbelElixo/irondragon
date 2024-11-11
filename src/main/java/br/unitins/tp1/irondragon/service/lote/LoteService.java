package br.unitins.tp1.irondragon.service.lote;

import br.unitins.tp1.irondragon.dto.request.LoteRequestDTO;
import br.unitins.tp1.irondragon.model.pedido.Lote;

public interface LoteService {
    Lote findByCodigo(String codigo);

    Lote findById(Long id);

    Lote create(LoteRequestDTO dto);

    Lote findByIdProcessador(Long id);

    void update(Long id, LoteRequestDTO dto);
}