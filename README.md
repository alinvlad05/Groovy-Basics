# Groovy Basics
 Every Groovy type is a subtype of java.lang.Object.
 As compared to Java, there are no primitive types present in Groovy. 
 Groovy treats everything as an object, which makes Groovy a pure Object Oriented language.
the power of Groovy lies in dynamic typing. In many scenarios, you are not sure about the kind of value that 
would be stored in the variable or returned by the functions. In that scenario, Groovy provides flexibility to use dynamic typing. 
You can just define a variable or methods by using the def keyword.
Another use of dynamic typing is calling methods on objects that have no guaranteed type. 
This is often called duck typing. For example, consider the following scenario where a simple addition method is called on different data types 
such as Integer, List, and String. 
Based on different input parameters, each time the method returns different output.
Groovy imports six packages and two classes by default.
Classes and methods in Groovy by default have public access, whereas in Java it is set to package-private.
We have created fields in the class with no access modifier. If fields are created with default access, 
then Groovy automatically creates a field with public getter and setter methods. 
If we specify any access modifier (public, private, or protected), then only fields will be created; 
no getter or setter method will be created. 
So, each class in Groovy has properties and autocreated getter and setter methods for those properties. 
This is similar to the Java bean approach, where private fields are created with public getter and setter methods, 
but with less number of lines of code as, getter and setter methods are implicitly provided by Groovy. 
This is why, often, Groovy objects are referred to as Plain Old Groovy Object (POGO).
Methods in Groovy are similar to Java, but the class method's visibility is set to public by default.
To invoke a method on a class, we need to create an object of that class. 
In case of Groovy scripts where you do not provide any class definition, method invocation is done by calling the method by name.
If a method supports a dynamic return type, then the method declaration should start with the def keyword.
In Groovy, non-zero integers, non-null values, nonempty strings, initialized collections, and a valid matcher are evaluated as Boolean true values. 
This is known as Groovy Truths.
Groovy also provides one additional operator known as the Elvis operator. 
It can be used as a shorter version of the ternary operator in the scenario, where the user wants to validate a variable against the null value.
Groovy supports Class, Object, Range, Collection, Pattern, and Closure as classifiers in the switch statement. 
The for-each style is expressed as for(variable in Iterable) { body}.
As loop works on an iterable object collection, it can be easily applied to array, range, collections, and so on.
Apart from Java collection types, Groovy also supports a new collective data type Range. 
It is defined as two values (generally starting point and ending point) separated by two dots.
A Groovy Closure is like a code block written in curly braces. 
Many people associate Closure to be an anonymous function in Java.
Closure in Groovy may accept arguments and returns a value.
By default, the last statement in a Groovy Closure is the return statement.
It means that if you are not explicitly returning any value from Closure, it will by default,
returns the output of the last statement of Closure. 
Commonly, we define a Closure like this {argument list-> closure body}. 
Here, an argument list is a comma separated value that Closure accepts. 
Arguments are optional. If no argument is specified, then one implicit untyped argument named it will be available in the Closure body. 
The argument it will be null if no argument is supplied during Closure invocation.
There could be a situation where we want to execute this closure against another class. This class can be passed to the closure as a delegate.
In this example, the PrintHandler class has defined the myValue variable. We have delegated and executed the closure against the PrintHandler class.
In this scenario, on executing the Closure, we will find the output as I'm owner. This is because, when closure was trying to resolve the myValue variable, 
it found the variable defined within the scope of the owner (the PrintValue class, where the Closure is defined), 
so it didn't delegate the call to the PrintHandler class. Formally, this is known as OWNER_FIRST strategy, which is the default strategy. 
The strategy resolves this way—the closure will be checked first, followed by the closure's scope, then the owner of the closure, 
and, finally, the delegate. Groovy is so flexible that it provides us with the capability to change the strategy. 
For example, to delegate the call to the PrintHandler class, we should specify the strategy as DELEGATE_FIRST:
With the DELEGATE_FIRST strategy, the closure will try to resolve the property or methods to the delegate first and then the owner. 
The other important strategies are:
OWNER_ONLY: It attempts to resolve the property or methods within the owner only and doesn't delegate.
DELEGATE_ONLY: Closure will resolve the property references or methods to the delegate. It completely ignores the owner.
TO_SELF: It will resolve the property references or methods to itself and go through the usual MetaClass look-up process.
