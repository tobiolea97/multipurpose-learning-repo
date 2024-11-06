# Patrones estructurales

Proveen mecanismos para estructurar objetos en estructuras más grandes mientras se mantiene la flexibilidad y eficiencia del sistema.

## Adapter

Permite que objetos con clases incompatibles puedan colaborar

Ejemplo:
- interface Printable
    - print()
- class PDFDocument implements Printable
    - Overrides print()
- class WordDocument
    - print()
- class WordDocumentAdapter implements Printable
    - WordDocument document;
    - @Overrides print() {document.print()}


## Bridge
Permite tratar de forma separada una abstracción de sus implementaciones.

Ejemplo:

- interface DrawAPI
    - draw()
- class Draw2D implements DrawAPI
- class Draw3D implements DrawAPI

- abstract class Shape
    - DrawAPI

- class Circle extends Shape


## Composite
Permite trabajar con estructuras de objeto tipo arbol y tratar a cada uno de los componente de la misma forma

- interface Calculable
    - double getCost()
- class Item implements Calculable
    - double price;
    - Override getCost() { return this. price }
- class Package implements Calculable
    - List<Item> items;
    - Override getCost() { return sum of price of all items}
- class Box implements Calculable
    - List<Package> packages;
    - Override getCost() { return sum of price of all packages}



## Decorator

Permite extender la funcionalidad de un objeto de forma dinámica

- interface Beverage
    - getPrice
    - getCost
- class Espresso implements Beverage
- class BaseDecorator implements Beverage
    - Beverage 
- class MilkDecorator extends BaseDecorator
- class SugarDecorator extends BaseDecorator

## Facade


## Flyweight


## Proxy