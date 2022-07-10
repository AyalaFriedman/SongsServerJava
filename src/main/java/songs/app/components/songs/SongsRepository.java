package songs.app.components.songs;
import org.springframework.data.mongodb.repository.MongoRepository;
import songs.app.components.songs.SongModel;

import java.util.List;
import java.util.Optional;

public interface SongsRepository extends MongoRepository<SongModel, Integer> {

    List<SongModel> findByArtist(String name);

    void deleteById(String id);

    Optional<Object> findById(String id);
}
