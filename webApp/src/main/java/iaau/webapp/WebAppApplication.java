package iaau.webapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Controller
@SpringBootApplication
public class WebAppApplication {

    @Autowired
    private DatalarRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(WebAppApplication.class, args);
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("datalar",repo.findAll());
        return "home";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }


    @GetMapping("/aboutapi")
    public String aboutapi(){
        return "aboutapi";
    }

    @GetMapping("/userprofile")
    public String userprofile(){return "userprofile";}

}