package education.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson implements Serializable {

    private String lesson;
    private String lectureName;
    private int duration;
    private int price;


}
