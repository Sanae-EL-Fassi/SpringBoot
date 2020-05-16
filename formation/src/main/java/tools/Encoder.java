package tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

public class Encoder {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("sanae"));
        System.out.println(encoder.encode("mehdi"));
        System.out.println(encoder.encode("yassine"));
        System.out.println(encoder.encode("ahmed"));
    }
}
