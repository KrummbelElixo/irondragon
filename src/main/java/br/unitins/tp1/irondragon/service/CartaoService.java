package br.unitins.tp1.irondragon.service;

import br.unitins.tp1.irondragon.dto.request.CartaoRequestDTO;
import br.unitins.tp1.irondragon.model.Cartao;

import java.util.List;

public interface CartaoService {
    public Cartao findById(Long id);

    public List<Cartao> findByNome(String nome);

    public List<Cartao> findAll();

    public Cartao create(CartaoRequestDTO dto);

    public void update(Long id, CartaoRequestDTO dto);

    public void delete(Long id);
}
