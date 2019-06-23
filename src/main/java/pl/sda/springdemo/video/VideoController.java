package pl.sda.springdemo.video;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VideoController {

    private final static Map<Long, Video> videoMap = new HashMap<>();

    static {
        videoMap.put(1L, new Video(1L, "Die Hard", "Action", new Date(), 7));
        videoMap.put(2L, new Video(2L, "Rocky", "Action", new Date(), 6));
        videoMap.put(3L, new Video(3L, "The Thing", "Horror", new Date(), 5));
    }

    VideoService videoService = new VideoService();

    @GetMapping(value = "/video/{id}")
    public String getVideo(@PathVariable Long id, Model model) {
        model.addAttribute("video", videoMap.get(id));

        return "video/details";
    }

    @GetMapping(value = "/video")
    public String getVideos(Model model) {
        model.addAttribute("videos", videoMap.values());

        return "video/list";
    }

    @GetMapping(value = "/video/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("video", videoMap.get(id));
        model.addAttribute("categories", VideoService.VALID_CATEGORIES);

        return "video/edit";
    }

    @PostMapping(value = "/video/{id}/save",
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String save(@PathVariable Long id,
                       @RequestParam String title,
                       @RequestParam String category,
                       @RequestParam int rating,
                       Model model) {
        try {
            Video currentVideo = videoMap.get(id);
            videoService.edit(currentVideo, title, category, rating);
            model.addAttribute("videos", videoMap.values());

            return "video/list";
        } catch (IllegalArgumentException ex) {
            model.addAttribute("video", videoMap.get(id));
            model.addAttribute("error", ex.getMessage());
            model.addAttribute("categories", VideoService.VALID_CATEGORIES);

            return "video/edit";
        }
    }

    @GetMapping(value = "/video/add")
    public String add() {
        return "video/edit";
    }

    @PostMapping(value = "/video",
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addVideo(
        @RequestParam String title,
        @RequestParam String category,
        @RequestParam int rating,
        Model model) {
        Long id = videoMap.entrySet().stream()
            .map(Entry::getKey)
            .max(Long::compareTo)
            .map(cId -> cId + 1)
            .orElse(1L);

        Video newVideo = new Video(id, title, category, new Date(), rating);
        videoMap.put(newVideo.getId(), newVideo);
        model.addAttribute("videos", videoMap.values());

        return "video/list";
    }

    @GetMapping(value = "/video/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        videoMap.remove(id);
        model.addAttribute("videos", videoMap.values());

        return "video/list";
    }
}
