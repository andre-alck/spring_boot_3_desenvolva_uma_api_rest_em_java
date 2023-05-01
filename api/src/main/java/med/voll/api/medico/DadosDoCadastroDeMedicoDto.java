package med.voll.api.medico;

import med.voll.api.endereco.DadosDoEnderecoDto;

public record DadosDoCadastroDeMedicoDto(String nome, String email, String crm, Especialide especialide, DadosDoEnderecoDto endereco) {
}
