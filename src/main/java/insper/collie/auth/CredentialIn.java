package insper.collie.auth;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder @Accessors(fluent = true, chain = true)
public record CredentialIn(
    String email,
    String password
) { }
