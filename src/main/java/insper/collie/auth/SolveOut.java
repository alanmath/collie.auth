package insper.collie.auth;

import lombok.Builder;

@Builder
public record SolveOut(
    String id,
    String name,
    String role
) {
}
