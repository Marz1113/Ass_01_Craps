import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continueGame = true;

        System.out.println("welcome to the game!");

        while (continueGame)
        {
            int dice1 = rollDie(random);
            int dice2 = rollDie(random);
            int sum = dice1 + dice2;

            System.out.println("initial roll: die 1 = " + dice1 + ", die 2 = " + dice2 + ", sum = " + sum);

            if (sum == 2 || sum == 3 || sum ==12)
            {
                System.out.println("you crapped out, you lose.");
            }
            else if (sum == 7 || sum == 11)
            {
                System.out.println("you win!");
            }
            else {
                int point = sum;
                System.out.println("points are now: " + point);

                boolean continueRolling = true;
                while (continueRolling)
                {
                    dice1 = rollDie(random);
                    dice2 = rollDie(random);
                    sum = dice1 + dice2;

                    System.out.println("trying for point: die 1 = " + dice1 + ", die 2 = " + dice2 + ", sum = " + sum);

                    if(sum == point)
                    {
                        System.out.println("points! you win!");
                        continueRolling = false;
                    } else if (sum == 7)
                    {
                        System.out.println("seven! you lose!");
                        continueRolling = false;

                    }
                }
            }

            System.out.print("do you want to play again? (Y/N): ");
            String response = scanner.next();
            if(!response.equalsIgnoreCase("Y"))
            {
                continueGame = false;
            }
        }

        System.out.println("thanks for playing!");
    }
    public static int rollDie(Random random) {
        return random.nextInt(6) + 1;
    }


}