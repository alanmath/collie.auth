package insper.collie.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "collie-auth")
public interface AuthController {

    @PostMapping("/auth/register")
    ResponseEntity<?> create (
        @RequestBody(required = true) RegisterIn in
    );

    @PostMapping("/auth/login")
    ResponseEntity<LoginOut> authenticate (
        @RequestBody(required = true) CredentialIn in,
        @RequestHeader(required = false, name = "secret") String secret
    );

    @PostMapping("/auth/solve")
    ResponseEntity<SolveOut> solve (
        @RequestBody(required = true) SolveIn in
    );

}