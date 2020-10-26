import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MockType mock;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome do Mock: ");
        mock = MockType.valueOf(scan.next());
        SwitchWiremock.escolhaMock(mock);
    }
}
