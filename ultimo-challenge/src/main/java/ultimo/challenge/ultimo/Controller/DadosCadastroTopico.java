package ultimo.challenge.ultimo.Controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



public record DadosCadastroTopico(@NotBlank String titulo, @NotBlank String mensagem, @NotNull Long idAutor, @NotNull Long idCurso) {
    
}