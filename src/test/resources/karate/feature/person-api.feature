Feature: Pruebas de integración para el endpoint

  Scenario Outline: Verificar la existencia de personas
    Given url baseUrl + '/people/<personId>'
    When method GET
    Then status 200
    And match response.id == <personId>
    * print response
    Examples:
      | read('classpath:data/person_id.csv') |
