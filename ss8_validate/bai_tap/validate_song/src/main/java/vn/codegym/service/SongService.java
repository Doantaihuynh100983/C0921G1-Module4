package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Song;
import vn.codegym.repository.ISongRepository;

import java.util.List;
@Service
public class SongService implements ISongService{

    @Autowired
    ISongRepository iSongRepository;


    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void addSong(Song song) {
        iSongRepository.save(song);
    }
}
