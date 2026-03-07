package ultimo.challenge.ultimo.challenge;
import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoTopico(
    Long id, 
    @NotBlank String titulo, 
    @NotBlank String mensagem
) { }
