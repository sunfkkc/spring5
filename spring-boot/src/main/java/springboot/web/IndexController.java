package springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.domain.posts.PostsRepository;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final PostsRepository postsRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsRepository.findAllDesc());

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }


}
