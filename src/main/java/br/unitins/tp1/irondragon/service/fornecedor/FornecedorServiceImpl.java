package br.unitins.tp1.irondragon.service.fornecedor;

import br.unitins.tp1.irondragon.dto.request.FornecedorRequestDTO;
import br.unitins.tp1.irondragon.model.Fornecedor;
import br.unitins.tp1.irondragon.repository.FornecedorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class FornecedorServiceImpl implements FornecedorService {
    @Inject
    public FornecedorRepository fornecedorRepository;

    @Override
    public Fornecedor findById(Long id) {
        return fornecedorRepository.findById(id);
    }

    @Override
    public List<Fornecedor> findByNome(String nome) {
        return fornecedorRepository.findByNome(nome);
    }

    @Override
    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll().list();
    }

    @Transactional
    @Override
    public Fornecedor create(FornecedorRequestDTO dto) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.nome());
        fornecedor.setEmail(dto.email());

        fornecedorRepository.persist(fornecedor);

        return fornecedor;
    }

    @Transactional
    @Override
    public void update(Long id, FornecedorRequestDTO dto) {
        Fornecedor fornecedor = fornecedorRepository.findById(id);
        fornecedor.setNome(dto.nome());
        fornecedor.setEmail(dto.email());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
