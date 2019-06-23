package pl.sda.springdemo.video;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VideoController {

    private final static Map<Long, Video> videoMap = new HashMap<>();

    static {
        videoMap.put(1L, new Video(1L, "Die Hard", "Action", new Date(), 7));
        videoMap.put(2L, new Video(2L, "Rocky", "Action", new Date(), 6));
        videoMap.put(3L, new Video(3L, "The Thing", "Horror", new Date(), 5));
    }

    @GetMapping(value = "/video/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getVideo(@PathVariable Long id, Model model) {
        model.addAttribute("video", videoMap.get(id));

        return "video/details";
    }
}
