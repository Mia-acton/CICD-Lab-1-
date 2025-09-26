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

        // Choose the operation based on input
        switch (operation) {
            case "add": // Addition operation
                total = num1 + num2;
                return new CalculationOutput(operation, total, warning);

            case "subtract": // Subtraction operation
                total = num1 - num2;
                return new CalculationOutput(operation, total, warning);

            case "multiply": // Multiplication operation
                total = num1 * num2;
                return new CalculationOutput(operation, total, warning);

            case "divide": // Division operation
                if (num2 == 0) { // Prevent division by zero
                    warning = "Cannot divide by zero!";
                    return new CalculationOutput(operation, 0, warning);
                } else {
                    total = num1 / num2;
                    return new CalculationOutput(operation, total, warning);
                }

            default: // Default warning (error message if the operation is not recognised)
                warning = "Invalid operation.";
                return new CalculationOutput(operation, 0, warning);
        }
    }
}
