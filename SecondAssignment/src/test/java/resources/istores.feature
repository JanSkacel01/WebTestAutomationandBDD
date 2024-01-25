Feature: iStores functionalities

  In order to help me with a searching for products
  As a user of the iStores website
  I want to be able to search and browse categories

  Scenario Outline: Reachability of product categories  (Check at least 5 categories)
    Given I am a user of the website
    When I visit the news website
    And I click on the "<category-name>" category
    Then I should be taken to "<category-name>" category
    And the category should show at least <num-products> products
    When I click on the first product in the results
    Then I should be taken to the details page for that product

    Examples:
      |category-name  |num-products |
      |Mac            |80           |
      |iPad           |90           |
      |iPhone         |110          |
      |Watch          |120          |
      |TV             |20           |


  Scenario: Search functionality
    Given I am a user of the website
    When I search for a product using the term "Audio"
    Then I should see the search results
    And there should be at least 5 products in the search results
    When I click on the first product in the results
    Then I should be taken to the details page for that product
