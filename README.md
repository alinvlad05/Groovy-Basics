# Groovy Basics
 Every Groovy type is a subtype of java.lang.Object.<br/>
 As compared to Java, there are no primitive types present in Groovy. <br/>
 Groovy treats everything as an object, which makes Groovy a pure Object Oriented language.<br/>
the power of Groovy lies in dynamic typing. In many scenarios, you are not sure about the kind of value that <br/>
would be stored in the variable or returned by the functions. In that scenario, Groovy provides flexibility to use dynamic typing. <br/>
You can just define a variable or methods by using the def keyword.<br/>
Another use of dynamic typing is calling methods on objects that have no guaranteed type. <br/> 
This is often called duck typing. For example, consider the following scenario where a simple addition method is called on different data types <br/>
such as Integer, List, and String. <br/>
Based on different input parameters, each time the method returns different output.<br/>
Groovy imports six packages and two classes by default.<br/>
Classes and methods in Groovy by default have public access, whereas in Java it is set to package-private.<br/>
We have created fields in the class with no access modifier. If fields are created with default access, <br/>
then Groovy automatically creates a field with public getter and setter methods. <br/>
If we specify any access modifier (public, private, or protected), then only fields will be created; <br/>
no getter or setter method will be created. <br/>
So, each class in Groovy has properties and autocreated getter and setter methods for those properties. <br/>
This is similar to the Java bean approach, where private fields are created with public getter and setter methods, <br/>
but with less number of lines of code as, getter and setter methods are implicitly provided by Groovy. <br/>
This is why, often, Groovy objects are referred to as Plain Old Groovy Object (POGO).<br/>
Methods in Groovy are similar to Java, but the class method's visibility is set to public by default.<br/>
To invoke a method on a class, we need to create an object of that class. <br/>
In case of Groovy scripts where you do not provide any class definition, method invocation is done by calling the method by name.<br/>
If a method supports a dynamic return type, then the method declaration should start with the def keyword.<br/>
In Groovy, non-zero integers, non-null values, nonempty strings, initialized collections, and a valid matcher are evaluated as Boolean true values. <br/>
This is known as Groovy Truths.<br/>
Groovy also provides one additional operator known as the Elvis operator. <br/>
It can be used as a shorter version of the ternary operator in the scenario, where the user wants to validate a variable against the null value.<br/>
Groovy supports Class, Object, Range, Collection, Pattern, and Closure as classifiers in the switch statement. <br/>
The for-each style is expressed as for(variable in Iterable) { body}.<br/>
As loop works on an iterable object collection, it can be easily applied to array, range, collections, and so on.<br/>
Apart from Java collection types, Groovy also supports a new collective data type Range. <br/>
It is defined as two values (generally starting point and ending point) separated by two dots.<br/>
A Groovy Closure is like a code block written in curly braces. <br/>
Many people associate Closure to be an anonymous function in Java.<br/>
Closure in Groovy may accept arguments and returns a value.<br/>
By default, the last statement in a Groovy Closure is the return statement.<br/>
It means that if you are not explicitly returning any value from Closure, it will by default,<br/>
returns the output of the last statement of Closure. <br/>
Commonly, we define a Closure like this {argument list-> closure body}. <br/>
Here, an argument list is a comma separated value that Closure accepts. <br/>
Arguments are optional. If no argument is specified, then one implicit untyped argument named it will be available in the Closure body. <br/>
The argument it will be null if no argument is supplied during Closure invocation.<br/>
There could be a situation where we want to execute this closure against another class. This class can be passed to the closure as a delegate.<br/>
In this example, the PrintHandler class has defined the myValue variable. We have delegated and executed the closure against the PrintHandler class.<br/>
In this scenario, on executing the Closure, we will find the output as I'm owner. This is because, when closure was trying to resolve the myValue variable, <br/>
it found the variable defined within the scope of the owner (the PrintValue class, where the Closure is defined), <br/>
so it didn't delegate the call to the PrintHandler class. Formally, this is known as OWNER_FIRST strategy, which is the default strategy. <br/>
The strategy resolves this way—the closure will be checked first, followed by the closure's scope, then the owner of the closure, <br/>
and, finally, the delegate. Groovy is so flexible that it provides us with the capability to change the strategy. <br/>
For example, to delegate the call to the PrintHandler class, we should specify the strategy as DELEGATE_FIRST:<br/>
With the DELEGATE_FIRST strategy, the closure will try to resolve the property or methods to the delegate first and then the owner. <br/>
The other important strategies are:<br/>
OWNER_ONLY: It attempts to resolve the property or methods within the owner only and doesn't delegate.<br/>
DELEGATE_ONLY: Closure will resolve the property references or methods to the delegate. It completely ignores the owner.<br/>
TO_SELF: It will resolve the property references or methods to itself and go through the usual MetaClass look-up process.<br/>

# Gradle Basics
A build file consists of three phases: initialization, configuration, and execution, which are explained briefly as follows:<br/>
• Initialization creates the project object.<br/>
• The configuration phase configures the project object, creates DAG (Directed Acyclic Graph) based on task dependencies.<br/>
It also executes the project and the task configuration statements.<br/>
• The execution phase finally executes the actions mentioned in the task body.<br/>
The task API mainly defines two types of closures: doFirst(Closure closure) and doLast(Closure closure),<br/>
which internally calls doFirst(Action action) and doLast(Action action). You can mention either one or both of them.<br/>
Statements mentioned outside of these actions are part of your configuration, which are executed during the configuration phase.<br/>

File management <br/>
One of the key features of any build tool is I/O operations and how easily you can perform the I/O operations <br/>
such as reading files, writing files, and  directory-related operations. 
Developers with Ant or Maven backgrounds know  how painful and complex it was <br/>
to handle the files and directory operations in old build tools; <br/>
sometimes you had to write custom tasks and plugins to perform these <br/>
kinds of operations due to XML limitations in Ant and Maven.<br/>
Since Gradle uses Groovy, it will make your life much easier <br/>
while dealing with files and directory-related operations.<br/>

Multi-project structure <br/>
The settings.gradle file is one of the key files in multi-project build.<br/>
This file needs to be present in the root project's directory. It lists all the subprojects.<br/>
To determine if the current build process is part of a multi-project build, it searches for <br/>
the settings.gradle file first in the current directory and then in its parent hierarchy. <br/>
If it finds settings.gradle in the same directory, it considers itself as a parent project <br/>
and then checks for subprojects. In another case, if it finds the settings.gradle file in <br/>
its parent hierarchy, it checks whether or not the current subdirectory is a subproject of <br/>
the root project that is found. If the current project is part of the root project, then it is <br/>
executed as a part of the multi-project build, otherwise, as a single project build.<br/>
Before executing a task in the multi-project build, Gradle will search for the task in <br/>
the root project and in all the subprojects. If the task are found in multiple projects, <br/>
it will execute all the tasks consecutively.<br/>
For example, you want to set some properties in the profile project and you want to use <br/>
those properties in the login project. You can achieve this using evaluationDependsOn. <br/>
To enable this feature, you should have separate build.gradle files for each subproject.<br/>
Partial builds enable you to build only the required project, not its dependency projects. <br/>
command-line option -a can be applied<br/>
