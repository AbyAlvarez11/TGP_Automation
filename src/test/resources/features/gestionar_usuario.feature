Feature: Gestionar pedidos PetStore

  @createPedido
  Scenario Outline: Crear pedidos
    Given detalle del pedido con id <id>, petId <petId>, y quantity <quantity>
    When creo la orden de compra
    Then el código de respuesta es 200
    And el id de la orden es <id>
    And el petId de la orden es <petId>
    And la cantidad de la orden es <quantity>
    And el estado de la orden es "placed"
    Examples:
      | id     | petId  | quantity |
      | "0001" | "0906" | "2"      |
      | "0002" | "2810" | "3"      |
      | "0003" | "0903" | "1"      |
      | "0004" | "0512" | "1"      |
      | "0005" | "1402" | "4"      |
      | "0006" | "2206" | "2"      |



  @getPedido
  Scenario Outline: Obtener una orden de compra por ID

    When envío una solicitud GET para consultar la orden con ID <id>
    Then el código de respuesta es 200
    And el id de la orden es <id>
    Examples:
      | id     |
      | "0001" |
      | "0002" |
      | "0003" |
      | "0004" |
      | "0005" |
      | "0006" |





