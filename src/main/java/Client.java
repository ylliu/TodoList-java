import java.io.IOException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        ArgumentParse argumentParse = new ArgumentParse();
        Todo todo = new Todo(argumentParse);
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(">");
            String argument = sc.nextLine();
            todo.run(argument);
        }
    }
}
