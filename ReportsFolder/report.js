$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Include/features/Lazada.feature");
formatter.feature({
  "name": "Lazada",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Test Lazada",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Lazada"
    }
  ]
});
formatter.step({
  "name": "User is on Home Page of Lazada",
  "keyword": "Given "
});
formatter.match({
  "location": "Lazada.user_is_on_home_page_lazada()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User searches for \"Logitech Keyboard\"",
  "keyword": "When "
});
formatter.match({
  "location": "Lazada.user_searches_for(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User choose price range between \"100000\" to \"3000000\"",
  "keyword": "And "
});
formatter.match({
  "location": "Lazada.user_choose_price_range_between_to(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User choose to sort from lowest to highest",
  "keyword": "And "
});
formatter.match({
  "location": "Lazada.user_choose_to_sort_from_lowest_to_highest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User is able to get item name from page 1 to page 3",
  "keyword": "Then "
});
formatter.match({
  "location": "Lazada.user_is_able_to_get_item_name_from_page_to_page(Integer,Integer)"
});
formatter.result({
  "status": "passed"
});
});