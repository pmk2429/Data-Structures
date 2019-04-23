package objectOrdering;

public class Tiger {
  private String color;
  private String stripe;
  private Integer age;

  public static void main(String[] args) {
    Tiger bengalTiger = new Tiger("yellow", "black", new Integer(10));
    Tiger indianTiger = new Tiger("yellow", "black", new Integer(15));
    Tiger africanTiger = new Tiger("white", "black", new Integer(11));
    Tiger asianTiger = new Tiger("white", "grey", new Integer(10));

    System.out.println("Equals result:");
    System.out.println("Is Bengal Tiger and Indian Tiger same? -> "
        + bengalTiger.equals(indianTiger));
    System.out.println("Is Indian Tiger and African Tiger same? -> "
        + indianTiger.equals(africanTiger));
    System.out.println("Is African Tiger and Asian Tiger same? -> "
        + africanTiger.equals(asianTiger));
    System.out.println("Is Indian Tiger and Asian Tiger same? -> "
        + indianTiger.equals(asianTiger));

    System.out
        .println("------------------------------------------------------");
    System.out.println("Hashcode result:");
    System.out.println("Bengal Tiger hashCode: " + bengalTiger.hashCode());
    System.out.println("Indian Tiger hashCode: " + indianTiger.hashCode());
    System.out
        .println("African Tiger hashCode: " + africanTiger.hashCode());
    System.out.println("Asian Tiger hashCode: " + asianTiger.hashCode());
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getStripe() {
    return stripe;
  }

  public void setStripe(String stripe) {
    this.stripe = stripe;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Tiger(String color, String stripe, int age) {
    this.color = color;
    this.stripe = stripe;
    this.age = age;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((color == null) ? 0 : color.hashCode());
    result = prime * result + ((stripe == null) ? 0 : stripe.hashCode());
    //result = prime * result + ((age == null) ? 0 : age.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;

    Tiger tiger = (Tiger) obj;
    if (color == null) {
      if (tiger.color != null)
        return false;
    } else if (!color.equals(tiger.color)) {
      return false;
    }

    if (stripe == null) {
      if (tiger.stripe != null)
        return false;
    } else if (!stripe.equals(tiger.stripe)) {
      return false;
    }

    return true;
  }

}
