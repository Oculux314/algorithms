package com.oculux.se284.datastructures.maps.hashtables;

import com.oculux.se284.datastructures.maps.Map;
import com.oculux.se284.datastructures.maps.MapTests;

public class ProbeTableTests extends MapTests {

  @Override
  protected Map createMap() {
    return new ProbeTable();
  }
  
}
