package education.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    private String name;
    private String surname;
    private int age;
    private String email;
    private int phoneNumber;
    private String lesson;
    private Date DateOfBirth;


}