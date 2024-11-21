package controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import model.OlaMundoBean;

@RestController
public class OlaMundoController {

    @GetMapping(path = "/ola-mundo")
    public String olaMundo() {
        return "Olá mundo!";
    }

    @GetMapping(path = "/ola-mundo-bean")
    public OlaMundoBean olaMundoBean() {
        return new OlaMundoBean("Olá mundo!");
    }

    @GetMapping(path= "/ola-mundo-bean/path-variable/{name}")
    public OlaMundoBean olaMundoBeanPathVariable(@PathVariable String name) {
        return new OlaMundoBean(String.format("Olá mundo, %s", name));
    }
}
