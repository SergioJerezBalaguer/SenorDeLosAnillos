package org.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.example.modelo.Bestias.Orco;
import org.example.modelo.Bestias.Trasgo;
import org.example.modelo.heroes.Elfo;
import org.example.modelo.heroes.Hobbit;
import org.example.modelo.Personaje;

public class Batalla {

  private final List<Personaje> heroes;
  private final List<Personaje> bestias;
  private int turno = 1;

  public Batalla(List<Personaje> heroes, List<Personaje> bestias) {
    this.heroes = new ArrayList<>(heroes);
    this.bestias = new ArrayList<>(bestias);
  }

  public String iniciar() {
    StringBuilder resultado = new StringBuilder();

    while (!this.heroes.isEmpty() && !this.bestias.isEmpty()) {
      if (resultado.length() > 100000) { // Ejemplo de límite para evitar acumulación excesiva
        resultado.append("El resultado es demasiado extenso para mostrar.");
        break;
      }

      resultado.append("\nTurno ").append(turno).append(":\n");
      List<Personaje> heroesPorTurno = new ArrayList<>(this.heroes);
      List<Personaje> bestiasPorTurno = new ArrayList<>(this.bestias);

      for (int i = 0; i < Math.min(heroesPorTurno.size(), bestiasPorTurno.size()); i++) {
        Personaje heroe = heroesPorTurno.get(i);
        Personaje bestia = bestiasPorTurno.get(i);

        int poderOfensivoHeroe = calcularPoderOfensivoHeroe(heroe, bestia);
        int poderOfensivoBestia = bestia.calcularPoderOfensivo();
        int armaduraDefensorBestia = calcularArmaduraDefensorBestia(bestia);
        int armaduraDefensorHeroe = heroe.getArmadura();


        if (poderOfensivoHeroe > armaduraDefensorBestia) {
          int danio = poderOfensivoHeroe - armaduraDefensorBestia;
          bestia.golpeRecibido(danio);
          resultado.append(
              String.format(
                  "%s saca %d y le quita %d de vida a %s%n",
                  heroe.getNombre(), poderOfensivoHeroe, danio, bestia.getNombre()));
        } else {
          resultado.append(
              String.format(
                  "%s saca %d pero no hace daño a %s%n",
                  heroe.getNombre(), poderOfensivoHeroe, bestia.getNombre()));
        }

        if (poderOfensivoBestia > armaduraDefensorHeroe) {
          int danio = poderOfensivoBestia - armaduraDefensorHeroe;
          heroe.golpeRecibido(danio);
          resultado.append(
              String.format(
                  "%s saca %d y le quita %d de vida a %s%n",
                  bestia.getNombre(), poderOfensivoBestia, danio, heroe.getNombre()));
        } else {
          resultado.append(
              String.format(
                  "%s saca %d pero no hace daño a %s%n",
                  bestia.getNombre(), poderOfensivoBestia, heroe.getNombre()));
        }


        if (!bestia.estaVivo()) {
          this.bestias.remove(bestia);
          resultado.append(String.format("¡Muere %s!%n", bestia.getNombre()));
        }

        if (!heroe.estaVivo()) {
          this.heroes.remove(heroe);
          resultado.append(String.format("¡Muere %s!%n", heroe.getNombre()));
        }


        if (heroe instanceof Elfo) {
          ((Elfo) heroe).resetearEstado();
        }
      }

      resultado.append("Estado actual:\n");
      resultado.append("Héroes:\n");
      for (Personaje p : this.heroes) {
        resultado.append(p.getNombre()).append(": Vida=").append(p.getVida()).append("\n");
      }
      resultado.append("Bestias:\n");
      for (Personaje p : this.bestias) {
        resultado.append(p.getNombre()).append(": Vida=").append(p.getVida()).append("\n");
      }
      resultado.append("\n");

      turno++;
    }

    if (this.heroes.isEmpty()) {
      resultado.append("¡Victoria de las Bestias!");
    } else if (this.bestias.isEmpty()) {
      resultado.append("¡Victoria de los Héroes!");
    }
    System.out.println(resultado);
    return resultado.toString();
  }

  private int calcularPoderOfensivoHeroe(Personaje heroe, Personaje bestia) {
    if (heroe instanceof Elfo) {
      if (bestia instanceof Orco) {
        return ((Elfo) heroe).calcularPoderOfensivoContraOrco();
      }
      return heroe.calcularPoderOfensivo();
    } else if (heroe instanceof Hobbit && bestia instanceof Trasgo) {
      return ((Hobbit) heroe).calcularPoderOfensivoContraTrasgo();
    }
    return heroe.calcularPoderOfensivo();
  }

  private int calcularArmaduraDefensorBestia(Personaje bestia) {
    if (bestia instanceof Orco) {
      return ((Orco) bestia).calcularArmaduraReducida();
    }
    return bestia.getArmadura();
  }
}
