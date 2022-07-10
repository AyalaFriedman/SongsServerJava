package songs.app.components.songs;

import java.util.List;

public interface SongsInterface {
   public List<SongModel> getAllSongs();
   public SongModel addSong(SongModel songModel);
   public List<SongModel> getSongsByArtist( String name);
}
