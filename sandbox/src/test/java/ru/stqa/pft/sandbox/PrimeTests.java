package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by lap on 5/4/17.
 */
public class PrimeTests {

  @Test
  public void testPrimes(){
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }


  @Test
  //фишка тестав том, чтобы обратить внимание на скорость выполнения первого и второго теста
  //этот тест отработал за 23 миллисекунды против 9 секунда для первого
  //так как в данном тесте оч быстро нашли делитель, что значит что число не простое
  public void testNonPrimes(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }


  @Test(enabled = false)
  //тест для числа long >> скорость выполнения для лонгов оч маленькая
  public void testPrimeLong(){
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrimeWhile(n));
  }

}
