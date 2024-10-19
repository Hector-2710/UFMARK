package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazLogin {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new BorderLayout());
        JLabel botonRetroceso = new JLabel("⟵");
        botonRetroceso.setFont(new Font("Arial", Font.PLAIN, 20));
        panelSuperior.add(botonRetroceso, BorderLayout.WEST);

        ImageIcon imagenOriginal = new ImageIcon("C:\\Users\\Diego\\Downloads\\Casino_LN_0 (1).jpg");
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon imagenAjustada = new ImageIcon(imagenRedimensionada);
        JLabel etiquetaImagen = new JLabel(imagenAjustada);
        panelSuperior.add(etiquetaImagen, BorderLayout.CENTER);

        frame.add(panelSuperior, BorderLayout.NORTH);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Inicio de sesión");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(titulo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel etiquetaCorreo = new JLabel("Email");
        JTextField campoCorreo = new JTextField("tucorreo@ufromail.cl");
        campoCorreo.setMaximumSize(new Dimension(300, 30));
        panelPrincipal.add(etiquetaCorreo);
        panelPrincipal.add(campoCorreo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));

        JLabel etiquetaContrasena = new JLabel("Contraseña");
        JPasswordField campoContrasena = new JPasswordField();
        campoContrasena.setMaximumSize(new Dimension(300, 30));
        panelPrincipal.add(etiquetaContrasena);
        panelPrincipal.add(campoContrasena);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 30)));

        JButton botonLogin = new JButton("Iniciar Sesión");
        botonLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonLogin.setBackground(new Color(33, 150, 243));
        botonLogin.setForeground(Color.WHITE);
        botonLogin.setFocusPainted(false);

        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = campoCorreo.getText();
                String password = new String(campoContrasena.getPassword());
                JOptionPane.showMessageDialog(frame, "Email: " + email + "\nContraseña: " + password);
            }
        });

        panelPrincipal.add(botonLogin);

        frame.add(panelPrincipal, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
