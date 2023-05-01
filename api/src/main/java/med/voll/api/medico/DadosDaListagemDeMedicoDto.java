package med.voll.api.medico;

public record DadosDaListagemDeMedicoDto(Long id, String nome, String email, String crm,
                                         Especialidade especialidade) {
    public DadosDaListagemDeMedicoDto(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
