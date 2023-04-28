package springboot.app.com.iconsult.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data


public class player {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String sports;
}
