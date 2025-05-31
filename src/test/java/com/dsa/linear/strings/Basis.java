package com.dsa.linear.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class Basis {
  @Test
  void testStringLength() {
    var name = "william";
    assertEquals(7, name.length());
  }

  @Test
  void testTraverse() {
    var name = "william";

    for (int i = 0; i < name.length(); i++) {
      System.out.println(name.charAt(i));
    }

    for (var c : name.toCharArray()) {
      System.out.println(c);
    }
  }

  @Test
  void testSubstring() {
    var name = "william";

    var substring1 = name.substring(1);
    assertEquals("illiam", substring1);

    substring1 = name.substring(1, 3);

    assertEquals("il", substring1);
  }

  @Test
  void testEquals() {
    var name = "william";
    var nameCapitalized = "William";

    assertFalse(name.equals(nameCapitalized));

    assertTrue(name.equalsIgnoreCase(nameCapitalized));
  }

  @Test
  void testIndex() {
    var name = "william";

    assertEquals(1, name.indexOf("i"));
    assertEquals(4, name.lastIndexOf("i"));
  }

  @Test
  void testSuffixPrefix() {
    var name = "william";

    var sb = new StringBuilder(name).reverse();

    assertTrue(name.startsWith("wil"));

  }

  @Test
  void testCopyAndReference() {
    var name = "william";
    var name2 = name;

    assertSame(name, name2);
    name2 = "william";

    var name3 = new String(name);

    assertNotSame(name, name3);

    String s = "william";
    List<String> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      list.add(s); // añade la misma referencia → espacio O(n)
    }

    list.removeIf(s.intern()::equals); // O(n)
    assertEquals(0, list.size());
  }
}
