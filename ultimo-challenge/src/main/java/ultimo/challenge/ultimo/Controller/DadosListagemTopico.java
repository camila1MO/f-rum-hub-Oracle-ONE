package ultimo.challenge.ultimo.Controller;
import java.time.LocalDateTime;
import ultimo.challenge.ultimo.Domain.Topico;

public record DadosListagemTopico(
    Long id, String titulo, String mensagem, String status, String autor, String curso, LocalDateTime dataCriacao
) {
    public DadosListagemTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), 
             topico.getStatus(), topico.getAutor().getNome(), 
             topico.getCurso().getNome(), topico.getDataCriacao());
    }
}
    
     
