package pl.skiba.videoapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.skiba.videoapp.dao.entity.VideoCassette;
import pl.skiba.videoapp.manager.VideoCassetteManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassettes")
public class videoCassetteApi {

    private VideoCassetteManager videoCassettes;

    @Autowired
    public videoCassetteApi(VideoCassetteManager videoCassettes) {
        this.videoCassettes = videoCassettes;
    }

//    private List<VideoCassette> videoCassettes; To the List

//    public videoCassetteApi() {
//        Example with List
//        videoCassettes = new ArrayList<>();
//        videoCassettes.add(new VideoCassette(1L,"Titanic", LocalDate.of(1995,5,5)));
//        videoCassettes.add(new VideoCassette(2L,"PulpFiction", LocalDate.of(1995,5,5)));
//    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return videoCassettes.findAll(); //w przypadku list potrzebny byłaby Lista bez metody FindAll()
    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam Long index) {
//        Zostawiam bo wyrażenie lambda
//        Optional<VideoCassette> first = videoCassettes.stream().
//                filter(element -> element.getId() == index).findFirst();
//        return first.get();

        return videoCassettes.findById(index);


    }

    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette) {
//        return videoCassettes.add(videoCassette);
          return videoCassettes.save(videoCassette);
    }

    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette) {
//        return videoCassettes.add(videoCassette);
        return videoCassettes.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index) {
//        return videoCassettes.removeIf(element -> element.getId() == index);
          videoCassettes.deleteById(index);
    }


}