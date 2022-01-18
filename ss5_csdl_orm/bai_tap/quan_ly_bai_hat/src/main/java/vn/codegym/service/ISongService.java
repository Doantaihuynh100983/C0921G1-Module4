package vn.codegym.service;

import vn.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void addSong(Song song);
    void updateSong(Song song);
    Song findById(int id);
    void deleteSong(int id);
}
