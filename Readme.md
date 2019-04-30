# Table of contents
1. [Problem Statement](#problemStatement)
2. [How to run the App](#App)
3. [Junit Tests](#Junit)
4. [Architecture Summary](#Architecture)
5. [Assumptions](#Assumptions)
6. [Sample Input File](#SampleInput)


<a name="problemStatement"></a>
# Problem Statement
Write a Java 8 program that takes a basket of items and outputs its total cost.
The basket can contain one or more of the following items: Bananas, Oranges, Apples, Lemons, Peaches

<a name="App"></a>
# Running the App
1. There is a MainApp that reads from an comma separated input file and creates a basket of items
2. A sample input file is available at:
```
"src/main/resources/Basket.txt"
```
3. Use gradlew to run the App with sample input
```
navspeak$ ./gradlew run --args="src/main/resources/Basket.txt"

> Task :run
This basket contain 4
=======
  FruitItem{Fruit=PEACH, Price=Rs 100, quantity=20 PIECE}
  FruitItem{Fruit=BANANA, Price=Rs 16, quantity=10 DOZEN}
  FruitItem{Fruit=APPLE, Price=Rs 60.0, quantity=1 KILOGRAM}
  FruitItem{Fruit=BANANA, Price=Rs 100, quantity=10 KILOGRAM}
=======

Total Price => 3220.0

```

<a name="Junit"></a>
# Junit Tests
1. a minimal set of Unit and integration tests can be found at
`` 
src/test/java/com/domain
``
2. Run the tests using gradlew
```
./gradlew test

BUILD SUCCESSFUL in 2s
4 actionable tasks: 1 executed, 3 up-to-date

```
 <a name="Architecture"></a>
# Architecture Summary
1. The Domain models, valueTypes and Enums are in its own package
2. Basket is the repository of Items which is a superclass of FruitItem. 
3. The construction of Items is made available via static factory methods
4. There are utility methods to bootstrap a Basket of items reading from a csv file
5. testBasketPrice() Junit test shows how to use Item and Basket API to add items to a basket and get its total price

<a name="Assumptions"></a>
#Assumptions

1. Only Fruits listed in the problem statement is supported. To support new fruit, it must be included in Fruit Enum
2. Only currency supported is Indian Rupees
3. Currently no provision is there to apply discount. But since price calculation is at one place in the basket, 
Strategies for Discount may be included in future.

<a name="SampleInput"></a>
#Sample Input File

```$xslt
#<FruitName>,<Price In Rupees>,<quantity>,<unit>
#Rule: You can either provide:
# - Just the fruit name in which case 1 fruit with
#   default price and unit will be picked
# OR
# - You need to provide all the above field mentioned in
#   line one
# NOTE - a # at the beginning of the line represents comment
Banana,16,10,dozen
Banana,100,10,kilogram
Apple
Peach,100,20,piece
``` 