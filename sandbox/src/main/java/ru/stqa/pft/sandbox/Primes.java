package ru.stqa.pft.sandbox;

/**
 * проверяем простое число n или нет
 * Простое то, которое делится только на единицу или же на само себя
 * Если есть другие делители, значит число сложное
 */
public class Primes {

  public static boolean isPrime(int n) {
    for (int i = 2; n > i; i = i + 1) {
      // % в java означает, что остаток от деления равен 0
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }


  //оптимизировали тест, так как делитель не может быть больше делимого в два раза больше
  public static boolean isPrimeFast(int n) {
    for (int i = 2; i < n/2; i = i + 1) {
      // % в java означает, что остаток от деления равен 0
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }


  public static boolean isPrimeWhile(int n) {
    int i = 2;

    while (i < n) {
      if (n % i == 0) {
        return false;
      }
      i++;
    }
    return true;
  }


  public static boolean isPrimeWhile(long n) {
    long i = 2;

    while (i < n) {
      if (n % i == 0) {
        return false;
      }
      i++;
    }
    return true;
  }
}

