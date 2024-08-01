package org.example.vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import org.example.controller.Batalla;
import org.example.modelo.Bestias.Orco;
import org.example.modelo.Bestias.Trasgo;
import org.example.modelo.Personaje;
import org.example.modelo.heroes.Elfo;
import org.example.modelo.heroes.Hobbit;
import org.example.modelo.heroes.Humano;

public class BatallaSwing {

  private JFrame frame;
  private JTextArea areaDeBatalla;
  private JButton botonIniciar;
  private JButton btonAniadirHeroe;
  private JButton btonAniadirBestia;
  private JButton botonReset;
  private JButton btonSubirHeroe;
  private JButton btonBajarHeroe;
  private JButton btonEliminarHeroe;
  private JButton btonSubirBestia;
  private JButton btonBajarBestia;
  private JButton btonEliminarBestia;
  private JTextField nombreHeroeField;
  private JTextField vidaHeroeField;
  private JTextField armaduraHeroeField;
  private JComboBox<String> tipoHeroeComboBox;
  private JTextField nombreBestiaField;
  private JTextField vidaBestiaField;
  private JTextField armaduraBestiaField;
  private JComboBox<String> tipoBestiaComboBox;
  private List<Personaje> heroes;
  private List<Personaje> bestias;
  private DefaultListModel<Personaje> listaDeHeroes;
  private DefaultListModel<Personaje> listaDeBestias;
  private JList<Personaje> listaHeroes;
  private JList<Personaje> listaBestias;

  public BatallaSwing() {

    this.frame = new JFrame("Batalla por la Tierra Media");
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setLocationRelativeTo(null);
    this.frame.setLayout(new BorderLayout());
    this.frame.setLocation(250, 50);

    this.areaDeBatalla = new JTextArea(10, 60);
    this.areaDeBatalla.setEditable(false);
    this.areaDeBatalla.setLineWrap(true);
    this.areaDeBatalla.setWrapStyleWord(true);

    this.botonIniciar = new JButton("Iniciar Batalla");
    this.botonReset = new JButton("Restaurar Contenido");
    this.btonAniadirHeroe = new JButton("Añadir Héroe");
    this.btonAniadirBestia = new JButton("Añadir Bestia");
    this.btonSubirHeroe = new JButton("Subir Héroe");
    this.btonBajarHeroe = new JButton("Bajar Héroe");
    this.btonEliminarHeroe = new JButton("Eliminar Héroe");
    this.btonSubirBestia = new JButton("Subir Bestia");
    this.btonBajarBestia = new JButton("Bajar Bestia");
    this.btonEliminarBestia = new JButton("Eliminar Bestia");

    this.nombreHeroeField = new JTextField(15);
    this.vidaHeroeField = new JTextField(5);
    this.armaduraHeroeField = new JTextField(5);
    this.tipoHeroeComboBox = new JComboBox<>(new String[] {"Elfo", "Hobbit", "Humano"});

    this.nombreBestiaField = new JTextField(15);
    this.vidaBestiaField = new JTextField(5);
    this.armaduraBestiaField = new JTextField(5);
    this.tipoBestiaComboBox = new JComboBox<>(new String[] {"Orco", "Trasgo"});

    this.heroes = new ArrayList<>();
    this.bestias = new ArrayList<>();

    // Para actualizar en la interfaz gráfica.
    this.listaDeHeroes = new DefaultListModel<>();
    this.listaDeBestias = new DefaultListModel<>();
    this.listaHeroes = new JList<>(listaDeHeroes);
    this.listaBestias = new JList<>(listaDeBestias);

    JPanel panelHeroes = new JPanel();
    panelHeroes.setLayout(new GridBagLayout());
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.insets = new Insets(5, 5, 5, 5);
    gridBagConstraints.anchor = GridBagConstraints.WEST;

    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    panelHeroes.add(new JLabel("Nombre:"), gridBagConstraints);
    gridBagConstraints.gridx = 1;
    panelHeroes.add(this.nombreHeroeField, gridBagConstraints);

    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    panelHeroes.add(new JLabel("Vida:"), gridBagConstraints);
    gridBagConstraints.gridx = 1;
    panelHeroes.add(this.vidaHeroeField, gridBagConstraints);

    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    panelHeroes.add(new JLabel("Armadura:"), gridBagConstraints);
    gridBagConstraints.gridx = 1;
    panelHeroes.add(this.armaduraHeroeField, gridBagConstraints);

    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    panelHeroes.add(new JLabel("Tipo:"), gridBagConstraints);
    gridBagConstraints.gridx = 1;
    panelHeroes.add(this.tipoHeroeComboBox, gridBagConstraints);

    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 2;
    panelHeroes.add(this.btonAniadirHeroe, gridBagConstraints);
    panelHeroes.setBorder(
        BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN), "Héroes"));

    JPanel panelBestias = new JPanel();
    panelBestias.setLayout(new GridBagLayout());

    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    panelBestias.add(new JLabel("Nombre:"), gridBagConstraints);
    gridBagConstraints.gridx = 2;
    panelBestias.add(this.nombreBestiaField, gridBagConstraints);

    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    panelBestias.add(new JLabel("Vida:"), gridBagConstraints);
    gridBagConstraints.gridx = 2;
    panelBestias.add(this.vidaBestiaField, gridBagConstraints);

    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    panelBestias.add(new JLabel("Armadura:"), gridBagConstraints);
    gridBagConstraints.gridx = 2;
    panelBestias.add(this.armaduraBestiaField, gridBagConstraints);

    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    panelBestias.add(new JLabel("Tipo:"), gridBagConstraints);
    gridBagConstraints.gridx = 2;
    panelBestias.add(this.tipoBestiaComboBox, gridBagConstraints);

    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 2;
    panelBestias.add(this.btonAniadirBestia, gridBagConstraints);
    panelBestias.setBorder(
        BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Bestias"));

    JPanel listaPanel = new JPanel();
    listaPanel.setLayout(new GridLayout(1, 2, 10, 10));
    JScrollPane heroScrollPane = new JScrollPane(this.listaHeroes);
    JScrollPane beastScrollPane = new JScrollPane(this.listaBestias);
    listaPanel.add(heroScrollPane);
    listaPanel.add(beastScrollPane);

    JPanel actionPanel = new JPanel();
    actionPanel.setLayout(new GridLayout(3, 2, 10, 10));

    actionPanel.add(btonSubirHeroe);
    actionPanel.add(btonSubirBestia);
    actionPanel.add(btonBajarHeroe);
    actionPanel.add(btonBajarBestia);
    actionPanel.add(btonEliminarHeroe);
    actionPanel.add(btonEliminarBestia);

    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new GridLayout(1, 2, 10, 10));
    inputPanel.add(panelHeroes);
    inputPanel.add(panelBestias);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.add(inputPanel, BorderLayout.NORTH);
    mainPanel.add(listaPanel, BorderLayout.CENTER);
    mainPanel.add(actionPanel, BorderLayout.SOUTH);

    JPanel battleLogPanel = new JPanel(new BorderLayout());
    battleLogPanel.add(new JLabel("Registro de la Batalla"), BorderLayout.NORTH);
    battleLogPanel.add(new JScrollPane(areaDeBatalla), BorderLayout.CENTER);

    JPanel topPanel = new JPanel();
    topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));

    topPanel.add(this.botonIniciar);
    topPanel.add(Box.createVerticalStrut(5));
    topPanel.add(this.botonReset);

    this.frame.add(topPanel, BorderLayout.NORTH);
    this.frame.add(mainPanel, BorderLayout.CENTER);
    this.frame.add(battleLogPanel, BorderLayout.SOUTH);
    this.frame.setSize(900, 700);

    this.btonAniadirHeroe.addActionListener(new AddPersonajeActionListener(true));
    this.btonAniadirBestia.addActionListener(new AddPersonajeActionListener(false));
    this.botonIniciar.addActionListener(e -> iniciarBatalla());
    this.botonReset.addActionListener(e -> resetearCampos());
    this.btonSubirHeroe.addActionListener(e -> moverPersonaje(listaHeroes, true));
    this.btonBajarHeroe.addActionListener(e -> moverPersonaje(listaHeroes, false));
    this.btonEliminarHeroe.addActionListener(e -> eliminarPersonaje(listaHeroes, true));
    this.btonSubirBestia.addActionListener(e -> moverPersonaje(listaBestias, true));
    this.btonBajarBestia.addActionListener(e -> moverPersonaje(listaBestias, false));
    this.btonEliminarBestia.addActionListener(e -> eliminarPersonaje(listaBestias, false));

    this.frame.setVisible(true);
  }

  private void iniciarBatalla() {
    if (this.heroes.isEmpty() || this.bestias.isEmpty()) {
      agregarTexto("¡No hay personajes suficientes para iniciar la batalla!");
      return;
    }
    Batalla batalla = new Batalla(this.heroes, this.bestias);
    try {
      String resultado = batalla.iniciar();
      agregarTexto(resultado);
    } catch (Exception ex) {
      agregarTexto("Error al iniciar la batalla: " + ex.getMessage());
    }
  }

  private void agregarTexto(String texto) {
    areaDeBatalla.append(texto + "\n");
  }

  private void resetearCampos() {
    this.nombreHeroeField.setText("");
    this.vidaHeroeField.setText("");
    this.armaduraHeroeField.setText("");
    this.nombreBestiaField.setText("");
    this.vidaBestiaField.setText("");
    this.armaduraBestiaField.setText("");

    this.heroes.clear();
    this.bestias.clear();
    this.listaDeHeroes.clear();
    this.listaDeBestias.clear();

    this.areaDeBatalla.setText("");
  }

  private void moverPersonaje(JList<Personaje> list, boolean subir) {
    int selectedIndex = list.getSelectedIndex();
    if (selectedIndex == -1) return;

    DefaultListModel<Personaje> model = (DefaultListModel<Personaje>) list.getModel();
    int newIndex = subir ? selectedIndex - 1 : selectedIndex + 1;

    if (newIndex < 0 || newIndex >= model.getSize()) return;

    Personaje personaje = model.remove(selectedIndex);
    model.add(newIndex, personaje);
    list.setSelectedIndex(newIndex);
  }

  private void eliminarPersonaje(JList<Personaje> list, boolean esHeroe) {
    int selectedIndex = list.getSelectedIndex();
    if (selectedIndex == -1) return;

    DefaultListModel<Personaje> model = (DefaultListModel<Personaje>) list.getModel();
    Personaje personaje = model.remove(selectedIndex);
    if (esHeroe) {
      heroes.remove(personaje);
    } else {
      bestias.remove(personaje);
    }
    this.areaDeBatalla.setText(
        this.areaDeBatalla.getText().replaceAll(".*" + personaje.toString() + ".*\n", ""));
  }

  private void restaurarContenido() {
    this.nombreHeroeField.setText("");
    this.vidaHeroeField.setText("");
    this.armaduraHeroeField.setText("");
    this.tipoHeroeComboBox.setSelectedIndex(0);

    this.nombreBestiaField.setText("");
    this.vidaBestiaField.setText("");
    this.armaduraBestiaField.setText("");
    this.tipoBestiaComboBox.setSelectedIndex(0);

    this.listaDeHeroes.clear();
    this.listaDeBestias.clear();
    this.heroes.clear();
    this.bestias.clear();
  }

  private class AddPersonajeActionListener implements ActionListener {

    private boolean isHeroe;

    public AddPersonajeActionListener(boolean isHeroe) {
      this.isHeroe = isHeroe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        String nombre;
        int vida;
        int armadura;
        JComboBox<String> tipoComboBox;
        JTextField nombreField, vidaField, armaduraField;

        if (this.isHeroe) {
          nombre = nombreHeroeField.getText().trim().toLowerCase();
          vida = Integer.parseInt(vidaHeroeField.getText());
          armadura = Integer.parseInt(armaduraHeroeField.getText());
          tipoComboBox = tipoHeroeComboBox;
          nombreField = nombreHeroeField;
          vidaField = vidaHeroeField;
          armaduraField = armaduraHeroeField;
        } else {
          nombre = nombreBestiaField.getText().trim().toLowerCase();
          vida = Integer.parseInt(vidaBestiaField.getText());
          armadura = Integer.parseInt(armaduraBestiaField.getText());
          tipoComboBox = tipoBestiaComboBox;
          nombreField = nombreBestiaField;
          vidaField = vidaBestiaField;
          armaduraField = armaduraBestiaField;
        }

        if (nombre.isEmpty() || vida <= 0 || armadura < 0) {
          agregarTexto("Todos los campos deben ser llenados correctamente.");
          return;
        }

        boolean nombreDuplicado =
            (heroes.stream()
                    .map(personaje -> personaje.getNombre().trim().toLowerCase())
                    .anyMatch(n -> n.equals(nombre))
                || bestias.stream()
                    .map(p -> p.getNombre().trim().toLowerCase())
                    .anyMatch(n -> n.equals(nombre)));

        if (nombreDuplicado) {
          agregarTexto("Ya existe un personaje con el nombre " + nombreField.getText() + ".");
          return;
        }

        Personaje personaje = null;
        if (isHeroe) {
          switch ((String) tipoComboBox.getSelectedItem()) {
            case "Elfo":
              personaje = new Elfo(nombreField.getText(), vida, armadura);
              break;
            case "Hobbit":
              personaje = new Hobbit(nombreField.getText(), vida, armadura);
              break;
            case "Humano":
              personaje = new Humano(nombreField.getText(), vida, armadura);
              break;
          }
          heroes.add(personaje);
          listaDeHeroes.addElement(personaje);
          agregarTexto("Héroe añadido: " + personaje.toString());
        } else {
          switch ((String) tipoComboBox.getSelectedItem()) {
            case "Orco":
              personaje = new Orco(nombreField.getText(), vida, armadura);
              break;
            case "Trasgo":
              personaje = new Trasgo(nombreField.getText(), vida, armadura);
              break;
          }
          bestias.add(personaje);
          listaDeBestias.addElement(personaje);
          agregarTexto("Bestia añadida: " + personaje.toString());
        }

        nombreField.setText("");
        vidaField.setText("");
        armaduraField.setText("");
      } catch (NumberFormatException ex) {
        agregarTexto("Error en los campos numéricos: " + ex.getMessage());
      }
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(BatallaSwing::new);
  }
}
