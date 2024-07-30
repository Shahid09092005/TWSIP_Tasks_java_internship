import javax.swing.*; // for GUI components
import java.awt.*;    // for layout managers and more GUI components
import java.awt.event.ActionEvent; // for button events
import java.awt.event.ActionListener; // for handling button clicks
import java.util.Random; // for generating random numbers

public class randdom_gui{
    private static int numToGuess;
    private static int maxGuess = 5;
    private static boolean guessConfirmed = false;
    private static JLabel guessLabel;
    private static JLabel statusLabel;
    private static JTextField guessInput;

    public static void main(String[] args) {
        // Generate the random number to guess
        Random random = new Random();
        numToGuess = random.nextInt(100) + 1;

        // Set up the JFrame (main window)
        JFrame frame = new JFrame("Random Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1));

        // Title label
        JLabel titleLabel = new JLabel("Random Number Guessing Game", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        frame.add(titleLabel);

        // Note label
        JLabel noteLabel = new JLabel("Note: You have 5 chances to guess!", SwingConstants.CENTER);
        frame.add(noteLabel);

        // Guess input field
        guessInput = new JTextField();
        frame.add(guessInput);

        // Guess button
        JButton guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessButtonListener());
        frame.add(guessButton);

        // Guess status label
        guessLabel = new JLabel("Enter your guess (1-100):", SwingConstants.CENTER);
        frame.add(guessLabel);

        // Status label
        statusLabel = new JLabel("", SwingConstants.CENTER);
        frame.add(statusLabel);

        // Make the frame visible
        frame.setVisible(true);
    }

    static class GuessButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (guessConfirmed) {
                return; // Exit if the game is already won
            }

            try {
                int userGuess = Integer.parseInt(guessInput.getText());

                if (userGuess > 0 && userGuess < 101) {
                    if (maxGuess <= 0) {
                        statusLabel.setText("Sorry! You've used all the guessing chances!");
                        guessLabel.setText("The correct number was " + numToGuess);
                        guessConfirmed = true;
                    } else {
                        if (userGuess < numToGuess) {
                            statusLabel.setText("Your guess is smaller than the correct number.");
                            guessLabel.setText("Available guesses: " + (maxGuess - 1));
                            maxGuess--;
                        } else if (userGuess > numToGuess) {
                            statusLabel.setText("Your guess is larger than the correct number.");
                            guessLabel.setText("Available guesses: " + (maxGuess - 1));
                            maxGuess--;
                        } else {
                            statusLabel.setText("Congratulations! You guessed the number correctly in " + (5 - maxGuess) + " tries.");
                            guessConfirmed = true;
                        }
                    }
                } else {
                    statusLabel.setText("Please choose a number between 1 and 100.");
                }
            } catch (NumberFormatException ex) {
                statusLabel.setText("Please enter a valid number.");
            }
        }
    }
}
