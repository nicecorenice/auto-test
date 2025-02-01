package org.example;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("org.example")
//@IncludeTags("params") //только этот тест по тегу
@ExcludeTags("params") //все тесты кроме теста с тегом params
public class TestSuit {
}
