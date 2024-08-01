package org.example.modelo.heroes;

import org.example.modelo.Personaje;

public class Humano extends Personaje {
  public Humano(String nombre, int vida, int armadura) {
    super(nombre, vida, armadura);
  }

  @Override
  public int calcularPoderOfensivo() {
    int dado1 = this.random.nextInt(101);
    int dado2 = this.random.nextInt(101);

    return Math.max(dado1, dado2);
  }
  @Override
  public String toString() {
    return "Humano: " + super.toString();
  }
}
