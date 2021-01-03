package net.malkkis.api.demo.api.note;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * POJO for Note
 */
@Data
public class Note {

    @Id
    private String id; //always use String if you're not doing arithmetics

    @NotBlank
    @Size(max=500)
    private String content;

    public Note(String content){
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("Note[id=%s, content=%s]", id, content);
    }
}
