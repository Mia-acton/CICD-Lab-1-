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

    @GetMapping("/person")
    public Person getPerson() {
        return new Person("Paul", 25);
    }

    @GetMapping ("/calculate")
    public CalculationOutput calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam String operation) {
        double total;
        String warning = null;

        switch (operation) {
            case "add":
                total = num1 + num2;
                return new CalculationOutput(operation, total, warning);

            case "subtract":
                total = num1 - num2;
                return new CalculationOutput(operation, total, warning);

            case "multiply":
                total = num1 * num2;
                return new CalculationOutput(operation, total, warning);

            case "divide":
                if (num2 == 0) {
                    warning = "Cannot divide by zero!";
                    return new CalculationOutput(operation, 0, warning);
                } else {
                    total = num1 / num2;
                    return new CalculationOutput(operation, total, warning);
                }

            default:
                warning = "Invalid operation.";
                return new CalculationOutput(operation, 0, warning);
        }
    }
}
