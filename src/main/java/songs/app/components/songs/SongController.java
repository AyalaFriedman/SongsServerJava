package songs.app.components.songs;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/songs")
@RestController
public class SongController {

    @Autowired
    SongsService songsService;
    @CrossOrigin
    @GetMapping("/getAllSongs")
    public List<SongModel> getAllSongs() {
        return songsService.getAllSongs();
    }

    @CrossOrigin
    @PostMapping("/addSong")
    public SongModel addSong(@RequestBody SongModel songModel){
        return songsService.addSong(songModel);
    }

    @CrossOrigin
    @PutMapping("/updateSong/{id}")
    public SongModel updateSong(@PathVariable String id, @RequestBody SongModel songModel){
        return songsService.updateSong(id,songModel);
    }

    @CrossOrigin
    @GetMapping("/getSongsByArtist/{name}")
    public List<SongModel> getSongsByArtist(@PathVariable String name){
        return songsService.getSongsByArtist(name);
    }

    @CrossOrigin
    @GetMapping("/getSongById/{id}")
    public Optional<SongModel> getSongById(@PathVariable int id){
        return songsService.getSongById(id);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public String deleteOneSong(@PathVariable String id){
        return songsService.deleteOneSong(id);
    }


}