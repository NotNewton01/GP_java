public enum Farbe {
  ROT(0xff0000), GELB(0x00ff00), BLAU(0x0000ff);
  private int code;
  public Farbe(int c) {
    this.code = c;
  }
  public static void main(String[] args) {
    System.out.println(Farbe.GELB.code);
  }
}
