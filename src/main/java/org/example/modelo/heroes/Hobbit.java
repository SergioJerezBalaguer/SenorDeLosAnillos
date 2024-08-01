package org.example.modelo.heroes;

import org.example.modelo.Personaje;

public class Hobbit extends Personaje {
  private static final int PENALIZACION_TRASGO = 5;

  public Hobbit(String nombre, int vida, int armadura) {
    super(nombre, vida, armadura);
  }

  @Override
  public int calcularPoderOfensivo() {
    int dado1 = this.random.nextInt(2);
    int dado2 = this.random.nextInt(1);

    return Math.max(dado1, dado2);
  }

  public int calcularPoderOfensivoContraTrasgo() {
    return Math.max(0, calcularPoderOfensivo() - PENALIZACION_TRASGO);
    // Ponemos el primer valor a cero para que no den números negativos.
    // Si por ejemplo el dado mayor es 3, al restarle 5 daría negativo.
  }
  @Override
  public String toString() {
    return "Hobbit: " + super.toString();
  }
}
