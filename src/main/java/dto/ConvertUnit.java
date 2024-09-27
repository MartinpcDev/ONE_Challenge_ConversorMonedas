package dto;

public enum ConvertUnit {
  EUR("Euro"),
  ARS("Peso Argentino"),
  USD("Dolar Estadounidense"),
  COP("Peso Colombiano"),
  PEN("Sol Peruano"),
  BRL("Real Brasileño");

  private final String name;

  ConvertUnit(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
