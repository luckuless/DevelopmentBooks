## About this Kata

This short and simple Kata should be performed using **Test Driven Development** (TDD).

There is a series of books about software development that have been read by a lot of developers who want to improve their development skills. Let’s say an editor, in a gesture of immense generosity to mankind (and to increase sales as well), is willing to set up a pricing model where you can get discounts when you buy these books. The available books are :
1. Clean Code (Robert Martin, 2008)
2. The Clean Coder (Robert Martin, 2011)
3. Clean Architecture (Robert Martin, 2017)
4. Test Driven Development by Example (Kent Beck, 2003)
5. Working Effectively With Legacy Code (Michael C. Feathers, 2004)

## Rules

The rules are described below :

One copy of the five books costs 50 EUR.
- If, however, you buy two different books from the series, you get a 5% discount on those two books.
- If you buy 3 different books, you get a 10% discount.
- With 4 different books, you get a 20% discount.
- If you go for the whole hog, and buy all 5, you get a huge 25% discount.
- Note that if you buy, say, 4 books, of which 3 are different titles, you get a 10% discount on the 3 that form part of a set, but the 4th book still costs 50 EUR.

Developers seeking to deliver quality products are queueing up with shopping baskets overflowing with these books. Your mission is to write a piece of code to calculate the price of any conceivable shopping basket.

For example, how much does this basket of books cost?
- 2 copies of the “Clean Code” book
- 2 copies of the “Clean Coder” book
- 2 copies of the “Clean Architecture” book
- 1 copy of the “Test Driven Development by Example” book
- 1 copy of the “Working effectively with Legacy Code” book

Answer :

(4 * 50 EUR) - 20% [first book, second book, third book, fourth book]

(4 * 50 EUR) - 20% [first book, second book, third book, fifth book]

= 160 EUR + 160 EUR

= 320 EUR (knowledge is priceless but has a cost)
  

### Prerequisites

- Java 17

### How to build ?

Execute this maven command to build :

`mvn clean install`

### How to Run ? 

Execute this maven command to run :

`mvn spring-boot:run`

### Documentations
After running the project, you can see the `api documentation` on this URL:
`http://localhost:8080/swagger-ui/index.html`

The bookMap is map of ISBN and the corresponding number of copies taken by the developer.
The following ISBNs are available in the in memory database:
| ISBN | Book |
|:-----|:-----------------------------------------------------------------:|
| isbn1 | Clean Code (Robert Martin, 2008) |
| isbn2 | The Clean Coder (Robert Martin, 2011) |
| isbn3 | Clean Architecture (Robert Martin, 2017) |
| isbn4 | Test Driven Development by Example (Kent Beck, 2003) |
| isbn5 | Working Effectively With Legacy Code (Michael C. Feathers, 2004) |

On success, the REST API will return the below prices:
- totalPrice: price without discount in EUR
- discountAllowed: the amount of discount applied in EUR
- discountedPrice: the final price after the discount is applied in EUR

### TODO
Refactor code to allow the system to differentiate between different discount codes and apply them correctly
