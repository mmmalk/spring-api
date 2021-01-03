package net.malkkis.api.demo.api.note;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface NoteRepository extends MongoRepository<Note, String> {

    Optional<Note> findById(String id);
}
