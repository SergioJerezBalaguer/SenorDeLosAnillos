package org.example.modelo.Bestias;

import org.example.modelo.Personaje;

public class Trasgo extends Personaje {
  public Trasgo(String nombre, int vida, int armadura) {
    super(nombre, vida, armadura);
  }

  @Override
  public int calcularPoderOfensivo() {
    return this.random.nextInt(91);
  }

  @Override
  public String toString() {
    return "Trasgo: " + super.toString();
  }
}
