package org.example.modelo;

import java.util.Random;

public abstract class Personaje {
  protected String nombre;
  protected int vida;
  protected int armadura;
  protected Random random = new Random();

  public Personaje(String nombre, int vida, int armadura) {
    this.nombre = nombre;
    this.vida = vida;
    this.armadura = armadura;
  }

  public abstract int calcularPoderOfensivo();

  public void golpeRecibido(int danio) {
    this.vida -= danio;
  }

  public boolean estaVivo() {
    return this.vida > 0;
  }

  @Override
  public String toString() {
    return String.format("%s (Vida=%d Armadura=%d)",this. nombre, this.vida, this.armadura);
  }

  // Getters y Setters
  public String getNombre() {
    return this.nombre;
  }

  public int getVida() {
    return this.vida;
  }

  public int getArmadura() {
    return this.armadura;
  }

  public void setVida(int vida) {
    this.vida = vida;
  }
}
