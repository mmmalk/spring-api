package net.malkkis.api.demo.api.joke;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@RestController
@RequestMapping("/joke")
public class JokeController {

    //let's just use small array for now, we don't need database or s3 storage for
    //anything this small
    private final ArrayList<String> jokes = new ArrayList<>(Arrays.asList(
            "Mikä on Kari Kurrin lempiruoka? Currykana!",
            "Kaksi mummoa meni mustikkaan, toinen ei mahtunut!",
            "Toivossa on hyvä elää ja uskossa kuolla, sanoi lapamato toiselle",
            "Mitä eroa on matemaatikolla ja perhepitsalla? Pitsa voi ruokkia vaimon ja lapsen!",
            "Miksi hämäläinen nauraa kirkossa sunnuntaina? Hän kuuli tiistaina vitsin!"
    ));

    Random random = new Random(System.currentTimeMillis());

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String joke(){
        return jokes.get(random.nextInt(jokes.size()));
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id) {
        try {
            return jokes.get(id);
        } catch (IndexOutOfBoundsException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This id is not valid");
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong :(");
        }
    }
}
