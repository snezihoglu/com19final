package iaau.webapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@Controller
@RequestMapping("/datalar")

public class DatalarController {
    @Autowired
    private DatalarRepository datalarRepository;
    @PostMapping("/add")
    public @ResponseBody String addNewprojctdata(@RequestBody Datalar user) {
        datalarRepository.save(user); // insert into users values (name, email);
        return "OK";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Datalar> getAllDatalar() {
        return datalarRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Datalar one(@PathVariable Integer id) {
        return datalarRepository.findById(id).orElseThrow(() -> new DatalarNotFoundException(id));
    }

    @PutMapping("/{id}")
    public @ResponseBody Datalar put(@RequestBody Datalar replaceDatalar, @PathVariable Integer id) {
        return datalarRepository.findById(id).map(datalar -> {
            datalar = replaceDatalar;
            datalar.setId(id);
            return datalarRepository.save(datalar);
        }).orElseThrow(() -> new DatalarNotFoundException(id));
    }
    @DeleteMapping("/{id}")
    void del(@PathVariable Integer id) {
        datalarRepository.deleteById(id);
    }

    @GetMapping("/add")
    public String datalarAdd(Datalar datalar){
        return "datalar-add";
    }
    @PostMapping("/{id}/edit")
    public String datalarEdit(@PathVariable(value = "id") int id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String faculty, Datalar datalar){
        Datalar psot = datalarRepository.findById(id).orElseThrow(IllegalStateException::new);
        datalar.setFirstname(firstname);
        datalar.setLastname(lastname);
        datalar.setEmail(email);
        datalar.setFaculty(faculty);
        datalarRepository.save(datalar);
        return "redirect:/datalar";
    }
    @PostMapping("/{id}/delete")
    public String datalarDelete(@PathVariable(value = "id") int id, Datalar datalar){
        Datalar datalar1 = datalarRepository.findById(id).orElseThrow(IllegalStateException::new);

        datalarRepository.delete(datalar);
        return "redirect:/datalar";
    }


}
