package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosDoCadastroDeMedicoDto dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosDaAtualizacaoDeMedicoDto dadosDaAtualizacaoDeMedicoDto) {
        if (dadosDaAtualizacaoDeMedicoDto.nome() != null && !dadosDaAtualizacaoDeMedicoDto.nome().isEmpty()) {
            this.nome = dadosDaAtualizacaoDeMedicoDto.nome();
        }

        if (dadosDaAtualizacaoDeMedicoDto.telefone() != null && !dadosDaAtualizacaoDeMedicoDto.telefone().isEmpty()) {
            this.telefone = dadosDaAtualizacaoDeMedicoDto.telefone();
        }

        if (dadosDaAtualizacaoDeMedicoDto.endereco() != null) {
            this.endereco.atualizarInformacoes(dadosDaAtualizacaoDeMedicoDto.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}