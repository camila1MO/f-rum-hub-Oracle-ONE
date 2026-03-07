package ultimo.challenge.ultimo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import ultimo.challenge.ultimo.Domain.Usuario;
import ultimo.challenge.ultimo.challenge.DadosAutenticados;
import ultimo.challenge.ultimo.Domain.Tokenzinho;

@RestController
@RequestMapping("/login")
public class Autenticacaocontroller {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private Tokenzinho tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticados dados) {
        // Cria o token de autenticação do Spring Security
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        
        // Autentica o usuário
        var authentication = manager.authenticate(authenticationToken);

        // Gera o Token JWT usando o serviço Tokenzinho
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        // Retorna o token em um DTO (você precisará criar o record DadosTokenJWT)
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}