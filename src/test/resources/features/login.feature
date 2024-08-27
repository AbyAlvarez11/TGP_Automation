#language: es
@testfeature
Característica: Product - Store

  @test
  Esquema del escenario: Validación del precio de un producto
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario <user> y clave <password>
    Cuando navego a la categoria <category> y subcategoria <subCategory>
    Y agrego <quantity> unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina carrito
    Y vuelvo a validar el calculo de precios en el carrito
    Ejemplos:
      | user                          | password           | category  | subCategory | quantity |
      | "aracellyyujcre.18@gmail.com" | "n8VFx3jXXz7AVMr$" | "CLOTHES" | "Men"       | 2        |
      | "aracellyyujcre.10@gmail.com" | "n8VFx2jXXz7AVMr$" | "CLOTHES" | "Men"       | 2        |
      | "aracellyyujcre.18@gmail.com" | "n8VFx3jXXz7AVMr$" | "Autos"   | "Men"       | 2        |

  @test1
  Escenario: Validación del precio de un producto

    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "aracellyyujcre.18@gmail.com" y clave "n8VFx3jXXz7AVMr$"
    Cuando navego a la categoria "CLOTHES" y subcategoria "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina carrito
    Y vuelvo a validar el calculo de precios en el carrito


  @test2
  Escenario: Validación del precio de un producto con usuarios errados

    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "aracellyyujcre.10@gmail.com" y clave "n8VFx2jXXz7AVMr$"
    Cuando navego a la categoria "CLOTHES" y subcategoria "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina carrito
    Y vuelvo a validar el calculo de precios en el carrito


  @test3
  Escenario: Validación del precio de un producto con categoria "Autos"

    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "aracellyyujcre.18@gmail.com" y clave "n8VFx3jXXz7AVMr$"
    Cuando navego a la categoria "Autos" y subcategoria "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina carrito
    Y vuelvo a validar el calculo de precios en el carrito