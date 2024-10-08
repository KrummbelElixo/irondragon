package br.unitins.tp1.irondragon.dto.response;

import br.unitins.tp1.irondragon.model.Fornecedor;

public record FornecedorResponseDTO(
        Long id,
        String nome,
        String email
) {
    public static FornecedorResponseDTO valueOf(Fornecedor fornecedor) {
        return new FornecedorResponseDTO(
                fornecedor.getId(),
                fornecedor.getNome(),
                fornecedor.getEmail()
        );
    }
}
