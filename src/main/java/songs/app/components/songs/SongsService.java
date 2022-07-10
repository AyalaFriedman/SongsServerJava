package songs.app.components.songs;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongsService implements SongsInterface {
    @Autowired
    private SongsRepository songsRepository;

    public List<SongModel> getAllSongs(){
        return songsRepository.findAll();
    }

    public SongModel addSong(SongModel songModel){
        return songsRepository.save(songModel);
    }

    public SongModel updateSong(String id, SongModel song){
//        return songsRepository.save(song);
        return songsRepository.findById(id)
                .map(songModel -> {
                    SongModel songToEdit = (SongModel)songModel;
                    songToEdit.setTitle(song.getTitle());
                    songToEdit.setArtist(song.getArtist());
                    songToEdit.setGenre(song.getGenre());
                    songToEdit.setLength(song.getLength());
                    songToEdit.setPrice(song.getPrice());
                    return songsRepository.save(songToEdit);
                })
                .orElseGet(() -> {
                    song.setId(id);
                    return songsRepository.save(song);
                });
    }

    public List<SongModel> getSongsByArtist(String name){
        List<SongModel> fullList = songsRepository.findByArtist(name);
        return fullList;
    }

    public Optional<SongModel> getSongById(int id){
        return songsRepository.findById(id);
    }

    public String deleteOneSong(String id){
        try{
            songsRepository.deleteById(id);
            return "deleted document";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
