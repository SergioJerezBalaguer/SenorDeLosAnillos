package org.example.vista;

import java.util.ArrayList;
import java.util.List;
import org.example.modelo.Bestias.Orco;
import org.example.modelo.Bestias.Trasgo;
import org.example.modelo.Personaje;
import org.example.modelo.heroes.Elfo;
import org.example.modelo.heroes.Hobbit;
import org.example.modelo.heroes.Humano;
import org.example.controller.Batalla;

/** Hello world! */
public class App {

  public static void main(String[] args) {
    List<Personaje> heroes = new ArrayList<>();
    heroes.add(new Elfo("Légolas", 150, 30));
    heroes.add(new Humano("Aragorn", 150, 50));
    heroes.add(new Hobbit("Frodo", 20, 10));
    heroes.add(new Humano("Gandalf", 300, 30));
    heroes.add(new Humano("Boromir", 100, 60));

    List<Personaje> bestias = new ArrayList<>();
    bestias.add(new Orco("Lurtz", 200, 60));
    bestias.add(new Orco("Shagrat", 220, 50));
    bestias.add(new Trasgo("Uglúk", 120, 30));
    bestias.add(new Trasgo("Mauhúr", 100, 30));

    Batalla batalla = new Batalla(heroes, bestias);
    batalla.iniciar();
  }
}
