package vasco.recordManagementApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vasco.recordManagementApp.model.Record;

import java.util.List;


public interface RecordRepository extends JpaRepository<Record, Long> {
    @Query("FROM Record WHERE user_id = ?1")
    List<Record> findAllByUId(Long user_id);

    @Query("SELECT a FROM Record a WHERE a.user_id = ?1 AND a.artist = ?2")
    List<Record> findAllByArtist(Long user_id, String artist);
}
