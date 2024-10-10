package br.unitins.tp1.irondragon.dto.response;

import br.unitins.tp1.irondragon.model.Cartao;

import java.time.LocalDate;

public record CartaoResponseDTO(
        Long id,
        String nomeTitular,
        String numero,
        String cpf,
        LocalDate validade,
        Integer cvc
) {
    public static CartaoResponseDTO valueOf(Cartao cartao) {
        return new CartaoResponseDTO(
                cartao.getId(),
                cartao.getNomeTitular(),
                cartao.getNumero(),
                cartao.getCpf(),
                cartao.getValidade(),
                cartao.getCvc()
        );
    }
}

