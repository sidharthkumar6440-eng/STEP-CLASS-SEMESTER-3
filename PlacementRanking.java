import java.util.Arrays;
import java.util.Scanner;

class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public double getCompositeScore() {
        return (cgpa * 10) + (codingScore * 0.5);
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public boolean isEligibleCandidate() {
        return isEligible(cgpa) || isEligible(cgpa, codingScore);
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
        );
    }

    public String getResult() {
        return name + " (" + getCompositeScore() + ")";
    }
}

public class PlacementRanking {

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];

        int count = 0;

        for (Candidate candidate : candidates) {

            if (candidate.isEligibleCandidate()) {
                shortlisted[count] = candidate;
                count++;
            }
        }

        shortlisted = Arrays.copyOf(shortlisted, count);

        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shortlisted.length; i++) {

            result.append(i + 1)
                  .append(". ")
                  .append(shortlisted[i].getResult());

            if (i < shortlisted.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nCandidate " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();

            sc.nextLine();

            candidates[i] = new Candidate(
                    name,
                    cgpa,
                    codingScore
            );
        }

        System.out.println("\nOutput:");
        System.out.println(shortlistAndRank(candidates));

        sc.close();
    }
}