package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Song;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SongRepository implements ISongRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Song> findAll() {
        TypedQuery<Song> songTypedQuery = entityManager.createQuery("select s from Song s",Song.class);
        return songTypedQuery.getResultList();
    }

    @Override
    public void addSong(Song song) {
        entityManager.persist(song);
    }

    @Override
    public void updateSong(Song song) {
        entityManager.merge(song);
    }

    @Override
    public Song findById(int id) {
        TypedQuery<Song> songTypedQuery = entityManager.createQuery("select s from Song s where  s.id=:id",Song.class);
        songTypedQuery.setParameter("id",id);
        return songTypedQuery.getSingleResult();
    }

    @Override
    public void deleteSong(int id) {
       Song song = findById(id);
       if (song != null){
//           entityManager.remove(song);
           entityManager.remove(entityManager.merge(song));
       }
    }

}
