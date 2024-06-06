import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.Test;

public class ComputationTest {

  Computation computation = new Computation();

  @Test
  // A test that does what it should
  public void add() {
    int addResult = computation.add(1, 1);
    assertEquals(2, addResult);
    
    // Test the Integer.MIN_VALUE branch
    addResult = computation.add(Integer.MIN_VALUE, 1);
    assertEquals(Integer.MIN_VALUE + 1, addResult);
  }

  @Test
  // a test that does what it should
  public void substract() {
    int subtractResult = computation.substract(5, 3);
    assertEquals(2, subtractResult);
  }

  @Test
  public void catchesException() {
    computation.catchesException();
  }

  @Test
  // a test that partially does what it should
  public void divide() {
    double divideResult = computation.divide(1, 2);
    assertEquals(0.5d, divideResult, 0.0d);

    // Test division by zero
    divideResult = computation.divide(1, 0);
    assertEquals(Double.POSITIVE_INFINITY, divideResult, 0.0d);
  }

  @Test
  public void multiply() {
    assertEquals(10, computation.multiply(5, 2));
    assertEquals(0, computation.multiply(100, 0));
  }

  @Test
  public void justALoop() {
    assertEquals(2, computation.justALoop());
  }
}

