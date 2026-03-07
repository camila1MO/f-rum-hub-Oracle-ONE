package ultimo.challenge.ultimo.Domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ultimo.challenge.ultimo.Controller.DadosCadastroTopico;
import ultimo.challenge.ultimo.challenge.DadosAtualizacaoTopico;

@Entity
@Table(name="topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private String status = "NAO_RESPONDIDO";

    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Curso curso;

    public Topico(DadosCadastroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
    }

    public void atualizarDados(DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null) this.titulo = dados.titulo();
        if (dados.mensagem() != null) this.mensagem = dados.mensagem();
    }
}