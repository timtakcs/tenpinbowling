# tenpinbowling
Ten Pin Bowling counter

import java.util.Scanner;

public class ten_pin_bowling {
    public static void main(String[] args) {
        int ball_1;
        int ball_2;
        Scanner reader = new Scanner(System.in);

        int rounds[] = new int[10];
        int ballScore_1[] = new int[10];
        int ballScore_2[] = new int[10];


        System.out.println("Welcome to Ten-Pin Bowling");
        System.out.println("----------------------------");

        for(int i = 0; i <= 9; i ++)
        {
            ball_1 = 0;
            ball_2 = 0;
            System.out.println(" ");
            System.out.println("Round " + (i + 1));
            System.out.println("How many pins have you knocked? ");
            System.out.print("Ball 1: ");
            ball_1 = reader.nextInt();
            ballScore_1[i] = ball_1;

            if(ball_1 != 10)
            {
                System.out.print("Ball 2: ");
                ball_2 = reader.nextInt();
                ballScore_2[i] = ball_2;
            }
            rounds[i] = ballScore_1[i] + ballScore_2[i];
        }

        for(int i = 0; i <= 9; i ++)
        {
            if(i < rounds.length - 3)
            {
                if(rounds[i] == 10 && rounds[i + 1] == 10)
                {
                    rounds[i] = rounds[i] + rounds[i + 1] + ballScore_1[i + 2];
                }
                else if(rounds[i] == 10)
                {
                    rounds[i] = rounds[i] + rounds[i + 1];
                }
                else if(ballScore_1[i] + ballScore_2[i] == 10)
                {
                    rounds[i] = rounds[i] + ballScore_1[i + 1];
                }
            }
            if(i == 8 || i == 9)
            {
                if(i == 8)
                {
                    if (rounds[7] == 10 && rounds[8] == 10)
                    {
                        System.out.print("Bonus Ball 1: ");
                        int bonus_ball_1 = reader.nextInt();
                        rounds[7] = rounds[7] + rounds[8] + ballScore_1[9];
                    }
                    else if (rounds[8] == 10)
                    {
                        rounds[7] = rounds[7] + rounds[8];
                    }
                    else if (ballScore_1[7] != 10 && ballScore_1[7] + ballScore_2[7] == 10)
                    {
                        rounds[7] = rounds[7] + ballScore_1[8];
                    }
                }
                if(i == 9) {

                    if (rounds[8] == 10 && rounds[9] == 10)
                    {
                        System.out.print("Bonus Ball 1: ");
                        int bonus_ball_1 = reader.nextInt();
                        if (bonus_ball_1 != 10) {
                            System.out.print("Bonus Ball 2: ");
                            int bonus_ball_2 = reader.nextInt();
                            rounds[9] = rounds[9] + bonus_ball_1 + bonus_ball_2;
                        }
                    }
                    else if(ballScore_1[9] != 10 && ballScore_1[9] + ballScore_2[9] == 10)
                    {
                        System.out.print("Bonus Ball 1: ");
                        int bonus_ball_1 = reader.nextInt();
                        rounds[9] = rounds[9] + bonus_ball_1;
                    }
                }
            }
        }

        int sum = 0;
        for(int j = 0; j <= 9; j++)
        {
            sum += rounds[j];
            System.out.println("Total score at round " + (j + 1) + ": " + sum);
            System.out.println("Round " + (j + 1) + ": " + rounds[j]);
        }
        }
    }
