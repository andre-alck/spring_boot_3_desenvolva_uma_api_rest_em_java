package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosDoCadastroDeMedicoDto dto) {
        Medico medico = new Medico(dto);
        repository.save(medico);
    }

    @GetMapping
    public Page<DadosDaListagemDeMedicoDto> listar(@PageableDefault(size = 20) Pageable pageable) {
        Page<Medico> medicos = repository.findAllByAtivoTrue(pageable);
        return medicos.map(DadosDaListagemDeMedicoDto::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosDaAtualizacaoDeMedicoDto dadosDaAtualizacaoDeMedicoDto) {
        Medico medico = repository.getReferenceById(dadosDaAtualizacaoDeMedicoDto.id());
        medico.atualizarInformacoes(dadosDaAtualizacaoDeMedicoDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        Medico medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
