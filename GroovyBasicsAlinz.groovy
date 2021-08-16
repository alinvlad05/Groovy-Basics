import java.lang.* // this is the only default import in Java
import java.util.*
import java.io.*
import java.net.*
import groovy.lang.*
import groovy.util.*
import java.math.BigInteger
import java.math.BigDecimal
//Groovy Imports


class Order {
    int orderNo
    Customer orderedByCustomer
    String description

    static main(args) {
        Order order1 = new Order();
        order1.orderNo = 1;
        order1.orderedByCustomer = new Customer(name: "Customer1", email: "cust1@example.com")
        order1.setDescription("Ordered by Customer1")
        println order1.orderByCustomer.showMail()
    }
}

class Customer {
    String name
    String email
    String address

    String showMail() {
        email
    }
}

//Another Example
def condition1 = true
int condition2 = 0
if (condition1) {
    println("Condition 1 satisfied")
    if (condition2) {
        println("Condition 2 satisfied")
    } else {
        println("Condition 2 failed")
    }
} else {
    println("Condition 1 failed")
}

//Another Example
def condition3 = true
int condition4 = 0
(condition4 > 0) ? println("Positive") : println("Negative")

//Another Example
def checkInput(def input) {
    switch (input) {
        case [3, 4, 5]: println("Array Matched"); break;
        case 10..15: println("Range Matched"); break;
        case Integer: println("Integer Matched"); break;
        case ~/\w+/: println("Pattern Matched"); break;
        case String: println("String Matched"); break;
        default: println("Nothing Matched"); break;
    }
}

checkInput(3)  // Array Matched
checkInput(1)  // Integer Matched
checkInput(10)  // Range Matched
checkInput("abcd abcd") // String Matched
checkInput("abcd")  // Pattern Matched

// Traditional for loop
for(int i = 0; i< 3; i++) {/* do something */ }
// Loop over a Range
for(i in 1..5) println(i)
// Array iteration
def arr = ["Apple", "Banana", "Mango"]
for(i in arr) println(i)
// for applied on Set
for(i in ([10,10,11,11,12,12] as Set)) println(i)

// Creating a Set
def Set1 = [1, 2, 1, 4, 5, 9] as Set //[1, 2, 4, 5, 9]
Set Set2 = new HashSet(['a', 'b', 'c', 'd']) //[a, b, c, d]

// Modifying a Set
Set2.add(1) //[a, 1, b, c, d]
Set2.add(9) //[a, 1, b, c, d, 9]
Set2.addAll([4, 5]) //[a, 1, b, c, d, 4, 5, 9]
Set2.remove(1) //[a, b, c, d, 4, 5, 9]
Set2.removeAll([4, 5]) //[a, b, c, d, 9]


// Union of Set
Set Union = Set1 + Set2//[1, 2, 4, 5, 9, a, b, c, d]

// Intersection of Set
Set intersection = Set1.intersect(Set2)//[9]

// Complement of Set
Set Complement = Union.minus(Set1)//[a, b, c, d]

// Creating a List
def list1 = ['a', 'b', 'c', 'd'] //[a, b, c, d]
def list2 = [3, 2, 1, 4, 5] as List //[3, 2, 1, 4, 5]
// Reading a List
println list1[1] //b
println list2.get(4) //5
println list1.get(5) //Throws IndexOutOfBoundsException

// Some utility method on List
//Sort a List
println list2.sort() // [1, 2, 3, 4, 5]
// Reserve a list
println list1.reverse() // [d, c, b, a]
// Finding elements
println ("Max:" + list2.max() + ":Last:" + list1.last()) //Max:5:Last:d

// Creating a List
def list3 = ['a', 'b', 'c', 'd'] //[a, b, c, d]
def list4 = [3, 2, 1, 4, 5] as List //[3, 2, 1, 4, 5]
println list3.find({ it % 2 == 0 })    // 2
println list4.findAll({ it % 2 == 0 })  // [2, 4]

Map ageMap = [John: 24, Meera: 28, Kat: 31, Lee: 19, Harry: 18]

ageMap.each { key, value ->
    println "Name is " + key
    println "Age is " + value
}

Map ageMap2 = [John: 24, Meera: 28, Kat: 31, Lee: 19, Harry: 18]

ageMap2.each { entry ->
    println "Name is " + entry.key
    println "Age is " + entry.value
}

def range1 = 1..10 //1..10
println range1.any { it > 5 } //true
println range1.every { it > 0 } //true

/*   CLOSURE
//EXAMPLE 1 ______________________________________________
class PrintValue {
    def printClosure = {
        println myValue
    }
}

class PrintHandler{
    def myValue = "I'm Defined Here"
}

def pcl = new PrintValue().printClosure
pcl.delegate = new PrintHandler()
pcl() //I'm Defined Here

//EXAMPLE 2 _______________________________________________
class PrintValue{
    def myValue = "I'm owner"
    def printClosure = {
        println myValue
    }
}

class PrintHandler{
    def myValue = "I'm Defined Here"
}

def pcl = new PrintValue().printClosure
pcl.delegate = new PrintHandler()
pcl() //I'm owner

//EXAMPLE 3 _______________________________________________
class PrintValue{
    def myValue = "I'm owner"
    def printClosure = {
        println myValue
    }
}

class PrintHandler{
    def myValue = "I'm Defined Here"
}

def pcl = new PrintValue().printClosure
pcl.resolveStrategy = Closure.DELEGATE_FIRST
pcl.delegate = new PrintHandler()
pcl() //I'm Defined Here

Alin Cluj Life on Youtube :)
*/