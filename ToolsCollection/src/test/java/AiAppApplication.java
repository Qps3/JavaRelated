import org.example.myapp.services.ai.OpenAiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class AiAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(OpenAiService openAiService) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            String input;
            String result;

            System.out.println("Chat with OpenAI. Type '-of' to quit.");

            do {
                System.out.print("You: ");
                input = scanner.nextLine();

                if (!"-of".equals(input)) {
                    result = openAiService.generateText(input);
                    System.out.println("AI: " + result);
                }
            } while (!"-of".equals(input));

            scanner.close();
            System.out.println("Chat ended.");
        };
    }
}
