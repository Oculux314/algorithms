package com.oculux.se284.datastructures.maps.hashtables;

import com.oculux.se284.datastructures.maps.Map;
import com.oculux.se284.datastructures.maps.MapTests;

public class ChainedTableTests extends MapTests {

  @Override
  protected Map createMap() {
    return new ChainedTable();
  }
  
}
