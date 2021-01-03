package net.malkkis.api.demo.api.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for simple notetaking CRUD
 */

@RestController
@RequestMapping("/note")
public class NoteController {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteController(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }
}
