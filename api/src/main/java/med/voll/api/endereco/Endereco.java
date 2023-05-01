package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(DadosDoEnderecoDto endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.complemento = endereco.complemento();
        this.numero = endereco.numero();
    }

    public void atualizarInformacoes(DadosDoEnderecoDto dadosDoEnderecoDto) {
        if (dadosDoEnderecoDto.logradouro() != null && !dadosDoEnderecoDto.logradouro().isEmpty()) {
            this.logradouro = dadosDoEnderecoDto.logradouro();
        }

        if (dadosDoEnderecoDto.bairro() != null && !dadosDoEnderecoDto.bairro().isEmpty()) {
            this.bairro = dadosDoEnderecoDto.bairro();
        }

        if (dadosDoEnderecoDto.cep() != null && !dadosDoEnderecoDto.cep().isEmpty()) {
            this.cep = dadosDoEnderecoDto.cep();
        }

        if (dadosDoEnderecoDto.cidade() != null && !dadosDoEnderecoDto.cidade().isEmpty()) {
            this.cidade = dadosDoEnderecoDto.cidade();
        }

        if (dadosDoEnderecoDto.uf() != null && !dadosDoEnderecoDto.uf().isEmpty()) {
            this.uf = dadosDoEnderecoDto.uf();
        }
        if (dadosDoEnderecoDto.complemento() != null && !dadosDoEnderecoDto.complemento().isEmpty()) {
            this.complemento = dadosDoEnderecoDto.complemento();
        }

        if (dadosDoEnderecoDto.numero() != null && !dadosDoEnderecoDto.numero().isEmpty()) {
            this.numero = dadosDoEnderecoDto.numero();
        }
    }
}
