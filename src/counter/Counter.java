package counter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Random;

/**
 * class Counter, which is a JFrame
 * Creates a GUI that displays a JLabel with a Red Counter
 * Contains a button that onced clicked, will change the color of the button
 * If the button is red, the Red Counter increases by 1.
 * Contains a JLabel at the bottom labeled 'Lincoln's GUI'
 */
public class Counter extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton clickButton;
    private JLabel counterLabel;
    private JLabel guiLabel;
    private int redCount = 0;
    private Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA};

    /**
     * Main Method for this GUI
     * Launches the application by calling the constructor Counter
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Counter frame = new Counter();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Constructor for this GUI
     * Sets the default properties for the GUI
     * Intantiates createCounterLabel and createGuiLabel
     * Creates a newClickButton and adds it to the contentPane
     */
    public Counter() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 200);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        createCounterLabel();
        clickButton = newClickButton();
        contentPane.add(clickButton);
        createGuiLabel(); // Added guiLabel creation
    }
    
    /**
     * createCounterLabel creates the Red Counter label
     * Contains its styling and structure
     */
    private void createCounterLabel() {
        counterLabel = new JLabel("Red Counter: 00", SwingConstants.CENTER);
        counterLabel.setBounds(0, 0, 250, 100);
        counterLabel.setBackground(Color.LIGHT_GRAY);
        counterLabel.setOpaque(true);
        counterLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
        contentPane.add(counterLabel);
    }

    /**
     * createGuiLabel creates the Lincoln's Gui label
     * Contains its styling and structure
     */
    private void createGuiLabel() {
        guiLabel = new JLabel("Lincoln's GUI", SwingConstants.CENTER);
        guiLabel.setBounds(0, 100, 500, 70); // Adjust height as needed
        guiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        guiLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Add padding
        contentPane.add(guiLabel);
    }

    /**
     * newClickButton creates a new JButton
     * Sets the styling and structure of the Button labeled Click Me
     * Contains an action listener that will fire handleButtonClick when clicked
     * @return button the Button 'Click Me'
     */
    private JButton newClickButton() {
        JButton button = new JButton("Click Me");
        button.setBounds(250, 0, 250, 100);
        button.setBackground(Color.BLUE);
        button.setBorder(null);
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setFont(new Font("Arial", Font.BOLD, 22));

        // Add action listener for button click
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick();
            }
        });

        return button;
    }
    
    /**
     * Event handler for the Click Me Button
     * Creates a new instance of random, and will go through the colors array to get a random color
     * changes the background color of clickButton to the random color
     * Checks to see if the color is red, and will increment the counter by 1 if true.
     */
    private void handleButtonClick() {
        Random random = new Random();
        Color randomColor = colors[random.nextInt(colors.length)];

        // Change the button background color
        clickButton.setBackground(randomColor);

        if (randomColor.equals(Color.RED)) {
            redCount++;
            counterLabel.setText(String.format("Red Counter: %02d", redCount));
        }
    }
}
