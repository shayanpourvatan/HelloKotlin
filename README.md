In this repo we want to see some basic code in Kotlin language 


**Variables**

In Kotlin you can create your properties in two way.

- 1- mutable property
- 2- immutable property

Objects can be declared as mutable, using the `var` keyword or read-only using the `val` keyword.

syntax of declaring properties:

```
val|var  nameOfProperty: typeOfProperty = value 
```

for getting more see following sample.

```
 val name = "Name"
 var family: String = "family"
 var family2 = "Family2" // <- you can ignore class type if you initialize it
 name = "anotherName" // <- compilation error, you cannot change val value
 family = "anotherFamily"
```

for calling method/properties on objects like Java or similar language you use **`.`** to access those:


```
name.substring(1)
```

If you want to set null value to your object you MUST add `?` after type of object, like follow:

```
var nullableVariable : String? = null

var a: String = "abc"
a = null // compilation error

```
for nullable objects if you don't initialize them you MUST declare class type of object too.

If you want to access the property on null value, that would not be safe, and the compiler reports an error:

```
nullableVariable.length // error: variable 'nullableVariable' can be null
```

For access the property on it you must use safe call operator, written `?.` :

```
nullableVariable?.substring(1)
```

**Functions**


Now, let see how we can declare method in Kotlin:

syntax of declaring method is:

```
fun functionName(argumentName: argumentType , .....) : returnType
```

Sample:

```
fun sampleFunction(name: String,
                   lastName: String): Int {
        return name.length + lastName.length
    }
```

in above sample we define `sampleFunction` that accept two argument, 1- `name`, 2- `lastName`. return type of this method is `Int`

If your method return nothing, your return type is `Unit` (like `void` in Java), you can omit it in function definition:

```
fun sampleFunction2(name: String,
                    lastName: String) {

        // write your logic here.
}
```

Functions in Kotlin is best part with a lot feature, one of theme is named argument, with this feature you can pass method parameter with name of those:

```
sampleFunction(name = "Shayan", lastName = "Pourvatan")
sampleFunction(lastName = "Pourvatan", name = "Shayan")
```

order in naming argument is not matter, with this feature you have a cleaner code.

another feature in Kotlin's method is default parameter, which are used when a corresponding argument is omitted. This allows for a reduced number of overloads compared to other languages.

```
fun sampleFunction(name: String,
                        isFromSearch: Boolean,
                        searchStmt: String = "search",
                        showSeparator: Boolean = false) {

    }

// call this method like
sampleFunction("name" , true)
sampleFunction("name" , true, "new search")
```

if you want to ignore one of middle argument, you must use named argument like:

```
sampleFunction("name" , true, showSeparator = "false" )
```

In Kotlin we don't have a static keyword, But in all project specially in android we have Utils class like Bitmap Util, FileUtil and so on, so how we can write these method?

In Kotlin we have one great feature that we don't need to put methods in class, we can have one file with multiple functions, this feature is `top level function|property` in kotlin.

For using topLevelFunctions you can use `packageName.methodName` like:

```
com.pourvatan.shayan.kotlinSample // <- package name
                .topLevelFunction()  // method name
```


Functions can also be called using infix notations when they have a single parameter:

```
// in sampleClass
infix fun infixSample(name: String) {

}

// you can call it from another class like:

val sampleClass = SampleClass()
sampleClass infixSample "name"
// or
sampleClass.infixSample("name")

```

If you want to pass many parameter to your method like array, you can define it with `vararg`, it's similar to `...` in Java:


```
fun varArgsSample(name: String, vararg other: Int) {

}

// then you can call it like:
varArgsSample("Shayan")
varArgsSample("Shayan", 1)
varArgsSample("Shayan", 1, 4)
varArgsSample("Shayan", 1, 4, 20, 40, 1, 23, 2)
```


**control flow**

Most of the control flow in Kotlin is `expression` (it returns a value)

let's see sample:

```
fun sampleIf() {

        val name: String = "Test"

        // last line in each block will return value
        val nameType = if (name.length > 10) {
            println("long name with size $name.length")
            "Long"
        } else if (name.length > 5) {
            println("normal name length ${name.length}")
            "Normal"
        } else {
            "Short"
        }
    }

```

while/do while in kotlin is similar to Java. those are `statement` (you can't return a value)

```
fun sampleWhile() {

    // it's like java completely
    var index: Int = 10
    while (index > 0) {
         println("$index is bigger than 0")
        index--
    }

    do {
        println("$index is less than 20")
        index++
    } while (index < 20)

}
```

`for` in Kotlin:

```

fun sampleFor() {

        for (index in 0..100) {  // inclusive 0 and 100
            println("index is $index")
        }

        for (index in 0 until 100) { // inclusive 0 exclusive 100
            println("index is $index")
        }

        for (index in 100 downTo 0 step 2) { // inclusive 100 exclusive 0 step 2
            println("index is $index")
        }

        val stringList = mutableListOf("Name", "Name1", "Name2", "Name3")
        for (stringVal in stringList) {
            println("string is $stringVal")
        }


        for ((index, stringVal) in stringList.withIndex()) {
            println("string is $stringVal in $index")
        }

        val hashMap = mutableMapOf("name" to "family",
                "name1" to "family1")

        for ((key, value) in hashMap.entries) {
            println("key is $key and value is $value")
        }
    }
```

you can replace `for` statement with extension methods in collections like:

```
stringList.forEach { println("$it ${it.contains("2")}") }

val lastMax: String? = stringList.maxBy {   it.length } // if many max exists, return first of them
hashMap.forEach { k, v -> println("key is $k and value is $v") }



val mutabelList = stringList
            .filter { it.length > 3 }
            .map { it.length }

// see more for list in https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html
```

another great feature in Kotlin and replacement of `switch/case` in Java is **`when`** expression.

you can use it like:

```
fun sampleWhen() {


    // Any is like Object in java, but it's not same as is.
    val intVal: Any = 10

        
    when {
        intVal == 10 -> println("intVal is 10")
        intVal is Int && intVal < 20 -> {
            println("int value is less than 20")
        }
        intVal is String -> println("smart cast is this ${intVal.substring(1)}")
         else -> println("int value is $intVal")
    }


    when (intVal) {
        is String -> println("with condition")
    }


    val result: String = when (intVal) {
        is Int -> {
            println("another logic")
            "test"
        }
        else -> {   // else must be mentioned
            println("another logic")
            "result is else"
         }
    }
}
```

In above sample we see one another great feature in Kotlin. we can check type of any object in Kotlin with `is` ( like `instanceof` in java) and you can cast your object with `as`.

Kotlin has smart cast feature, that means if you check one object type, in that block you don't need to cast it to use methods on it:

```
 var anyObject : Any = "anyObject"
        
        
if (anyObject is String) {

    // anyObject automatic cast to String and you can use string methods
    anyObject.substring(1)

} else if (anyObject is Int) {

    // anyObject automatic cast to Int and you can use int methods
    anyObject.inc()

} else if (anyObject is Boolean) {

    // anyObject automatic cast to Boolean and you can use boolean methods
     anyObject = true

}
```
**visibility modifiers**

visibility modifiers in Kotlin are similar to those in Java. You have the same public, protected, and private modifiers.
    But the default visibility is different: if you omit a modifier, the declaration becomes public.
in Kotlin you don't hava package private that exists in java, instead of it Kotlin introduce **Internal**



|Modifier                               | Class member                            |Top-level declaration   |
|---------------------------------------|:---------------------------------------:|-----------------------:|
|public (default)                       |Visible everywhere                       |Visible every where
|internal                               |Visible in a module                      |Visible in a module
|protected                              |Visible in sub classes                   |  --
|private                                |Visible in a class                       | Visible in a file


**Class**


You can declare your class as follow:

```
class SimpleClass public constructor() {}
```

if your constructor is public and you don't want change visibility of that you can omit it, if your constructor don't get any parameter you can remove `()` too. so simple class in Kotlin is like:

```
class SimpleClass
```
With class property:

```
class SimpleClass {
    var name: String? = null
    val lastName = "lastName"
}
```

You can define your class with constocture like follow:

```
class ClassWithConstructor(var name: String, val age: Int)
```

you can use this class like:

```
val classObj = ClassWithConstructor("name", 72)
val age = classObj.age
classObj.name = "newName"
```

Sometimes you need to declare secondary constructor, it's very rare in Kotlin because with default parameter in Kotlin you don't need overload constructor. But, if you want to have it you can create your class like follow:

PS: If the class has a primary constructor, each secondary constructor needs to delegate to the primary constructor, either directly or indirectly through another secondary constructor(s). Delegation to another constructor of the same class is done using the `this` keyword:

```
class SecondaryConstructor(name: String, lastName: String, age: Int) {

        constructor(name: String, age: Int) : this(name, "last", age) {
            println("name")
        }

        
        constructor() : this("" , 211)
    }
```

You can have custom getter and setter like follow:

```
 class ClassWithCustomGetter(private var _name: String, private var _age: Int) {

    var age: Int
        get() {
           /* execute getter logic */
             return _age
        }
        set(value) {
             /* execute setter logic */
            _age = value
        }

    var lastName: String?
        get() = lastName ?: "default"
        set(value) {
             println("some other work")
            lastName = value
        }

    var name = _name
        get() {
            return if (_name.contains("name")) "" else _name
        }

    }
```
If you want to do anything after primary constructor and before any other code in class (even secondary constructor block) you can use `init` block in your code like:

```
class ClassWithConstructorAndInit(var name: String, val age: Int) {

    init {
         println("this will call after primary constructor")
        // if you have more than one constructor, and you create object via second constructor
        // this block will run with following priority
        // 1- primary constructor, 2- init block, 3- secondary constructor block
        }
    }
```

Another great feature of Kotlin is `Data` class with some default method.

if you declare your class as `data` the compiler automatically derives the following members from all properties declared in the primary constructor:

- equals(),
- hashCode()
- toString() of the form "DataClass(name=John, age=42)",
- copy() function.

data classes have to fulfil the following requirements:

- The primary constructor needs to have at least one parameter
- All primary constructor parameters need to be marked as val or var
- Data classes cannot be abstract, open, sealed or inner (we explain open, sealed and inner class in continue)


All class|method in Kotlin is `final`, that means you can't create any child or override theme except, you declare your class|function as `open`

if you want create open class you can simply add `open` keyword like:

```
open class OpenClass
```

Now you can inherit from open class with:

```
class InheritFromOpenClass : OpenClass()
```

Sealed classes are used for representing restricted class hierarchies, when a value can have one of the types from a limited set, but cannot have any other type. They are, in a sense, an extension of enum classes: the set of values for an enum type is also restricted, but each enum constant exists only as a single instance, whereas a subclass of a sealed class can have multiple instances which can contain state.

To declare a sealed class, you put the sealed modifier before the name of the class. A sealed class can have subclasses, but all of them must be declared in the same file as the sealed class itself.

```
sealed class Shape
class Square(var width: Int) : Shape()
class Circle(var r: Int) : Shape()
class Rectangle(val w: Int, val h: Int) : Shape()
```

The key benefit of using sealed classes comes into play when you use them in a when expression. If it's possible to verify that the statement covers all cases, you don't need to add an else clause to the statement.


**Extension**

Sometimes we want to add some method to existing class, but we don't want to create sub class and use custom class in hole project, in Kotlin you can simply use `Extension` method|property. so extension methods are methods that we add to existing class without create sub class, you can create extension method| property like follow:

```
fun String.getCurrency() {
    this.substring(12)
}

val String.lastCharIndex: Int
     get() = length / 2

```

in above sample we create one method and one property into String class, and we can use it like:

```
val name : String = "Name"
name.getCurrency()
name.lastCharIndex
```

you can use top level functions to create your own extension method, that you can access those in all project.

**Object**

Sometimes we need to create an object of a slight modification of some class, without explicitly declaring a new subclass for it. Java handles this case with anonymous inner classes. Kotlin slightly generalizes this concept with object expressions and object declarations.

```
abstract class MouseAdapter {
        abstract fun mouseClicked(e: Point)
        abstract fun mouseEntered(e: Point)
    }

fun testAnonymousClass() {

    // call like static method
    SingleObject.singletonMethod()

    val mouseAdapter = object : MouseAdapter() {
        override fun mouseClicked(e: Point) {
            // ...
        }

        override fun mouseEntered(e: Point) {
            // ...
        }
    }

    // or use directly:
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: Point) {
            // ...
        }

        override fun mouseEntered(e: Point) {
            // ...
        }
    })
}
```

Another reason that we might to use Object is `Singleton`. Singleton is a very useful pattern, and Kotlin (after Scala) makes it easy to declare singletons:

```
object SingleObject {

    var singleVariable: Int = 10

    fun singletonMethod() {
        println("variable is ${singleVariable++}")
    }
}
```

An object declaration inside a class can be marked with the companion keyword, companion object is good replace public static in class like your Intent data key

```
class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}


// you can access to it with:
MyClass.create()

```

I wrote this document base on my presentation about Kotlin, I know this is not complete, Kotlin has many many other great feature that I don't mentioned it here.

if you want get more info about kotlin see documentation
