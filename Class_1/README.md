## Class 1

Summary of class:
- [Class](#Class)
- [Java words](#Java-words)
- [Code Structure](#Code-Structure)
- [Write code in Java](#Write-code-in-Java)
- [Share code](#Share-code)
- [System class](#System-class)
- [Documentation](#Documentation)
- [Variables](#Variables)
- [Scanner class](#Scanner-class)
- [Modulo](#Modulo)
- [Casting](#Casting)
- [Static variables](#Static-variables)
- [Errors types](#Errors-types)

## Class


Java is an object-oriented language, and every part of it is considered an object. Each object is defined by a class, and every code segment should be written within a class.

`Class = File`

Every class is defined in its own file. A class is a way to categorize several objects of the same kind.

## Java words

There is few words on Java that related to the langudge, For example:
-`class`
-`main`
-`args`

## Code Structure

* In the end of every command/line there is a need to insert `;`, If will not be it will be error.
* Name of a class will alway be sequence of chars and will start with capital letter - for example `Helloworld`.
* When creating new class there is a need to write the code inside `{}`.
* For every class there is main method - from this method the program will starts to run.
* The main method will always start like the following - `public static void main (String[] args)` which means:
    -`public` - This method is public, in everyone can use it.
    -`static` - We can run this method directly, without the need to create an object to start it.
    -`void` - This method does not return any values when executing it.
    -`main` - This is the name of the method
    -`(String[] args)` - Inside the brackets we insert the parameters that this method will get, in this example the method is expect to get a list of strings.
* For every method there is a need to start and finish the method using `{}`.
* Make sure to add proper identation when writing the code.

## Write code in Java

There are 3 steps to write program in Java:

# Write the code in Jave -
* The name of the file should be as the name of the class
* The file should be with the `.java` extention (Helloworld.java).
* There is a lot of IDE's to write the code at - also notes.

# Complie the code - 
* There is a need to complie the code from Java to languade that the computer understand - `bytecode`.
* The complation will make sure that the text that we wrote is valid.
* After the complation process there will be new file with `.class` extation (will be in the same name as the `.java` name) and will be in `bytecode`.

# Run the program - 
* We will run the program and make sure it's working and there is no `running errors`.

## Share code -
When sharing a code in java, we will share the `.java` file (and send it in `zip` archive).

## System class - 

`System.out.println("Hello World");`

When we using the `System class` we get a lot of method of Java system.
When we use `.` after System we can use the method of System class.
- `out` - standard output - default is the screen.
- `println` - a method that print and add a return key (to move to a new line after the print).
- `print` - a method to print without insert return key.
 * We can use the parameter of the println method that get the parameter of what to print - can be vars, strings...

## Documentation

Above every class and method there will be a Documentation that will be for the programmer to explain the code.
* Full line of description - This kind of line will start with `//` 
* End of line - This description will be in the end of the line and will start in `/*` and will end with `*/`.

## Variables

Variable it's like a storge in the memory that have a name and contains a value of a type.
Type is a kind that the variable can get, this is kind of the types:
 * Full Numbers -
 - `byte` - (1 byte)
 - `short` - Full numbers, low storage (2 bytes)
 - `int`- Full numbers, medium storage (most common) (4 bytes)
 - `long` - Full numbers, high storage (8 bytes)

 * Point Numbers -
 - `float` - low storage (most common) (4 bytes)
 - `double` - high storage (8 bytes)

 * Boolean - contains `True` or `False` (0 or 1) (common)

 * char - one character (common) (2 bytes)

 * variables should only start with lower charachter
 * inside the variable can insert also capital letters, numbers and the symbol `_`
 * between words in var, the second word will always start with capital letter

* See Example1.java

## Math shoutcuts

num1 = num1 + 5 -> num1 += 5;
num2 = num2 * 2 -> num2 *= 2;
num3 = num3 - 4 -> num3 -= 4;

## Onary operators

++x or x++ add 1
--x or x-- remove 1
The differense of the two is the sequence that the tasks is execute -

For example: 
* j = ++i; (change the value of i and insert to the j)
* i = j++; (insert the value of j and then change j value)        


## Scanner class

Helps us to get input from the user.

* In order to use it need to import it into the start of the code:

    `import java.util.Scanner;`

* Also we need to create an object (using a variable) from the class Scanner:

    `Scanner scan = new Scanner(System.in);`

    - `new` - create new object
    - `(System.in)` - the parameter that define the input from the user.

* Method of Scanner class:

    - `nextInt` - get int input
    - `nextDouble` - get double input
    - `nextBoolean` - get boolean input
    - `next().CharAt(0)` - get one character

* See Example2.java

## Modulo

Using modulo we can find what's left after divide one number with another

 For example:
    - 10 % 5 = 0
    - 26 % 5 = 1
    - 17.0 % 3 = 2.0

* Note - When doing modulo between two intergers the sum will be also interger.

## Casting

Using casting we can change one type to another type - can lead to loss data (!)

For example -

* (double)(num1 + num2 + num3) - changing the sum of num1,2,3 that integers to double.

Java always trying to do casting by itself - from smaller types to bigger (without using ()).

# Static variables

We can configure variabels to be static in all of our code.
Always will be written in capitals letters, like the following example:

- final int NUM_OF_STUDENTS = 40;

* `final` - make it static, so the code could not change it during the code
* `int` - kind of static int
* `NUM_OF_STUDENTS` - the defenition of the variable (always will be capital letters and with `_` between the words)

## Errors types

* Compliation error - sytax problems was found during the compling process, for example:
    - line of code that not ends with `;`
    - `{}` problems
    - lower/upper case characters, name of class, variable does not created by used

* Runtime error - The code as been complied successfully but the code didn't function correctly, for example:
    - divide by 0

* Logical error - The code was complied and run successfully but the results was not excpected, for example (most hard to identify):
    - math calculation error