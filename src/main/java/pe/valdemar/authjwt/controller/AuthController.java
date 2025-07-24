package pe.valdemar.authjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.valdemar.authjwt.model.AuthRequest;
import pe.valdemar.authjwt.model.TokenProperties;
import pe.valdemar.authjwt.util.TokenUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final TokenUtil tokenUtil;
    private final TokenProperties tokenProperties;

    public AuthController(TokenUtil tokenUtil, TokenProperties tokenProperties) {
        this.tokenUtil = tokenUtil;
        this.tokenProperties = tokenProperties;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        if (tokenProperties.getUsername().equals(request.getUsername()) &&
                tokenProperties.getPassword().equals(request.getPassword())) {
            String token = tokenUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(token);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }
}
