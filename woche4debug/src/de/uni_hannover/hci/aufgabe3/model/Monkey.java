package de.uni_hannover.hci.aufgabe3.model;

// A monkey always has 2 arms and 2 legs
public class Monkey extends de.uni_hannover.hci.aufgabe3.Animal {

  public Monkey(String name) {
    super(name);
  }


  @Override
  public String getName() {
    return super.name_;
  }

  @Override
  public int getArms() {
    return 2;
  }

  @Override
  public int getLegs() {
    return 2;
  }

  @Override
  public String toString() {
    return String.format("%s is a monkey with %d legs and %d arms.", this.getName(), this.getLegs(), this.getArms());
  }
}