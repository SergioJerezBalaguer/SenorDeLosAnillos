package org.example.modelo.heroes;

import org.example.modelo.Personaje;

public class Elfo extends Personaje {
  private static final int BONUS_RABIA = 10;
  private int poderOfensivoLanzado; // Variable para almacenar el resultado del dado
  private boolean dadoLanzado = false; // Flag para saber si el dado ya ha sido lanzado

  public Elfo(String nombre, int vida, int armadura) {
    super(nombre, vida, armadura);
  }

  @Override
  public int calcularPoderOfensivo() {
    if (!this.dadoLanzado) {
      int dado1 = this.random.nextInt(101);
      int dado2 = this.random.nextInt(101);
      this.poderOfensivoLanzado = Math.max(dado1, dado2);
      this.dadoLanzado = true;
    }
    return this.poderOfensivoLanzado;
  }

  public int calcularPoderOfensivoContraOrco() {

    return calcularPoderOfensivo() + this.BONUS_RABIA;
  }

  public void resetearEstado() {
    this.dadoLanzado = false;
  }

  @Override
  public String toString() {
    return "Elfo: " + super.toString();
  }
}
