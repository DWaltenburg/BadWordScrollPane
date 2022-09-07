package BadWordScrollPane.src.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowGUI extends JFrame implements WindowListener, ActionListener {

    protected JTextField textField;
    public JTextArea textArea;
    public JScrollPane Pane;

    public WindowGUI(String title) {
        super(title);
        this.setLayout(new GridBagLayout());
        this.addWindowListener(this);

        textField = new JTextField(20);
        textField.addActionListener(this);

        textArea = new JTextArea(10,20);
        Pane = new JScrollPane(textArea);


        GridBagConstraints GConstraints = new GridBagConstraints();
        GConstraints.gridwidth = GridBagConstraints.REMAINDER;

        GConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(textField, GConstraints);

        GConstraints.fill = GridBagConstraints.BOTH;
        GConstraints.weightx = 1.0;
        GConstraints.weighty = 1.0;
        add(Pane, GConstraints);

    }

    public void checkWords(String word) throws BadWordExeption {
        if (word.equalsIgnoreCase("banan")){
            throw new BadWordExeption("Oh nej, du sagde banan.");
        }
    }

    public static void main(String[] args) {
        WindowGUI window = new WindowGUI("Chat vindue");
        window.setSize(500, 350);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String word = textField.getText();

        try {
            checkWords(word);
        } catch (BadWordExeption be) {
            System.out.println("Var din mund!");
            be.printStackTrace();
        }
        textArea.append(word + "\n");
        textField.selectAll();
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
