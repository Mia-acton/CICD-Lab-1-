package ie.atu.week2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class RequestController {

    @GetMapping("/hello")
    public String hello()
        {
        return "Hello";
        }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name)
        {
        return "Hello " + name + "!";
        }

    @GetMapping("/details")
    public String details(@RequestParam String name, @RequestParam int age)
        {
        return "Name: " + name + ", Age: " + age;
        }
}
