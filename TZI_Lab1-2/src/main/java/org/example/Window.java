package org.example;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Window extends JFrame {

    private static Window window = null;
    private Window(int width, int height, String title) {
        setSize(width, height);
        setTitle(title);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        CodeCezar();
    }
public void CodeCezar(){
    Font fontNormal = new Font("Arial", Font.ITALIC, 18);

    // Button
    JButton buttonCodeCezar = createButton("Шифр Цезаря", 150, 30, 200, fontNormal);
    JButton buttonCodeVijenera = createButton("Шифр Віженера", 400, 30, 200, fontNormal);
    JButton buttonEncipher = createButton("Шифрувати", 100, 425, 250, fontNormal);
    JButton buttonDecrypting = createButton("Дешифруватти", 100, 500, 250, fontNormal);
    JButton buttonEncipherFile = createButton("Шифрувати з файлу", 400, 425, 250, fontNormal);
    JButton buttonDecryptingFile = createButton("Дешифруватти з файлу", 400, 500, 250, fontNormal);

    // TextField
    JTextField textField1 = new JTextField();
    textField1.setBounds(300, 150, 400, 100);
    textField1.setFont(fontNormal);

    JTextField textField2 = new JTextField();
    textField2.setBounds(300, 275, 400, 100);
    textField2.setFont(fontNormal);

    // Label
    JLabel label = new JLabel("Шифр Цезаря:");
    label.setBounds(280, 90, 200, 50);
    Font f = new Font("Arial", Font.BOLD, 25);
    label.setFont(f);

    JLabel label1 = new JLabel("Введіть текст:");
    label1.setBounds(80, 175, 300, 50);
    label1.setFont(fontNormal);

    JLabel label2 = new JLabel("Результат:");
    label2.setBounds(80, 300, 250, 50);
    label2.setFont(fontNormal);

    buttonEncipher.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputText = textField1.getText();
            encryptCezar(inputText, textField2);
        }
    });
    buttonDecrypting.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputText = textField1.getText();
            decryptCezar(inputText, textField2);
        }
    });

    buttonEncipherFile.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстові файли", "txt");
            fileChooser.setFileFilter(filter);
            String line = null;
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                    line = br.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            textField1.setText(String.valueOf(line));

            if (line != null) {
                encryptCezar(line, textField2);
            }
        }
    });
    buttonDecryptingFile.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстові файли", "txt");
            fileChooser.setFileFilter(filter);
            String line = null;
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                    line = br.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            textField1.setText(String.valueOf(line));

            if (line != null) {
                decryptCezar(line, textField2);
            }
        }
    });

    buttonCodeVijenera.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            switchToVijenera();
        }
    });

    add(label);
    add(label1);
    add(label2);
    add(textField1);
    add(textField2);
    add(buttonCodeCezar);
    add(buttonCodeVijenera);
    add(buttonEncipher);
    add(buttonDecrypting);
    add(buttonEncipherFile);
    add(buttonDecryptingFile);

    setVisible(true);
}

    public void CodeVijenera() {
        Font fontNormal = new Font("Arial", Font.ITALIC, 18);

        // Button
        JButton buttonCodeCezar = createButton("Шифр Цезаря", 150, 30, 200, fontNormal);
        JButton buttonCodeVijenera = createButton("Шифр Віженера", 400, 30, 200, fontNormal);
        JButton buttonEncipher = createButton("Шифрувати", 100, 425, 250, fontNormal);
        JButton buttonDecrypting = createButton("Дешифруватти", 100, 500, 250, fontNormal);
        JButton buttonEncipherFile = createButton("Шифрувати з файлу", 400, 425, 250, fontNormal);
        JButton buttonDecryptingFile = createButton("Дешифруватти з файлу", 400, 500, 250, fontNormal);


        // TextField
        JTextField textField1 = new JTextField();
        textField1.setBounds(300, 150, 400, 100);
        textField1.setFont(fontNormal);

        JTextField textField2 = new JTextField();
        textField2.setBounds(300, 275, 400, 100);
        textField2.setFont(fontNormal);

        // Label
        JLabel label = new JLabel("Шифр Віженера:");
        label.setBounds(280, 90, 250, 50);
        Font f = new Font("Arial", Font.BOLD, 25);
        label.setFont(f);

        JLabel label1 = new JLabel("Введіть текст:");
        label1.setBounds(80, 175, 300, 50);
        label1.setFont(fontNormal);

        JLabel label2 = new JLabel("Результат:");
        label2.setBounds(80, 300, 250, 50);
        label2.setFont(fontNormal);

        buttonEncipher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textField1.getText();
                encryptVijenera(inputText, textField2);
            }
        });
        buttonDecrypting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textField1.getText();
                decryptVijenera(inputText, textField2);
            }
        });

        buttonEncipherFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстові файли", "txt");
                fileChooser.setFileFilter(filter);
                String line = null;
                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                        line = br.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                textField1.setText(String.valueOf(line));

                if (line != null) {
                    encryptVijenera(line, textField2);
                }
            }
        });
        buttonDecryptingFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстові файли", "txt");
                fileChooser.setFileFilter(filter);
                String line = null;
                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                        line = br.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                textField1.setText(String.valueOf(line));

                if (line != null) {
                    decryptVijenera(line, textField2);
                }
            }
        });

        buttonCodeCezar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToCezar();
            }
        });

        add(label);
        add(label1);
        add(label2);
        add(textField1);
        add(textField2);
        add(buttonCodeCezar);
        add(buttonCodeVijenera);
        add(buttonEncipher);
        add(buttonDecrypting);
        add(buttonEncipherFile);
        add(buttonDecryptingFile);

        setVisible(true);
    }

    private @NotNull JButton createButton(String text, int x, int y, int width, Font font) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, 50);
        button.setFont(font);
        return button;
    }
    private void encryptCezar(@NotNull String inputText, JTextField resultField) {
        String alphabet = " abcdefghijklmnopqrstuvwxyz";
        char[] letters = alphabet.toCharArray();
        StringBuilder encipherText = new StringBuilder();
        int shift = 10;

        for (char c : inputText.toCharArray()) {
            int pos = 0;
            if (Character.isLetter(c)) {
                boolean caseLow = Character.isLowerCase(c);
                c = Character.toLowerCase(c);
                for (int i = 1; i < 27; i++) {
                    if (c == letters[i]) {
                        pos = i;
                        break;
                    }
                }
                c = letters[(pos + shift) % 27];
                if (!caseLow) c = Character.toUpperCase(c);
            } else if (c == ' ') {
                c = letters[(pos + shift) % 27];
            }
            encipherText.append(c);
        }
        resultField.setText(encipherText.toString());
    }
    private void decryptCezar(@NotNull String inputText, JTextField resultField) {
        String alphabet = " abcdefghijklmnopqrstuvwxyz";
        char[] letters = alphabet.toCharArray();
        StringBuilder encipherText = new StringBuilder();
        int shift = 10;

        for (char c : inputText.toCharArray()) {
            int pos = 0;
            if (Character.isLetter(c)) {
                boolean caseLow = Character.isLowerCase(c);
                c = Character.toLowerCase(c);
                for (int i = 1; i < 27; i++) {
                    if (c == letters[i]) {
                        pos = i;
                        break;
                    }
                }

                if (pos < shift) {
                    c = letters[Math.abs((pos + 27 - shift) % 27)];
                } else c = letters[Math.abs((pos - shift) % 27)];
                if (!caseLow) c = Character.toUpperCase(c);
            } else if (c == ' ') {
                c = letters[Math.abs((pos - shift) % 27)];
            }
            encipherText.append(c);
        }
        resultField.setText(encipherText.toString());
    }
    private void encryptVijenera(@NotNull String inputText, JTextField resultField) {
        String alphabet = " абвгґдеєжзийіїклмнопрстуфхцчшщьюя";
        char[] letters = alphabet.toCharArray();
        StringBuilder encipherText = new StringBuilder();

        int[] codeVijenera = new int[] {23, 1, 30, 1};
        int codeVCount = 0;
        for (char c : inputText.toCharArray()) {
            int pos = 0;
            if (Character.isLetter(c)) {
                boolean caseLow = Character.isLowerCase(c);
                c = Character.toLowerCase(c);
                for (int i = 1; i < letters.length; i++) {
                    if (c == letters[i]) {
                        pos = i;
                        break;
                    }
                }
                c = letters[(pos + codeVijenera[codeVCount]) % letters.length];
                if (!caseLow) c = Character.toUpperCase(c);
            } else if (c == ' ') {
                c = letters[(pos + codeVijenera[codeVCount]) % letters.length];
            }
            codeVCount++;
            if(codeVCount == codeVijenera.length-1) codeVCount = 0;
            encipherText.append(c);
        }
        resultField.setText(encipherText.toString());
    }
    private void decryptVijenera(@NotNull String inputText, JTextField resultField) {
        String alphabet = " абвгґдеєжзийіїклмнопрстуфхцчшщьюя";
        char[] letters = alphabet.toCharArray();
        StringBuilder encipherText = new StringBuilder();

        int[] codeVijenera = new int[] {23, 1, 30, 1};
        int codeVCount = 0;

        for (char c : inputText.toCharArray()) {
            int pos = 0;
            if (Character.isLetter(c)) {
                boolean caseLow = Character.isLowerCase(c);
                c = Character.toLowerCase(c);
                for (int i = 1; i < letters.length; i++) {
                    if (c == letters[i]) {
                        pos = i;
                        break;
                    }
                }

                if (pos < codeVijenera[codeVCount]) {
                    c = letters[Math.abs((pos + letters.length - codeVijenera[codeVCount]) % letters.length)];
                } else c = letters[Math.abs((pos - codeVijenera[codeVCount]) % letters.length)];

                if(!caseLow) c = Character.toUpperCase(c);

            } else if (c == ' ') {
                c = letters[Math.abs((pos + letters.length - codeVijenera[codeVCount]) % letters.length)];
            }
            codeVCount++;
            if(codeVCount == codeVijenera.length-1) codeVCount = 0;
            encipherText.append(c);
        }
        resultField.setText(encipherText.toString());
    }
    private void switchToVijenera() {
        getContentPane().removeAll();
        revalidate();
        repaint();
        CodeVijenera();
    }
    private void switchToCezar() {
        getContentPane().removeAll();
        revalidate();
        repaint();
        CodeCezar();
    }
public static Window createWindow() {
    if (Window.window == null) {
        Window.window = new Window(800, 700, "Code");
    }
    return Window.window;
}

}

