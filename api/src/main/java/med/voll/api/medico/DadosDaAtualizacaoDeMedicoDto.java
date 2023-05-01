package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosDoEnderecoDto;

public record DadosDaAtualizacaoDeMedicoDto(

        @NotNull
        Long id,

        String nome,
        String telefone,
        DadosDoEnderecoDto endereco
) {
}
