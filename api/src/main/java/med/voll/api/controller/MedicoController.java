package med.voll.api.controller;

import jakarta.transaction.Transactional;
import med.voll.api.endereco.DadosDoEnderecoDto;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosDoCadastroDeMedicoDto;
import med.voll.api.medico.Especialide;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosDoCadastroDeMedicoDto dados) {
        Medico medico = new Medico(dados);
        repository.save(medico);
    }
}
