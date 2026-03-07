package ultimo.challenge.ultimo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ultimo.challenge.ultimo.Domain.Topico.TopicoRepository;
import ultimo.challenge.ultimo.Domain.Topico.DadosListagemTopico;
import ultimo.challenge.ultimo.Domain.Topico.DadosDetalhesTopico;
import ultimo.challenge.ultimo.Domain.Topico.DadosDetalhamentoTopico;
import ultimo.challenge.ultimo.Domain.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class UltimoChallengeController {

    @Autowired
    private TopicoRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhesTopico(topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody DadosDetalhamentoTopico dados) {
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhesTopico(topico));
    }
}