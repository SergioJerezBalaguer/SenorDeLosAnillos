package org.example.modelo.Bestias;

import org.example.modelo.Personaje;

public class Orco extends Personaje {
  private static final double REDUCCION_ARMADURA = 0.1;

  public Orco(String nombre, int vida, int armadura) {
    super(nombre, vida, armadura);
  }

  @Override
  public int calcularPoderOfensivo() {
    return this.random.nextInt(91);
  }

  public int calcularArmaduraReducida() {
    return (int) (this.armadura * (1 - this.REDUCCION_ARMADURA));
  }

  @Override
  public String toString() {
    return "Orco: " + super.toString();
  }
}
