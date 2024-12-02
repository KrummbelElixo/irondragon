package br.unitins.tp1.irondragon.service.pedido;

import br.unitins.tp1.irondragon.dto.request.PedidoRequestDTO;
import br.unitins.tp1.irondragon.model.pedido.Pedido;

import java.util.List;

public interface PedidoService {
    public Pedido findById(Long id);

    public Pedido create(PedidoRequestDTO dto, String username);

    void cancelPedido(Long idPedido, String username);

    public Pedido findPedidoByIdPagamento(Long idPagamento);

    List<Pedido> findAll();

    Pedido findByUsername(String username);
}
