package songs.app.components.songs;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Objects;

enum genreEnum {ROCK, POP, RAP, CLASSICAL}

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "songs")
public class SongModel {
    @Id
    private String id;
    private String title;
    private String artist;
    private genreEnum genre;
    private int length;
    private float price;
}
