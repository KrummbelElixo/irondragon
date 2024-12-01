package br.unitins.tp1.irondragon.dto.request;

import br.unitins.tp1.irondragon.model.TelefoneFabricante;
import br.unitins.tp1.irondragon.model.TelefoneFornecedor;
import jakarta.validation.constraints.NotBlank;

public record TelefoneRequestDTO(
        @NotBlank
        String codigoArea,
        @NotBlank
        String numero
) {
    public TelefoneFornecedor toEntityTelefoneFornecedor() {
        TelefoneFornecedor telefoneFornecedor = new TelefoneFornecedor();
        telefoneFornecedor.setCodigoArea(codigoArea());
        telefoneFornecedor.setNumero(numero());

        return telefoneFornecedor;
    }

    public TelefoneFabricante toEntityTelefoneFabricante() {
        TelefoneFabricante telefoneFabricante = new TelefoneFabricante();
        telefoneFabricante.setCodigoArea(codigoArea());
        telefoneFabricante.setNumero(numero());

        return telefoneFabricante;
    }
}
