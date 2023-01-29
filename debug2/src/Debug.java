 enum Operator {
  ADD, SUBTRACT, MULTIPLY, DIVIDE
}

class Expression {
  double left_, right_;
  Operator op_;

  Expression(double left, double right, Operator op){
    this.left_  = left;
    this.right_ = right;
    this.op_    = op;
  }

  double evaluate() {
    switch (this.op_) {
      case ADD:
        return this.left_ + this.right_;
      case SUBTRACT:
        return this.left_ - this.right_;
      case MULTIPLY:
        return this.left_ * this.right_;
      case DIVIDE:
        return this.left_ / this.right_;
    }
    return 0.0;
  }

}

class Debug {

  public static void main(String[] args) {
    Operator[] ops = new Operator[4];
    ops[0] = Operator.ADD;
    ops[1] = Operator.SUBTRACT;
    ops[2] = Operator.MULTIPLY;
    ops[3] = Operator.DIVIDE;

    Expression[] exp = new Expression[ops.length];
    for (int i = 0; i < ops.length; ++i) {
      exp[i] = new Expression(2, 3, ops[i]);
    }

    for (int i = 0; i < ops.length; ++i) {
      System.out.println(exp[i].evaluate());
    }
  }
}

/*
Zeile 26: In die Funktion gibts keinen return Statement:
Fehlermeldung:
**************
java: missing return statement
**************
Die Funtion evaluate() muss einen double Wert zuruckgeben.
...
*/

/*
Zeile 35-38: Enums sind nicht richtig deklariert:
Fehlermeldung:
**************
java: cannot find symbol
  symbol:   variable ADD
  location: class Debug
**************
Enums müssen wie folgt deklariert werden :Operator.ADD (Enumsname.Enum).
...
*/

 /*
Zeile 33: Operator Array in main hat mehr Platz  als wurden Variablen zugewiesen:
Fehlermeldung:
**************
Exception in thread "main" java.lang.NullPointerException
	at Expression.evaluate(Debug.java:16)
	at Debug.main(Debug.java:46)
**************
In die for-loop wird das letze Index des Arrays untersucht, obwohl es null ist.
...
*/