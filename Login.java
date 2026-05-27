import java.util.Scanner;

class Login {
private final String USERNAME = "admin";
private final String PASSWORD = "admin123";
Scanner sc = new Scanner(System.in);
public boolean authenticate() {
    int attempts = 3;
    while (attempts > 0) {
        System.out.println("\n===== LOGIN SYSTEM =====");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("\nLogin Successful!");
            return true;
        } else {
            attempts--;
            System.out.println("\nInvalid Username or Password!");
            System.out.println("Remaining Attempts: " + attempts);
        }
    }

    System.out.println("\nToo Many Failed Attempts!");
    return false;
}
```

}
