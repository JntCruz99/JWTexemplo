package org.example;

public class Main {
    public static void main(String[] args) {
        JwtExample jwtExample = new JwtExample();

        String username = "usuario123";

        // Gerar token
        String token = jwtExample.generateToken(username);
        System.out.println("Token gerado: " + token);

        // Validar token
        boolean isValid = jwtExample.validateToken(token);
        System.out.println("Token válido: " + isValid);
    }
}
